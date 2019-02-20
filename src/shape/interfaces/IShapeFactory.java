package shape.interfaces;

import drawer.IShapeDrawer;
import model.persistence.ApplicationState;
import shape.Point;

public interface IShapeFactory {
    IShape createShape(Point startPoint, Point endPoint, ApplicationState state, IShapeDrawer drawer);
}
