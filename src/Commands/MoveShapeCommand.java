package Commands;

import drawer.ShapeDrawer;
import shape.SelectedShapeCollection;
import shape.ShapeCollection;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;

import java.util.Iterator;

public class MoveShapeCommand implements ICommand {

    IPoint startPoint;
    IPoint endPoint;

    public MoveShapeCommand(IPoint startPoint, IPoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void run() {
        int deltaX = endPoint.getX() - startPoint.getX();
        int deltaY = endPoint.getY() - startPoint.getY();

        Iterator<IShape> shapeIterator = SelectedShapeCollection.selectedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            IPoint shapeStartPoint = shape.getStartPoint();
            IPoint shapeEndPoint = shape.getEndPoint();

            shapeStartPoint.setX(shapeStartPoint.getX() + deltaX);
            shapeStartPoint.setY(shapeStartPoint.getY() + deltaY);

            shapeEndPoint.setX(shapeEndPoint.getX() + deltaX);
            shapeEndPoint.setY(shapeEndPoint.getY() + deltaY);
        }

        ShapeDrawer.draw();
    }
}
