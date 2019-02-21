package shape.interfaces;

import model.ShapeColor;
import model.ShapeType;
import shape.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IShape {
    IPoint getStartPoint();
    IPoint getEndPoint();
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
