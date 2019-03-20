package Commands;

import drawer.ShapeDrawer;
import shape.SelectedShapeCollection;
import shape.ShapeCollection;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;

import java.util.ArrayList;
import java.util.Iterator;

public class MoveShapeCommand implements ICommand, IUndoable {

    IPoint startPoint;
    IPoint endPoint;
    ArrayList<IShape> movedShapes = new ArrayList<IShape>();

    public MoveShapeCommand(IPoint startPoint, IPoint endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void run() {
        int deltaX = endPoint.getX() - startPoint.getX();
        int deltaY = endPoint.getY() - startPoint.getY();
    System.out.println(SelectedShapeCollection.selectedShapes);
        Iterator<IShape> shapeIterator = SelectedShapeCollection.selectedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            //add shape to command history
            movedShapes.add(shape);

            shape.move(deltaX, deltaY);
        }

        ShapeDrawer.draw();

        CommandHistory.add(this);
    }

    public void undo() {
        int deltaX = startPoint.getX() - endPoint.getX();
        int deltaY = startPoint.getY() - endPoint.getY();

        Iterator<IShape> shapeIterator = movedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            shape.move(deltaX, deltaY);
        }

        ShapeDrawer.draw();
    }

    public void redo() {
        int deltaX = endPoint.getX() - startPoint.getX();
        int deltaY = endPoint.getY() - startPoint.getY();

        Iterator<IShape> shapeIterator = movedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            shape.move(deltaX, deltaY);
        }

        ShapeDrawer.draw();
    }
}
