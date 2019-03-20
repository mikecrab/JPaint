package Commands;

import drawer.ShapeDrawer;
import shape.SelectedShapeCollection;
import shape.ShapeCollection;
import shape.interfaces.IShape;

import java.util.Iterator;

public class DeleteShapeCommand implements ICommand, IUndoable {

    private IShape shape;

    public DeleteShapeCommand() {
    }

    public void run() {
        Iterator<IShape> shapeIterator = SelectedShapeCollection.selectedShapes.iterator();
        while (shapeIterator.hasNext()) {
            shape = shapeIterator.next();

            ShapeCollection.delete(shape);
        }
        //wipe selected shapes so they wont reappear on copy+paste/move
        SelectedShapeCollection.reset();
        CommandHistory.add(this);
    }

    public void undo() {
        ShapeCollection.add(shape);
    }

    public void redo() {
        ShapeCollection.delete(shape);
    }
}
