package org.lugge.scripts.accountcreator.util;

import java.awt.*;

public class Paint {
    public static String status = "none yet";
    public static String superStatus = "none yet";
    public static final Font MAIN_FONT = new Font("Arial", 1, 12);

    public static void setStatus(String message) {
        status = message;
    }

    public static void setSuperStatus(String message) {
        superStatus = message;
    }

    public static void drawMouse(Graphics2D g, Point p) {
        int x = (int) p.getX();
        int y = (int) p.getY(); //+ 100; //Offset Werbung
        g.setColor(Color.GREEN);
        g.drawLine(x, y - 10, x, y + 10);
        g.drawLine(x - 10, y, x + 10, y);
    }
}
