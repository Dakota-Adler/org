package org.lugge.scripts.accountcreator.task.Options;

import org.lugge.scripts.accountcreator.data.Options.SettingsOptions;
import org.lugge.scripts.accountcreator.data.Options.WidgetsOptions;
import org.lugge.scripts.accountcreator.util.Interface;
import org.powerbot.script.rt6.ClientContext;

public class ConditionsOptions {
    public static StatesOptions getCurrentState(ClientContext ctx) {
        if (SettingsOptions.DISABLE_HINTS) {
            if (ctx.varpbits.varpbit(3925) == 0) {
                if (Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).visible()) {
                    return StatesOptions.DISABLE_HINTS;
                } else {
                    return StatesOptions.OPEN_GAME_SETTINGS;
                }
            } else {
                if (Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).visible()) {
                    if (SettingsOptions.ACTIVATE_LEGACY) {
                        if (ctx.varpbits.varpbit(1775) != 0) {
                            return StatesOptions.CLOSE_GAME_SETTINGS;
                        }
                    } else {
                        return StatesOptions.CLOSE_GAME_SETTINGS;
                    }
                }
            }
        }
        if (SettingsOptions.ACTIVATE_LEGACY) {
            if (ctx.varpbits.varpbit(1775) == 0) {
                if (Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).visible()) {
                    if (Interface.getComponent(WidgetsOptions.SWITCH_LEGACY, ctx).visible()) {
                        return StatesOptions.SWITCH_TO_LEGACY;
                    } else {
                        return StatesOptions.ENABLE_LEGACY_LAYOUT;
                    }
                } else {
                    return StatesOptions.OPEN_GAME_SETTINGS;
                }
            } else {
                if (Interface.getComponent(WidgetsOptions.DISABLE_HINTS, ctx).visible()) {
                    if (SettingsOptions.DISABLE_HINTS) {
                        if (ctx.varpbits.varpbit(3925) != 0) {
                            return StatesOptions.CLOSE_GAME_SETTINGS;
                        }
                    } else {
                        return StatesOptions.CLOSE_GAME_SETTINGS;
                    }
                }
            }
        }
        return StatesOptions.NULL;
    }
}
