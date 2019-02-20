package shape;

import drawer.IShapeDrawer;
import model.persistence.ApplicationState;
import shape.interfaces.IShape;
import shape.interfaces.IShapeFactory;

public class ShapeFactory implements IShapeFactory {

    public IShape createShape(Point startPoint, Point endPoint, ApplicationState state, IShapeDrawer drawer) {
        return new Shape(startPoint, endPoint, state, drawer);
    }

}
