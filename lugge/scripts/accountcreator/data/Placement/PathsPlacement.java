package org.lugge.scripts.accountcreator.data.Placement;

import org.powerbot.script.Tile;

public enum PathsPlacement {
    TO_VARROCK(new Tile[] {
            new Tile(3233, 3221, 0),
            new Tile(3246, 3226, 0),
            new Tile(3259, 3234, 0),
            new Tile(3255, 3247, 0),
            new Tile(3250, 3260, 0),
            new Tile(3243, 3274, 0),
            new Tile(3238, 3289, 0),
            new Tile(3237, 3305, 0),
            new Tile(3236, 3319, 0),
            new Tile(3239, 3332, 0),
            new Tile(3226, 3341, 0),
            new Tile(3223, 3355, 0),
            new Tile(3216, 3365, 0),
            new Tile(3212, 3377, 0)
    }),

    TO_GRAND_EXCHANGE(new Tile[] {
            new Tile(3212, 3389, 0),
            new Tile(3211, 3394, 0),
            new Tile(3204, 3408, 0),
            new Tile(3198, 3420, 0),
            new Tile(3186, 3430, 0),
            new Tile(3186, 3444, 0),
            new Tile(3173, 3453, 0),
            new Tile(3165, 3468, 0),
            new Tile(3164, 3474, 0)
    });

    private final Tile[] path;

    PathsPlacement(Tile[] path) {
        this.path = path;
    }

    public Tile[] getPath() {
        return this.path;
    }

}
