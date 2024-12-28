package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import gg.essential.gui.elementa.state.v2.MutableState;
import gg.essential.gui.wardrobe.WardrobeState;
import gg.essential.mod.cosmetics.settings.CosmeticSetting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(value = WardrobeState.class, remap = false)
public interface IWardrobeState {
    @Accessor
    Map<String, Map<String, MutableState<CosmeticSetting.PlayerPositionAdjustment>>> getCosmeticPositionStates();

    @Accessor
    Map<String, Map<String, MutableState<CosmeticSetting.Side>>> getCosmeticSideStates();

    @Accessor
    Map<String, Map<String, MutableState<CosmeticSetting.Variant>>> getCosmeticVariantStates();
}
