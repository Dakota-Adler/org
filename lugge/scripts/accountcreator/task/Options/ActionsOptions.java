package org.lugge.scripts.accountcreator.task.Options;

import org.lugge.scripts.accountcreator.data.Options.WidgetsOptions;
import org.lugge.scripts.accountcreator.util.Interface;
import org.lugge.scripts.accountcreator.util.Paint;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Hud;

public class ActionsOptions {
    public static void OpenGameSettings(ClientContext ctx) {
        Paint.setStatus("open game settings");
        ctx.hud.open(Hud.Menu.OPTIONS);
        Condition.wait(() -> Interface.getComponent(WidgetsOptions.GAME_SETTINGS, ctx).visible(), 500, 10);
        Interface.getComponent(WidgetsOptions.GAME_SETTINGS, ctx).click();
        Condition.wait(() -> Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).visible(), 500, 10);
    }

    public static void DisableHints(ClientContext ctx) {
        Paint.setStatus("disable hints");
        Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).click();
        Condition.wait(() -> ctx.varpbits.varpbit(3925) != 0, 500, 10);
    }

    public static void EnableLegacyLayout(ClientContext ctx) {
        Paint.setStatus("enable legacy layout");
        Interface.getComponent(WidgetsOptions.ENABLE_LEGACY_LAYOUT, ctx).click();
        Condition.wait(() -> Interface.getComponent(WidgetsOptions.SWITCH_LEGACY, ctx).visible(), 500, 10);
    }

    public static void SwitchToLegacy(ClientContext ctx) {
        Paint.setStatus("switch to legacy layout");
        Interface.getComponent(WidgetsOptions.SWITCH_LEGACY, ctx).click();
        Condition.wait(() -> !Interface.getComponent(WidgetsOptions.SWITCH_LEGACY, ctx).visible(), 500, 10);
    }

    public static void CloseGameSettings(ClientContext ctx) {
        Paint.setStatus("close game settings");
        Interface.getComponent(WidgetsOptions.CLOSE_GAME_SETTINGS, ctx).click();
        Condition.wait(() -> !Interface.getComponent(WidgetsOptions.CLOSE_GAME_SETTINGS, ctx).visible(), 500, 10);
    }
}
