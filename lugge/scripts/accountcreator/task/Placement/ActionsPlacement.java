package org.lugge.scripts.accountcreator.task.Placement;

import org.lugge.scripts.accountcreator.data.Creation.SettingsCreation;
import org.lugge.scripts.accountcreator.data.Creation.VariablesCreation;
import org.lugge.scripts.accountcreator.data.Placement.PathsPlacement;
import org.lugge.scripts.accountcreator.data.Placement.TilesPlacement;
import org.lugge.scripts.accountcreator.util.File;
import org.lugge.scripts.accountcreator.util.Paint;
import org.lugge.scripts.accountcreator.util.Teleport;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Path;
import org.powerbot.script.rt6.TilePath;

import java.util.concurrent.Callable;

public class ActionsPlacement {
    public static void teleportBurthorpe(ClientContext ctx) {
        Paint.setStatus("teleport to burthorpe");
        Teleport.home(12, ctx);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().tile().equals(TilesPlacement.BURTHORPE_LODESTONE.getTile());
            }
        }, 200, 5);
    }

    public static void teleportLumbridge(ClientContext ctx) {
        Paint.setStatus("teleport to lumbridge");
        Teleport.home(17, ctx);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().tile().equals(TilesPlacement.LUMBRIDGE_LODESTONE.getTile());
            }
        }, 200, 5);
    }

    public static void walkVarrockLodestone(ClientContext ctx) {
        Paint.setStatus("walk to varrock lodestone");
        Path toVarrock = new TilePath(ctx, PathsPlacement.TO_VARROCK.getPath());
        toVarrock.traverse();
    }

    public static void activateVarrockLodestone(ClientContext ctx) {
        Paint.setStatus("activate varrock lodestone");
        GameObject lodestone = ctx.objects.at(new Tile(3214, 3377, 0)).poll(); //select("").nearest().poll();
        ctx.camera.turnTo(lodestone);
        lodestone.interact("Activate");
        Condition.sleep(2000);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.varpbits.varpbit(3) == -1807742844;
            }
        }, 500, 10);
    }

    public static void walkGrandExchange(ClientContext ctx) {
        Paint.setStatus("walk to grad exchange");
        Path toGrandExchange = new TilePath(ctx, PathsPlacement.TO_GRAND_EXCHANGE.getPath());
        toGrandExchange.traverse();
    }

    public static void logOut(ClientContext ctx) {
        String email = SettingsCreation.E_MAIL + "+" + (SettingsCreation.EXTENSION_BASE + VariablesCreation.extension) + "@" + SettingsCreation.DOMAIN;
        VariablesCreation.accountsCreated++;
        VariablesCreation.extension++;
        Paint.setStatus("finished account creation: " + VariablesCreation.accountsCreated);
        File.writeLog("finished account creation: " + VariablesCreation.accountsCreated);
        File.writeFile(email + "    " + SettingsCreation.PASSWORD, "createdAccounts", false);
        Paint.setStatus("logging out");
        ctx.game.logout(false);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.game.clientState() == 3;
            }
        }, 500, 10);
    }

    public static void endScript(ClientContext ctx) {
        Paint.setStatus("end script: " + VariablesCreation.accountsCreated);
        File.writeLog("end script: " + VariablesCreation.accountsCreated);
        ctx.game.logout(false);
        ctx.controller.stop();
    }
}
