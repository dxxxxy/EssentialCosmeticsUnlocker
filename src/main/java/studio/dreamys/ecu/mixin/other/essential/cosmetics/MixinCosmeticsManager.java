package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import com.google.common.collect.ImmutableMap;
import gg.essential.gui.notification.Notifications;
import gg.essential.mod.cosmetics.CosmeticSlot;
import gg.essential.network.connectionmanager.ConnectionManager;
import gg.essential.network.connectionmanager.cosmetics.CosmeticsManager;
import gg.essential.network.cosmetics.Cosmetic;
import gg.essential.util.UUIDUtil;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
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
    public abstract @NotNull Map<String, Cosmetic> getCosmetics();

    @Shadow
    public abstract void setEquippedCosmetics(@NotNull UUID playerId, @NotNull Map<CosmeticSlot, String> equippedCosmetics);

    @Shadow
    private boolean ownCosmeticsVisible;

    @Overwrite
    public @NotNull Set<String> getUnlockedCosmetics() {
        return getCosmetics().keySet();
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void CosmeticManager(ConnectionManager connectionManager, CallbackInfo ci) {
        //load config
        try {
            System.out.println("[EssentialCosmeticsUnlocker] Loading config");
            Scanner sc = new Scanner(new File(Minecraft.getMinecraft().mcDataDir, "ecu.txt"));
            String line = sc.nextLine();
            map = Arrays.stream(line.replaceAll("[{}]", " ").split(",")).map(s -> s.split("=", 2)).collect(Collectors.toMap(s -> CosmeticSlot.valueOf(s[0].trim()), s -> s[1].trim()));
            if (map.isEmpty()) return;
            System.out.println("[EssentialCosmeticsUnlocker] Config loaded");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[EssentialCosmeticsUnlocker] Could not load config file");
        }
    }

    @Inject(method = "toggleOwnCosmeticVisibility", at = @At("HEAD"))
    public void toggleOwnCosmeticVisibility(boolean notification, CallbackInfo ci) {
        if (ownCosmeticsVisible) return;
        Notifications.INSTANCE.push("EssentialCosmeticsUnlocker", "Loaded cosmetics from config.");
        setEquippedCosmetics(UUIDUtil.getClientUUID(), map);
    }

    @Overwrite
    public @NotNull ImmutableMap<CosmeticSlot, String> getEquippedCosmetics() {
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
            PrintWriter pw = new PrintWriter(new File(Minecraft.getMinecraft().mcDataDir, "ecu.txt"));
            pw.println(map);
            pw.close();
            System.out.println("[EssentialCosmeticsUnlocker] Config saved");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[EssentialCosmeticsUnlocker] Could not save config file");
        }
    }
}
