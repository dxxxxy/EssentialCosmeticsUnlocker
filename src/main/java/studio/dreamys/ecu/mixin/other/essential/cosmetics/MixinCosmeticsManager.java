package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import com.google.common.collect.ImmutableMap;
import gg.essential.gui.elementa.state.v2.State;
import gg.essential.gui.elementa.state.v2.StateKt;
import gg.essential.gui.notification.Notifications;
import gg.essential.mod.cosmetics.CosmeticSlot;
import gg.essential.network.connectionmanager.ConnectionManager;
import gg.essential.network.connectionmanager.cosmetics.CosmeticsData;
import gg.essential.network.connectionmanager.cosmetics.CosmeticsManager;
import gg.essential.network.connectionmanager.cosmetics.EquippedCosmeticsManager;
import gg.essential.network.cosmetics.Cosmetic;
import gg.essential.util.UUIDUtil;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@Mixin(value = CosmeticsManager.class, remap = false)
public abstract class MixinCosmeticsManager {
    public Map<CosmeticSlot, String> map = new HashMap<>();

    @Shadow
    @Final
    private @NotNull EquippedCosmeticsManager equippedCosmeticsManager;

    @Shadow
    public abstract @NotNull CosmeticsData getCosmeticsData();

    @Shadow
    public abstract boolean getOwnCosmeticsVisible();

    @Overwrite
    public @NotNull State<Set<String>> getUnlockedCosmetics() {
        return StateKt.stateOf(getCosmeticsData().getCosmetics().get().stream().map(Cosmetic::getId).collect(Collectors.toSet()));
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void CosmeticManager(ConnectionManager connectionManager, File baseDir, CallbackInfo ci) {
        //load config
        try {
            System.out.println("[EssentialCosmeticsUnlocker] Loading config");

            //create if doesnt exist
            File configFile = new File(new File(Minecraft.getMinecraft().mcDataDir, "ecu"), "ecu.txt");
            configFile.getParentFile().mkdirs();

            Scanner sc = new Scanner(configFile);

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split("=");
                map.put(CosmeticSlot.Companion.of(line[0]), line[1]);
            }

            if (map.isEmpty()) return;
            System.out.println("[EssentialCosmeticsUnlocker] Config loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[EssentialCosmeticsUnlocker] Could not load config file");
        }
    }

    @Inject(method = "resetState", at = @At("TAIL"))
    public void resetState(CallbackInfo ci) {
        equippedCosmeticsManager.update(UUIDUtil.getClientUUID(), map, Collections.emptyMap());
    }

    @Inject(method = "toggleOwnCosmeticVisibility", at = @At("HEAD"))
    public void toggleOwnCosmeticVisibility(boolean notification, CallbackInfo ci) {
        if (getOwnCosmeticsVisible()) return;
        Notifications.INSTANCE.push("EssentialCosmeticsUnlocker", "Loaded cosmetics from config.");
        equippedCosmeticsManager.update(UUIDUtil.getClientUUID(), map, Collections.emptyMap());
    }

    @Overwrite
    public @NotNull Map<CosmeticSlot, String> getEquippedCosmetics() {
        ImmutableMap<CosmeticSlot, String> result = ImmutableMap.copyOf(map);
        return result != null ? result : ImmutableMap.of();
    }

    @Inject(method = "updateEquippedCosmetic(Lgg/essential/mod/cosmetics/CosmeticSlot;Ljava/lang/String;)V", at = @At("HEAD"))
    public void updateEquippedCosmetic(CosmeticSlot slot, String cosmeticId, CallbackInfo ci) {
        if (cosmeticId != null) map.put(slot, cosmeticId);
        else map.remove(slot);

        //save config
        try {
            System.out.println("[EssentialCosmeticsUnlocker] Saving config");
            PrintWriter pw = new PrintWriter(new File(new File(Minecraft.getMinecraft().mcDataDir, "ecu"), "ecu.txt"));

            for (Map.Entry<CosmeticSlot, String> entry : map.entrySet()) {
                pw.println(entry.getKey().getId() + "=" + entry.getValue());
            }

            pw.close();
            System.out.println("[EssentialCosmeticsUnlocker] Config saved");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[EssentialCosmeticsUnlocker] Could not save config file");
        }
    }
}
