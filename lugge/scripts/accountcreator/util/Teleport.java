package org.lugge.scripts.accountcreator.util;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;

public class Teleport {
    public static boolean home(int destination, ClientContext ctx) {
        if (!ctx.widgets.component(1092, 0).visible()) {
            ctx.widgets.component(1465, 56).click();
            Condition.wait(() -> ctx.widgets.component(1092, 0).visible(), 200, 5);
            return false;
        } else {
            ctx.widgets.component(1092, destination).click();
            Condition.wait(() -> ctx.players.local().animation() != -1, 200, 10);
            Condition.wait(() -> ctx.players.local().animation() == -1, 500, 20);
            return true;
        }
    }
}
