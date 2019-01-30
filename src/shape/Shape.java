package shape;

import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import shape.interfaces.IShape;

public class Shape implements IShape {
    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    private ShapeColor primaryColor;

    public Shape(Point startPoint, Point endPoint, ApplicationState state) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = state.getActiveShapeType();
        this.primaryColor = state.getActivePrimaryColor();
    }

    public Point getStartPoint() {
        return this.startPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public ShapeType getShapeType() {
        return this.shapeType;
    }

    public ShapeColor getPrimaryColor() {
        return this.primaryColor;
    }
}
