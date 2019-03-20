package drawer;

import shape.interfaces.IPoint;
import shape.interfaces.IShape;

import java.awt.*;

public interface IShapeDrawer {
    void drawFilledInShape(int startX, int startY, int width, int height, Color primaryColor);
    void drawOutlineShape(int startX, int startY, int width, int height, Color primaryColor, Stroke stroke);
    void drawOutlineFilledInShape(int startX, int startY, int width, int height, Color primaryColor, Color secondaryColor);
}
