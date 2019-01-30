package shape.interfaces;

import model.ShapeColor;
import model.ShapeType;
import shape.Point;

public interface IShape {
    public Point getStartPoint();
    public Point getEndPoint();
    public ShapeType getShapeType();
    public ShapeColor getPrimaryColor();
}
