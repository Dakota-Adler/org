package org.lugge.scripts.accountcreator.task.SuperState;

import org.lugge.scripts.accountcreator.task.Creation.ActionsCreation;
import org.lugge.scripts.accountcreator.task.Creation.ConditionsCreation;
import org.lugge.scripts.accountcreator.task.Options.ActionsOptions;
import org.lugge.scripts.accountcreator.task.Options.ConditionsOptions;
import org.lugge.scripts.accountcreator.task.Placement.ActionsPlacement;
import org.lugge.scripts.accountcreator.task.Placement.ConditionsPlacement;
import org.lugge.scripts.accountcreator.util.Paint;
import org.powerbot.script.rt6.ClientContext;

public class ActionsSuperState {
    public static void createAccount(ClientContext ctx) {
        switch (ConditionsCreation.getCurrentState(ctx)) {
            case START_CREATION:
                ActionsCreation.startCreation(ctx);
                break;
            case SELECT_MALE:
                ActionsCreation.selectMale(ctx);
                break;
            case SELECT_FEMALE:
                ActionsCreation.selectFemale(ctx);
                break;
            case FINISH_DESIGN:
                ActionsCreation.finishDesign(ctx);
                break;
            case RANDOMISE_NAME:
                ActionsCreation.randomiseName(ctx);
                break;
            case ENTER_NAME:
                ActionsCreation.enterName(ctx);
                break;
            case DELETE_NAME:
                ActionsCreation.deleteName(ctx);
                break;
            case ENTER_AGE:
                ActionsCreation.enterAge(ctx);
                break;
            case DELETE_AGE:
                ActionsCreation.deleteAge(ctx);
                break;
            case ENTER_EMAIL:
                ActionsCreation.enterEmail(ctx);
                break;
            case DELETE_EMAIL:
                ActionsCreation.deleteEmail(ctx);
                break;
            case ENTER_PASSWORD:
                ActionsCreation.enterPassword(ctx);
                break;
            case DELETE_PASSWORD:
                ActionsCreation.deletePassword(ctx);
                break;
            case FINISH_CREATION:
                ActionsCreation.finishCreation(ctx);
                break;
            case SKIP_CUT_SCENE:
                ActionsCreation.skipCutScene(ctx);
                break;
            case SKIP_TUTORIAL:
                ActionsCreation.skipTutorial(ctx);
                break;
            case END_SCRIPT:
                ActionsCreation.endScript(ctx);
                break;
            case NULL:
                Paint.setStatus("NULL");
                break;
        }
    }

    public static void changeOptions(ClientContext ctx) {
        switch (ConditionsOptions.getCurrentState(ctx)) {
            case OPEN_GAME_SETTINGS:
                ActionsOptions.openGameSettings(ctx);
                break;
            case DISABLE_HINTS:
                ActionsOptions.disableHints(ctx);
                break;
            case ENABLE_LEGACY_LAYOUT:
                ActionsOptions.enableLegacyLayout(ctx);
                break;
            case SWITCH_TO_LEGACY:
                ActionsOptions.switchToLegacy(ctx);
                break;
            case CLOSE_GAME_SETTINGS:
                ActionsOptions.closeGameSettings(ctx);
                break;
            case NULL:
                Paint.setStatus("NULL");
                break;
        }
    }

    public static void placeAccount(ClientContext ctx) {
        switch (ConditionsPlacement.getCurrentState(ctx)) {
            case TELEPORT_BURTHORPE:
                ActionsPlacement.teleportBurthorpe(ctx);
                break;
            case TELEPORT_LUMBRIDGE:
                ActionsPlacement.teleportLumbridge(ctx);
                break;
            case WALK_VARROCK_LODESTONE:
                ActionsPlacement.walkVarrockLodestone(ctx);
                break;
            case ACTIVATE_VARROCK_LODESTONE:
                ActionsPlacement.activateVarrockLodestone(ctx);
                break;
            case WALK_GRAND_EXCHANGE:
                ActionsPlacement.walkGrandExchange(ctx);
                break;
            case LOG_OUT:
                ActionsPlacement.logOut(ctx);
                break;
            case END_SCRIPT:
                ActionsPlacement.endScript(ctx);
                break;
            case NULL:
                Paint.setStatus("NULL");
                break;
        }
    }
}
