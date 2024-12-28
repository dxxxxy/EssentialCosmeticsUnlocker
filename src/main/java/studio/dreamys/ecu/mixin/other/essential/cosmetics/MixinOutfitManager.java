package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import gg.essential.network.connectionmanager.cosmetics.OutfitManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = OutfitManager.class, remap = false)
public class MixinOutfitManager {
    @Overwrite
    public final void flushSelectedOutfit(boolean debounce) {

    }

    @Overwrite
    public final void cleanUpUnusedSettingsOnOutfits() {
        System.out.println("haha");
    }
}
