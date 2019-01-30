package Commands;

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
        IShape shape = factory.createShape(this.startPoint, this.endPoint, this.state);
        ShapeCollection.add(shape);
    }
}