package Commands;

import shape.SelectedShapeCollection;
import shape.ShapeCollection;
import shape.ShapeGroup;
import shape.interfaces.IShape;

import java.util.Iterator;

public class UngroupCommand implements ICommand, IUndoable {
    private ShapeGroup group;

    public UngroupCommand() {
    }

    public void run() {
        Iterator<IShape> shapeIterator = SelectedShapeCollection.selectedShapes.iterator();

        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();

            if (shape instanceof ShapeGroup) {
                group = (ShapeGroup)shape;
                ShapeCollection.shapeCollection.addAll(group.getChildren());
                ShapeCollection.delete(shape);
            }
        }
        CommandHistory.add(this);
    }

    public void undo() {
        Iterator<IShape> shapeIterator = group.getChildren().iterator();

        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            ShapeCollection.delete(shape);
        }
        ShapeCollection.add(group);
    }

    public void redo() {
        ShapeCollection.shapeCollection.addAll(group.getChildren());
        ShapeCollection.delete(group);
    }
}
