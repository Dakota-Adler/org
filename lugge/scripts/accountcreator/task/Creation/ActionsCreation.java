package org.lugge.scripts.accountcreator.task.Creation;

import org.lugge.scripts.accountcreator.data.Creation.SettingsCreation;
import org.lugge.scripts.accountcreator.data.Creation.TilesCreation;
import org.lugge.scripts.accountcreator.data.Creation.VariablesCreation;
import org.lugge.scripts.accountcreator.data.Creation.WidgetsCreation;
import org.lugge.scripts.accountcreator.util.File;
import org.lugge.scripts.accountcreator.util.Interface;
import org.lugge.scripts.accountcreator.util.Paint;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Hud;

import java.util.concurrent.Callable;

public class ActionsCreation {
    public static void startCreation(ClientContext ctx) {
        File.writeLog("script started");
        Paint.setStatus("start account creation");
        File.writeLog("start account creation: " + (VariablesCreation.accountsCreated + 1));
        Interface.getComponent(WidgetsCreation.CREATE_ACCOUNT, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.game.clientState() == -1;
            }
        }, 500, 10);
    }

    public static void selectMale(ClientContext ctx) {
        Paint.setStatus("select male");
        Interface.getComponent(WidgetsCreation.SELECT_MALE, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.SELECT_MALE, ctx).visible();
            }
        }, 500, 10);
    }

    public static void selectFemale(ClientContext ctx) {
        Paint.setStatus("select female");
        Interface.getComponent(WidgetsCreation.SELECT_FEMALE, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.SELECT_FEMALE, ctx).visible();
            }
        }, 500, 10);
    }

    public static void finishDesign(ClientContext ctx) {
        Paint.setStatus("finish design");
        Interface.getComponent(WidgetsCreation.DESIGN_DONE, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.RANDOMISE_NAME, ctx).visible();
            }
        }, 500, 10);
    }

    public static void randomiseName(ClientContext ctx) {
        Paint.setStatus("randomise name");
        Interface.getComponent(WidgetsCreation.RANDOMISE_NAME, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.checkBoxes(WidgetsCreation.VALID_NAME, ctx) != Interface.checkBox.UNKNOWN;
            }
        }, 500, 10);
    }

    public static void enterName(ClientContext ctx) {
        Paint.setStatus("enter name");
        Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).click();
        String name = SettingsCreation.NAME + VariablesCreation.extension;
        ctx.input.send(name);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.checkBoxes(WidgetsCreation.VALID_NAME, ctx) != Interface.checkBox.UNKNOWN;
            }
        }, 500, 10);
    }

    public static void deleteName(ClientContext ctx) {
        Paint.setStatus("delete name");
        String name = SettingsCreation.NAME + VariablesCreation.extension;
        for (int i = 0; i <= name.length(); i++) {
            ctx.input.send("\b");
        }
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).text().isEmpty();
            }
        }, 500, 10);
    }

    public static void enterAge(ClientContext ctx) {
        Paint.setStatus("enter age");
        Interface.getComponent(WidgetsCreation.AGE_FIELD, ctx).click();
        ctx.input.send("" + Random.nextInt(SettingsCreation.MIN_AGE, SettingsCreation.MAX_AGE));
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !Interface.getComponent(WidgetsCreation.AGE_FIELD, ctx).text().isEmpty();
            }
        }, 500, 10);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.checkBoxes(WidgetsCreation.VALID_AGE, ctx) != Interface.checkBox.UNKNOWN;
            }
        }, 500, 10);
    }

    public static void deleteAge(ClientContext ctx) {
        Paint.setStatus("delete age");
        for (int i = 0; i <= 2; i++) {
            ctx.input.send("\b");
        }
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.AGE_FIELD, ctx).text().isEmpty();
            }
        }, 500, 10);
    }

    public static void enterEmail(ClientContext ctx) {
        Paint.setStatus("enter email");
        Interface.getComponent(WidgetsCreation.EMAIL_FIELD, ctx).click();
        String email = SettingsCreation.E_MAIL + "+" + (SettingsCreation.EXTENSION_BASE + VariablesCreation.extension) + "@" + SettingsCreation.DOMAIN;
        ctx.input.send(email);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.EMAIL_FIELD, ctx).text().equals(email);
            }
        }, 500, 10);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.checkBoxes(WidgetsCreation.VALID_EMAIL, ctx) != Interface.checkBox.UNKNOWN;
            }
        }, 500, 10);
    }

    public static void deleteEmail(ClientContext ctx) {
        Paint.setStatus("delete email");
        String email = SettingsCreation.E_MAIL + "+" + (SettingsCreation.EXTENSION_BASE + VariablesCreation.extension) + "@" + SettingsCreation.DOMAIN;
        for (int i = 0; i <= email.length(); i++) {
            ctx.input.send("\b");
        }
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.NAME_FIELD, ctx).text().isEmpty();
            }
        }, 500, 10);
    }

    public static void enterPassword(ClientContext ctx) {
        Paint.setStatus("enter password");
        Interface.getComponent(WidgetsCreation.PASSWORD_FIELD, ctx).click();
        ctx.input.send(SettingsCreation.PASSWORD);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !Interface.getComponent(WidgetsCreation.PASSWORD_FIELD, ctx).text().isEmpty();
            }
        }, 500, 10);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.checkBoxes(WidgetsCreation.VALID_PASSWORD, ctx) != Interface.checkBox.UNKNOWN;
            }
        }, 500, 10);
    }

    public static void deletePassword(ClientContext ctx) {
        Paint.setStatus("delete password");
        for (int i = 0; i <= SettingsCreation.PASSWORD.length(); i++) {
            ctx.input.send("\b");
        }
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.PASSWORD_FIELD, ctx).text().isEmpty();
            }
        }, 500, 10);
    }

    public static void finishCreation(ClientContext ctx) {
        Paint.setStatus("finish creation");
        Interface.getComponent(WidgetsCreation.ENLIST_DONE, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.game.clientState() != -1;
            }
        }, 500, 10);
    }

    public static void skipCutScene(ClientContext ctx) {
        Paint.setStatus("skip cut scene");
        Interface.getComponent(WidgetsCreation.SKIP_CUT_SCENE, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.ARRIVED, ctx).visible();
            }
        }, 500, 10);
    }

    public static void skipTutorial(ClientContext ctx) {
        Paint.setStatus("skip tutorial");
        ctx.hud.open(Hud.Menu.OPTIONS);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return Interface.getComponent(WidgetsCreation.SKIP_TUTORIAL, ctx).visible();
            }
        }, 500, 10);
        Interface.getComponent(WidgetsCreation.SKIP_TUTORIAL, ctx).click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.chat.canContinue();
            }
        }, 500, 10);
        ctx.chat.clickContinue();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.chat.select().text("Yes.").poll().valid();
            }
        }, 500, 10);
        ctx.chat.select().text("Yes.").poll().select(true);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().tile() == TilesCreation.SPAWN_POINT.getTile();
            }
        }, 500, 10);
    }

    public static void endScript(ClientContext ctx) {
        Paint.setStatus("end script");
        File.writeLog("end script: " + VariablesCreation.accountsCreated);
        ctx.game.logout(false);
        ctx.controller.stop();
    }
}