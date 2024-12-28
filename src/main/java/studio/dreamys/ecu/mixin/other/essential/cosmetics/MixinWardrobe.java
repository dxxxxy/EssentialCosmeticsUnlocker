package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import gg.essential.elementa.ElementaVersion;
import gg.essential.gui.InternalEssentialGUI;
import gg.essential.gui.wardrobe.Wardrobe;
import gg.essential.gui.wardrobe.WardrobeState;
import gg.essential.network.connectionmanager.cosmetics.CosmeticsManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import studio.dreamys.ecu.IMixinCosmeticsManager;

@Mixin(value = Wardrobe.class, remap = false)
public class MixinWardrobe extends InternalEssentialGUI {
    @Final
    @Shadow
    private @NotNull CosmeticsManager cosmeticsManager;

    @Final
    @Shadow
    private @NotNull WardrobeState state;

    public MixinWardrobe(@NotNull ElementaVersion version, @NotNull String guiTitle, int newGuiScale, boolean restorePreviousGuiOnClose, @Nullable String discordActivityDescription) {
        super(version, guiTitle, newGuiScale, restorePreviousGuiOnClose, discordActivityDescription);
    }

//    @Inject(method = "<init>(Lgg/essential/gui/wardrobe/WardrobeCategory;Z)V", at = @At("TAIL"))
//    public void Wardrobe(WardrobeCategory category, boolean bl, CallbackInfo ci) {
//        ((IMixinCosmeticsManager) cosmeticsManager).essentialCosmeticsUnlocker$onWardrobeStateUpdated(state);
//    }

//    @Inject(method = "onScreenClose", at = @At("TAIL"))
//    public void onScreenClose(CallbackInfo ci) {
//        ((IMixinCosmeticsManager) cosmeticsManager).essentialCosmeticsUnlocker$onWardrobeStateUpdated(state);
//    }

    @Overwrite
    public void onScreenClose() {
        ((IMixinCosmeticsManager) cosmeticsManager).essentialCosmeticsUnlocker$onWardrobeStateUpdated(state);
        super.onScreenClose();
    }
}
