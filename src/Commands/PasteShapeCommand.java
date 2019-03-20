package Commands;

import shape.CopiedShapeCollection;
import shape.Point;
import shape.ShapeCollection;
import shape.ShapeFactory;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;
import shape.interfaces.IShapeFactory;

import java.util.ArrayList;
import java.util.Iterator;

public class PasteShapeCommand implements ICommand, IUndoable {

    ArrayList<IShape> pastedShapes = new ArrayList<IShape>();

    public PasteShapeCommand() {
    }

    public void run() {
        IShapeFactory factory = new ShapeFactory();
        Iterator<IShape> shapeIterator = CopiedShapeCollection.copiedShapes.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            pastedShapes.add(shape);
            ShapeCollection.add(shape);
        }

        CommandHistory.add(this);
    }

    public void undo() {
        Iterator<IShape> shapeIterator = pastedShapes.iterator();

        while (shapeIterator.hasNext()) {
            ShapeCollection.delete(shapeIterator.next());
        }
    }

    public void redo() {
        Iterator<IShape> shapeIterator = pastedShapes.iterator();

        while (shapeIterator.hasNext()) {
            ShapeCollection.add(shapeIterator.next());
        }
    }

}
