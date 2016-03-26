package org.lugge.scripts.accountcreator.task.Creation;

import org.lugge.scripts.accountcreator.data.Creation.SettingsCreation;
import org.lugge.scripts.accountcreator.data.Creation.TilesCreation;
import org.lugge.scripts.accountcreator.data.Creation.VariablesCreation;
import org.lugge.scripts.accountcreator.data.Creation.WidgetsCreation;
import org.lugge.scripts.accountcreator.util.Interface;
import org.powerbot.script.rt6.ClientContext;

public class ConditionsCreation {
    public static StatesCreation getCurrentState(ClientContext ctx) {
        switch (ctx.game.clientState()) {
            case -1:
                if (Interface.getComponent(WidgetsCreation.DESIGN_DONE, ctx).visible() && !Interface.getComponent(WidgetsCreation.RANDOMISE_NAME, ctx).visible()) {
                    switch (SettingsCreation.GENDER) {
                        case MALE:
                            if (Interface.getComponent(WidgetsCreation.SELECT_MALE, ctx).visible()) {
                                return StatesCreation.FINISH_DESIGN;
                            } else {
                                return StatesCreation.SELECT_MALE;
                            }
                        case FEMALE:
                            if (Interface.getComponent(WidgetsCreation.SELECT_FEMALE, ctx).visible()) {
                                return StatesCreation.FINISH_DESIGN;
                            } else {
                                return StatesCreation.SELECT_FEMALE;
                            }
                        case RANDOM:
                            return StatesCreation.FINISH_DESIGN;
                    }
                }
                if (Interface.getComponent(WidgetsCreation.RANDOMISE_NAME, ctx).visible()) {
                    switch (Interface.checkBoxes(WidgetsCreation.VALID_NAME, ctx)) {
                        case VALID:
                            switch (Interface.checkBoxes(WidgetsCreation.VALID_AGE, ctx)) {
                                case VALID:
                                    switch (Interface.checkBoxes(WidgetsCreation.VALID_EMAIL, ctx)) {
                                        case VALID:
                                            switch (Interface.checkBoxes(WidgetsCreation.VALID_PASSWORD, ctx)) {
                                                case VALID:
                                                    return StatesCreation.FINISH_CREATION;
                                                case INVALID:
                                                    if (Interface.getComponent(WidgetsCreation.PASSWORD_FIELD, ctx).text().isEmpty()) {
                                                        return StatesCreation.ENTER_PASSWORD;
                                                    } else {
                                                        return StatesCreation.DELETE_PASSWORD;
                                                    }
                                                case UNKNOWN:
                                                    if (Interface.getComponent(WidgetsCreation.PASSWORD_FIELD, ctx).text().isEmpty()) {
                                                        return StatesCreation.ENTER_PASSWORD;
                                                    }
                                            }
                                        case INVALID:
                                            if (Interface.getComponent(WidgetsCreation.EMAIL_FIELD, ctx).text().isEmpty()) {
                                                return StatesCreation.ENTER_EMAIL;
                                            } else {
                                                if (Interface.getComponent(WidgetsCreation.EMAIL_IN_USE, ctx).visible()) {
                                                    VariablesCreation.extension++;
                                                    return StatesCreation.DELETE_EMAIL;
                                                }
                                                return StatesCreation.DELETE_EMAIL;
                                            }
                                        case UNKNOWN:
                                            if (Interface.getComponent(WidgetsCreation.EMAIL_FIELD, ctx).text().isEmpty()) {
                                                return StatesCreation.ENTER_EMAIL;
                                            }
                                    }
                                case INVALID:
                                    if (Interface.getComponent(WidgetsCreation.AGE_FIELD, ctx).text().isEmpty()) {
                                        return StatesCreation.ENTER_AGE;
                                    } else {
                                        return StatesCreation.DELETE_AGE;
                                    }
                                case UNKNOWN:
                                    if (Interface.getComponent(WidgetsCreation.AGE_FIELD, ctx).text().isEmpty()) {
                                        return StatesCreation.ENTER_AGE;
                                    }
                            }
                        case INVALID:
                            if (SettingsCreation.NAME == null) {
                                return StatesCreation.RANDOMISE_NAME;
                            } else {
                                if (Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).text().isEmpty()) {
                                    return StatesCreation.ENTER_NAME;
                                } else {
                                    return StatesCreation.DELETE_NAME;
                                }

                            }
                        case UNKNOWN:
                            if (SettingsCreation.NAME == null) {
                                return StatesCreation.RANDOMISE_NAME;
                            } else {
                                if (Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).text().isEmpty()) {
                                    return StatesCreation.ENTER_NAME;
                                }
                            }
                    }
                }
                break;
            case 3:
                if (SettingsCreation.QUANTITY > VariablesCreation.accountsCreated) {
                    return StatesCreation.START_CREATION;
                } else {
                    return StatesCreation.END_SCRIPT;
                }
            case 11:
                if (!ctx.players.local().tile().equals(TilesCreation.SPAWN_POINT.getTile())) {
                    if (Interface.getComponent(WidgetsCreation.SKIP_CUT_SCENE, ctx).visible()) {
                        return StatesCreation.SKIP_CUT_SCENE;
                    } else if (Interface.getComponent(WidgetsCreation.ARRIVED, ctx).visible()) {
                        return StatesCreation.SKIP_TUTORIAL;
                    }
                }
        }
        return StatesCreation.NULL;
    }
}
