package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import com.sparkuniverse.toolbox.util.DateTime;
import gg.essential.cosmetics.model.CosmeticUnlockData;
import gg.essential.gui.elementa.state.v2.State;
import gg.essential.gui.elementa.state.v2.StateKt;
import gg.essential.gui.wardrobe.WardrobeState;
import gg.essential.network.connectionmanager.cosmetics.CosmeticsData;
import gg.essential.network.connectionmanager.cosmetics.CosmeticsManager;
import gg.essential.network.connectionmanager.cosmetics.EquippedCosmeticsManager;
import gg.essential.network.cosmetics.Cosmetic;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import studio.dreamys.ecu.IMixinCosmeticsManager;
import studio.dreamys.ecu.IMixinEquippedCosmeticsManager;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Mixin(value = CosmeticsManager.class, remap = false)
public abstract class MixinCosmeticsManager implements IMixinCosmeticsManager {
    @Final
    @Shadow
    private @NotNull EquippedCosmeticsManager equippedCosmeticsManager;

    @Final
    @Shadow
    private @NotNull CosmeticsData cosmeticsData;

    @Overwrite
    public @NotNull State<Set<String>> getUnlockedCosmetics() {
        return StateKt.stateOf(cosmeticsData.getCosmetics().getUntracked().stream().map(Cosmetic::getId).collect(Collectors.toSet()));
    }

    @Overwrite
    public State<Map<String, CosmeticUnlockData>> getUnlockedCosmeticsData() {
        return StateKt.stateOf(cosmeticsData.getCosmetics().getUntracked().stream().collect(Collectors.toMap(Cosmetic::getId, (v) -> new CosmeticUnlockData(new DateTime(), null, true))));
    }

    @Override
    public void essentialCosmeticsUnlocker$onWardrobeStateUpdated(WardrobeState wardrobeState) {
        ((IMixinEquippedCosmeticsManager) (Object) equippedCosmeticsManager).essentialCosmeticsUnlocker$onWardrobeStateUpdated(wardrobeState);
    }
}
