package Commands;

import drawer.EclipseDrawer;
import drawer.IShapeDrawer;
import drawer.RectangleDrawer;
import drawer.TriangleDrawer;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import shape.Point;
import shape.Shape;
import shape.ShapeCollection;
import shape.ShapeFactory;
import shape.interfaces.IShape;
import shape.interfaces.IShapeFactory;


public class CreateShapeCommand implements ICommand {
    public Point startPoint;
    public Point endPoint;
    public ApplicationState state;

    public CreateShapeCommand(Point startPoint, Point endPoint, ApplicationState state) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.state = state;
    }

    public void run() {
        IShapeFactory factory = new ShapeFactory();

        IShapeDrawer drawer;
        switch (this.state.getActiveShapeType()) {
            case RECTANGLE:
                drawer = new RectangleDrawer();
                break;
            case TRIANGLE:
                drawer = new TriangleDrawer();
                break;
            case ELLIPSE:
                drawer = new EclipseDrawer();
                break;
            default:
                throw new Error();
        }
        IShape shape = factory.createShape(this.startPoint, this.endPoint, this.state, drawer);
        ShapeCollection.add(shape);
    }
}