package Commands;

import shape.CopiedShapeCollection;
import shape.Point;
import shape.ShapeCollection;
import shape.ShapeFactory;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;
import shape.interfaces.IShapeFactory;

import java.util.Iterator;

public class PasteShapeCommand implements ICommand {

    public PasteShapeCommand() {
    }

    public void run() {
        IShapeFactory factory = new ShapeFactory();
        Iterator<IShape> shapeIterator = CopiedShapeCollection.copiedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            IPoint shapeStartPoint = shape.getStartPoint();
            IPoint shapeEndPoint = shape.getEndPoint();
            int offset = 100;

            int pastedStartX = shapeStartPoint.getX() + offset;
            int pastedStartY = shapeStartPoint.getY() + offset;

            int pastedEndX = shapeEndPoint.getX() + offset;
            int pastedEndY = shapeEndPoint.getY() + offset;

            IShape pastedShape = factory.createShape(new Point(pastedStartX, pastedStartY), new Point(pastedEndX, pastedEndY), shape.getState(), shape.getDrawer());
            ShapeCollection.add(pastedShape);
        }
    }

}
