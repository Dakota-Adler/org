package org.lugge.scripts.accountcreator.task.Placement;

import org.lugge.scripts.accountcreator.data.Creation.TilesCreation;
import org.lugge.scripts.accountcreator.data.Placement.SettingsPlacement;
import org.lugge.scripts.accountcreator.data.Placement.TilesPlacement;
import org.powerbot.script.rt6.ClientContext;

public class ConditionsPlacement {
    public static StatesPlacement getCurrentState(ClientContext ctx) {
        switch (ctx.game.clientState()) {
            case 11:
                if (ctx.players.local().tile().distanceTo(TilesCreation.SPAWN_POINT.getTile()) >= 5) {
                    switch (SettingsPlacement.DESTINATION) {
                        case LUMBRIDGE:
                            if (ctx.players.local().tile().equals(TilesPlacement.LUMBRIDGE_LODESTONE.getTile())) {
                                return StatesPlacement.LOG_OUT;
                            }
                            break;
                        case BURTHORPE:
                            if (ctx.players.local().tile().equals(TilesPlacement.BURTHORPE_LODESTONE.getTile())) {
                                return StatesPlacement.LOG_OUT;
                            }
                            break;
                        case VARROCK:
                            if (ctx.varpbits.varpbit(3) == -1807742844) {
                                if (ctx.players.local().tile().distanceTo(TilesPlacement.GRAND_EXCHANGE.getTile()) <= 5) {
                                    return StatesPlacement.LOG_OUT;
                                } else {
                                    if (ctx.players.local().tile().y() >= 3375) {
                                        return StatesPlacement.WALK_GRAND_EXCHANGE;
                                    } else {
                                        return StatesPlacement.WALK_VARROCK_LODESTONE;
                                    }
                                }
                            } else {
                                if (ctx.players.local().tile().distanceTo(TilesPlacement.VARROCK_LODESTONE.getTile()) <= 5) {
                                    return StatesPlacement.ACTIVATE_VARROCK_LODESTONE;
                                } else {
                                    return StatesPlacement.WALK_VARROCK_LODESTONE;
                                }
                            }
                    }
                }
                switch (SettingsPlacement.DESTINATION) {
                    case LUMBRIDGE:
                        return StatesPlacement.TELEPORT_LUMBRIDGE;
                    case BURTHORPE:
                        return StatesPlacement.TELEPORT_BURTHORPE;
                    case VARROCK:
                        return StatesPlacement.TELEPORT_LUMBRIDGE;
                    case NULL:
                        return StatesPlacement.LOG_OUT;
                }
        }
        return StatesPlacement.NULL;
    }
}
