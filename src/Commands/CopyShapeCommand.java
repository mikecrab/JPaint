package Commands;

import shape.CopiedShapeCollection;
import shape.SelectedShapeCollection;
import shape.interfaces.IShape;

import java.util.Iterator;

public class CopyShapeCommand implements ICommand {

    public CopyShapeCommand() {
    }

    public void run() {
        //wipe copied shapes to new array
        CopiedShapeCollection.reset();

        Iterator<IShape> shapeIterator = SelectedShapeCollection.selectedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            IShape newShape = shape.copy();
            CopiedShapeCollection.add(newShape);
        }
    }

}
