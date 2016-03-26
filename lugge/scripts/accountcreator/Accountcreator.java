package org.lugge.scripts.accountcreator;

import org.lugge.scripts.accountcreator.data.Creation.GenderCreation;
import org.lugge.scripts.accountcreator.data.Creation.SettingsCreation;
import org.lugge.scripts.accountcreator.data.Options.SettingsOptions;
import org.lugge.scripts.accountcreator.data.Placement.DestinationsPlacement;
import org.lugge.scripts.accountcreator.data.Placement.SettingsPlacement;
import org.lugge.scripts.accountcreator.data.SuperState.SettingsSuperState;
import org.lugge.scripts.accountcreator.task.SuperState.ActionsSuperState;
import org.lugge.scripts.accountcreator.task.SuperState.ConditionsSuperState;
import org.lugge.scripts.accountcreator.util.File;
import org.lugge.scripts.accountcreator.util.Paint;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;

@Script.Manifest(name = "Accountcreator", description = "creates accounts", properties = "client=6; topic=1;")

public class Accountcreator extends PollingScript<ClientContext> implements PaintListener {

    @Override
    public void start() {
        ctx.properties.put("login.disable", "true");

        Paint.setStatus("Script Started");
        File.writeLog("Script Started");

        SettingsSuperState.setLogfile(getStorageDirectory().getPath(), getName() + ".txt");

        SettingsCreation.NAME = null;
        SettingsCreation.E_MAIL = "ohmy";
        SettingsCreation.EXTENSION_BASE = 2;
        SettingsCreation.DOMAIN = "gmail.com";
        SettingsCreation.PASSWORD = "Rs34ab85";
        SettingsCreation.MIN_AGE = 18;
        SettingsCreation.MAX_AGE = 26;

        SettingsCreation.QUANTITY = 1;

        SettingsCreation.GENDER = GenderCreation.RANDOM;

        SettingsOptions.DISABLE_HINTS = true;
        SettingsOptions.ACTIVATE_LEGACY = true;

        SettingsPlacement.DESTINATION = DestinationsPlacement.VARROCK;
    }

    @Override
    public void poll() {
        switch (ConditionsSuperState.getSuperState(ctx)) {
            case CREATE_ACCOUNT:
                Paint.setSuperStatus("CREATE ACCOUNT");
                ActionsSuperState.createAccount(ctx);
                break;
            case CHANGE_OPTIONS:
                Paint.setSuperStatus("CHANGE OPTIONS");
                ActionsSuperState.changeOptions(ctx);
                break;
            case PLACE_ACCOUNT:
                Paint.setSuperStatus("PLACE ACCOUNT");
                ActionsSuperState.placeAccount(ctx);
                break;
            case NULL:
                break;
        }
    }

    @Override
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        Paint.drawMouse(g, ctx.input.getLocation());
        g.setFont(Paint.MAIN_FONT);
        if (Paint.status != null) {
            g.drawString(Paint.status, 0, 375);
        }
        if (Paint.superStatus != null) {
            g.drawString(Paint.superStatus, 0, 350);
        }
    }

}

