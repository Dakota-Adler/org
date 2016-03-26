package org.lugge.scripts.accountcreator.data.Creation;

import org.powerbot.script.Tile;

public enum TilesCreation {
    SPAWN_POINT(new Tile(2866, 3409, 0));

    private final Tile tile;

    TilesCreation(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return this.tile;
    }
}
