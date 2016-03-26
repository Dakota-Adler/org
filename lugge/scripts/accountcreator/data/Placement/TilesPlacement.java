package org.lugge.scripts.accountcreator.data.Placement;

import org.powerbot.script.Tile;

public enum TilesPlacement {
    BURTHORPE_LODESTONE(new Tile(2899, 3544, 0)),
    LUMBRIDGE_LODESTONE(new Tile(3233, 3221, 0)),
    VARROCK_LODESTONE(new Tile(3212, 3377, 0)),
    GRAND_EXCHANGE(new Tile(3164, 3474, 0)),
    SPAWN_POINT(new Tile(2865, 3409, 0));

    private final Tile tile;

    TilesPlacement(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return this.tile;
    }
}
