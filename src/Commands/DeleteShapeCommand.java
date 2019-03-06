package Commands;

import drawer.ShapeDrawer;
import shape.SelectedShapeCollection;
import shape.ShapeCollection;
import shape.interfaces.IShape;

import java.util.Iterator;

public class DeleteShapeCommand implements ICommand {

    public DeleteShapeCommand() {
    }

    public void run() {
        Iterator<IShape> shapeIterator = SelectedShapeCollection.selectedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            ShapeCollection.shapeCollection.remove(shape);
            ShapeDrawer.draw();
        }
        //wipe selected shapes so they wont reappear on copy+paste/move
        SelectedShapeCollection.reset();
    }

}
