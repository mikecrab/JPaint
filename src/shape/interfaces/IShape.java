package shape.interfaces;

import drawer.IShapeDrawer;
import model.ShapeColor;
import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import shape.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IShape {
    IPoint getStartPoint();
    IPoint getEndPoint();
    ApplicationState getState();
    IShapeDrawer getDrawer();
    ShapeType getShapeType();
    Color getPrimaryColor();
    int getMinX();
    int getMinY();
    int getWidth();
    int getHeight();
    int getMaxX();
    int getMaxY();
    void draw();
}
