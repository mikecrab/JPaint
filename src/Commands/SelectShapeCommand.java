package Commands;

import shape.SelectedShapeCollection;
import shape.ShapeCollection;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;

import java.util.Iterator;

public class SelectShapeCommand implements ICommand {


    IPoint startPoint;
    IPoint endPoint;

    public SelectShapeCommand(IPoint startPoint, IPoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void run() {
        //wipe selected shapes to new array
        SelectedShapeCollection.reset();

        int selectBoxX = Math.min(startPoint.getX(), endPoint.getX());
        int selectBoxY = Math.min(startPoint.getY(), endPoint.getY());
        int selectBoxWidth = Math.max(startPoint.getX(), endPoint.getX()) - selectBoxX;
        int selectBoxHeight = Math.max(startPoint.getY(), endPoint.getY()) - selectBoxY;

        Iterator<IShape> shapeIterator = ShapeCollection.shapeCollection.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            if (shape.getMinX() < selectBoxX + selectBoxWidth &&
                    shape.getMinX() + shape.getWidth() > selectBoxX &&
                    shape.getMinY() < selectBoxY + selectBoxHeight &&
                    shape.getMinY() + shape.getHeight() > selectBoxY) {
                SelectedShapeCollection.selectedShapes.add(shape);
            }
        }
    }

}
