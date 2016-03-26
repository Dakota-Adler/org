package org.lugge.scripts.accountcreator.data.Options;

import org.powerbot.script.Tile;

public enum TilesOptions {
    SPAWN_POINT(new Tile(2865, 3409, 0));

    private final Tile tile;

    TilesOptions(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return this.tile;
    }
}
