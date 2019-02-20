package shape.interfaces;

import model.ShapeColor;
import model.ShapeType;
import shape.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public interface IShape {
    Point getStartPoint();
    Point getEndPoint();
    ShapeType getShapeType();
    Color getPrimaryColor();
    int getStartX();
    int getStartY();
    int getEndX();
    int getEndY();
    void draw();

}
