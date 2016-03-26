package org.lugge.scripts.accountcreator.data.Options;

public enum WidgetsOptions {
    GAME_SETTINGS(1433, 46, -1),
    DISABLE_HINTS(1663, 21, -1),
    ENABLE_LEGACY_LAYOUT(1663, 45, -1),
    SWITCH_LEGACY(26, 13, -1),
    CLOSE_GAME_SETTINGS(1477, 500, 1);

    private final int widgetID;
    private final int componentID;
    private final int childID;

    WidgetsOptions(int widgetID, int componentID, int childID) {
        this.widgetID = widgetID;
        this.componentID = componentID;
        this.childID = childID;
    }

    public int getWidgetId() {
        return this.widgetID;
    }

    public int getComponentId() {
        return this.componentID;
    }

    public int getChildID() {
        return this.childID;
    }
}