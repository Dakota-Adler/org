package org.lugge.scripts.accountcreator.util;

import org.lugge.scripts.accountcreator.data.Creation.WidgetsCreation;
import org.lugge.scripts.accountcreator.data.Options.WidgetsOptions;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;

public class Interface {
    public static Component getComponent(WidgetsCreation widget, ClientContext ctx) {
        if (widget.getChildID() == -1) {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId());
        } else {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId()).component(widget.getChildID());
        }
    }

    public static Component getComponent(WidgetsOptions widget, ClientContext ctx) {
        if (widget.getChildID() == -1) {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId());
        } else {
            return ctx.widgets.component(widget.getWidgetId(), widget.getComponentId()).component(widget.getChildID());
        }
    }

    public enum checkBox {
        VALID,
        INVALID,
        UNKNOWN,
        NULL
    }

    public static checkBox checkBoxes(WidgetsCreation widget, ClientContext ctx) {
        switch (getComponent(widget, ctx).textureId()) {
            case 19716:
                return checkBox.VALID;
            case 19717:
                return checkBox.INVALID;
            case 19718:
                return checkBox.UNKNOWN;
        }
        return checkBox.NULL;
    }
}
