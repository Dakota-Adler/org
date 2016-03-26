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
        switch(ConditionsCreation.getCurrentState(ctx)) {
            case START_CREATION:
                ActionsCreation.StartCreation(ctx);
                break;
            case SELECT_MALE:
                ActionsCreation.SelectMale(ctx);
                break;
            case SELECT_FEMALE:
                ActionsCreation.SelectFemale(ctx);
                break;
            case FINISH_DESIGN:
                ActionsCreation.FinishDesign(ctx);
                break;
            case RANDOMISE_NAME:
                ActionsCreation.RandomiseName(ctx);
                break;
            case ENTER_NAME:
                ActionsCreation.EnterName(ctx);
                break;
            case DELETE_NAME:
                ActionsCreation.DeleteName(ctx);
                break;
            case ENTER_AGE:
                ActionsCreation.EnterAge(ctx);
                break;
            case DELETE_AGE:
                ActionsCreation.DeleteAge(ctx);
                break;
            case ENTER_EMAIL:
                ActionsCreation.EnterEmail(ctx);
                break;
            case DELETE_EMAIL:
                ActionsCreation.DeleteEmail(ctx);
                break;
            case ENTER_PASSWORD:
                ActionsCreation.EnterPassword(ctx);
                break;
            case DELETE_PASSWORD:
                ActionsCreation.DeletePassword(ctx);
                break;
            case FINISH_CREATION:
                ActionsCreation.FinishCreation(ctx);
                break;
            case SKIP_CUT_SCENE:
                ActionsCreation.SkipCutScene(ctx);
                break;
            case SKIP_TUTORIAL:
                ActionsCreation.SkipTutorial(ctx);
                break;
            case END_SCRIPT:
                ActionsCreation.EndScript(ctx);
                break;
            case NULL:
                Paint.setStatus("NULL");
                break;
        }
    }

    public static void changeOptions(ClientContext ctx) {
        switch (ConditionsOptions.getCurrentState(ctx)) {
            case OPEN_GAME_SETTINGS:
                ActionsOptions.OpenGameSettings(ctx);
                break;
            case DISABLE_HINTS:
                ActionsOptions.DisableHints(ctx);
                break;
            case ENABLE_LEGACY_LAYOUT:
                ActionsOptions.EnableLegacyLayout(ctx);
                break;
            case SWITCH_TO_LEGACY:
                ActionsOptions.SwitchToLegacy(ctx);
                break;
            case CLOSE_GAME_SETTINGS:
                ActionsOptions.CloseGameSettings(ctx);
                break;
            case NULL:
                Paint.setStatus("NULL");
                break;
        }
    }

    public static void placeAccount(ClientContext ctx) {
        switch (ConditionsPlacement.getCurrentState(ctx)) {
            case TELEPORT_BURTHORPE:
                ActionsPlacement.TeleportBurthorpe(ctx);
                break;
            case TELEPORT_LUMBRIDGE:
                ActionsPlacement.TeleportLumbridge(ctx);
                break;
            case WALK_VARROCK_LODESTONE:
                ActionsPlacement.WalkVarrockLodestone(ctx);
                break;
            case ACTIVATE_VARROCK_LODESTONE:
                ActionsPlacement.ActivateVarrockLodestone(ctx);
                break;
            case WALK_GRAND_EXCHANGE:
                ActionsPlacement.WalkGrandExchange(ctx);
                break;
            case LOG_OUT:
                ActionsPlacement.LogOut(ctx);
                break;
            case END_SCRIPT:
                ActionsPlacement.EndScript(ctx);
                break;
            case NULL:
                Paint.setStatus("NULL");
                break;
        }
    }
}
