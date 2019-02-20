package drawer;

import shape.interfaces.IPoint;

import java.awt.*;

public interface IShapeDrawer {
    void drawFilledInShape(int startX, int startY, int endX, int endY, Color primaryColor);
    void drawOutlineShape(int startX, int startY, int endX, int endY, Color primaryColor);
    void drawOutlineFilledInShape(int startX, int startY, int endX, int endY, Color primaryColor, Color secondaryColor);
}
