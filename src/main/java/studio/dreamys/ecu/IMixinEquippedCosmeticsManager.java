package studio.dreamys.ecu;

import gg.essential.gui.wardrobe.WardrobeState;

public interface IMixinEquippedCosmeticsManager {
    void essentialCosmeticsUnlocker$onWardrobeStateUpdated(WardrobeState wardrobeState);
}
