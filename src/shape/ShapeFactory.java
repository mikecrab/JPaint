package shape;

import model.persistence.ApplicationState;
import shape.interfaces.IShape;
import shape.interfaces.IShapeFactory;

public class ShapeFactory implements IShapeFactory {

    public IShape createShape(Point startPoint, Point endPoint, ApplicationState state) {
        return new Shape(startPoint, endPoint, state);
    }

}
