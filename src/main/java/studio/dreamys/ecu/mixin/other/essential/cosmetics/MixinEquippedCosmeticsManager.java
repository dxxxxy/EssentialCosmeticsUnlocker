package studio.dreamys.ecu.mixin.other.essential.cosmetics;

import gg.essential.gui.elementa.state.v2.MutableState;
import gg.essential.gui.wardrobe.WardrobeState;
import gg.essential.mod.cosmetics.CosmeticSlot;
import gg.essential.mod.cosmetics.settings.CosmeticSetting;
import gg.essential.network.CMConnection;
import gg.essential.network.connectionmanager.ConnectionManager;
import gg.essential.network.connectionmanager.cosmetics.EquippedCosmeticsManager;
import gg.essential.util.USession;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import studio.dreamys.ecu.IMixinEquippedCosmeticsManager;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mixin(value = EquippedCosmeticsManager.class, remap = false)
public abstract class MixinEquippedCosmeticsManager implements IMixinEquippedCosmeticsManager {
    @Final
    @Shadow
    private @NotNull Map<UUID, Map<CosmeticSlot, String>> equippedCosmetics;

    @Final
    @Shadow
    private @NotNull Map<UUID, Map<String, List<CosmeticSetting>>> cosmeticSettings;

    @Final
    @Shadow
    private @NotNull CMConnection connectionManager;

    @Shadow
    protected abstract void updateVisibleCosmetics(UUID playerId);

    @SuppressWarnings("DataFlowIssue")
    @Override
    public void essentialCosmeticsUnlocker$onWardrobeStateUpdated(WardrobeState wardrobeState) {
        UUID uuid = USession.Companion.activeNow().getUuid();
        equippedCosmetics.put(uuid, wardrobeState.getEquippedCosmeticsState().getUntracked());

        Map<String, Map<String, MutableState<CosmeticSetting.PlayerPositionAdjustment>>> cosmeticPositionStates = ((IWardrobeState) (Object) wardrobeState).getCosmeticPositionStates();
        Map<String, Map<String, MutableState<CosmeticSetting.Side>>> cosmeticSideStates = ((IWardrobeState) (Object) wardrobeState).getCosmeticSideStates();
        Map<String, Map<String, MutableState<CosmeticSetting.Variant>>> cosmeticVariantStates = ((IWardrobeState) (Object) wardrobeState).getCosmeticVariantStates();

        Map<String, List<CosmeticSetting>> allCosmeticSettings = Stream.of(cosmeticPositionStates, cosmeticSideStates, cosmeticVariantStates)
                .map(Map::values)
                .flatMap(Collection::stream)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .filter(entry -> entry.getValue().getUntracked() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, (entry) -> new ArrayList<>(Collections.singletonList(entry.getValue().getUntracked())), (a, b) -> {
                    a.addAll(b);
                    return a;
                }));

//        ConnectionManager connectionManager1 = ((ConnectionManager) connectionManager);

//        if (!allCosmeticSettings.isEmpty()) {
//            for (Map.Entry<String, List<CosmeticSetting>> entry : allCosmeticSettings.entrySet()) {
//                connectionManager1.getOutfitManager().updateOutfitCosmeticSettings(connectionManager1.getOutfitManager().getSelectedOutfitId().getUntracked(), entry.getKey(), entry.getValue());
//            }

            cosmeticSettings.put(uuid, allCosmeticSettings);
            updateVisibleCosmetics(uuid);
//        }

    }
}
