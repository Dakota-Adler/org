package org.lugge.scripts.accountcreator.task.SuperState;

import org.lugge.scripts.accountcreator.data.Creation.TilesCreation;
import org.lugge.scripts.accountcreator.task.Options.ConditionsOptions;
import org.lugge.scripts.accountcreator.task.Options.StatesOptions;
import org.lugge.scripts.accountcreator.util.Paint;
import org.powerbot.script.rt6.ClientContext;

public class ConditionsSuperState {
    public static StatesSuperState getSuperState(ClientContext ctx) {
        switch (ctx.game.clientState()) {
            case -1:
                return StatesSuperState.CREATE_ACCOUNT;
            case 3:
                return StatesSuperState.CREATE_ACCOUNT;
            case 11:
                if(ctx.players.local().tile().floor() == 2) {
                    return StatesSuperState.CREATE_ACCOUNT;
                }else{
                    if(ConditionsOptions.getCurrentState(ctx) == StatesOptions.NULL) {
                        return StatesSuperState.PLACE_ACCOUNT;
                    }else {
                        if(ctx.players.local().tile().distanceTo(TilesCreation.SPAWN_POINT.getTile()) <= 5) {
                            Paint.setStatus(ConditionsOptions.getCurrentState(ctx).toString());
                            return StatesSuperState.CHANGE_OPTIONS;
                        }
                    }
                }
        }
        return StatesSuperState.NULL;
    }
}
