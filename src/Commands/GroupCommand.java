package Commands;

import shape.CopiedShapeCollection;
import shape.SelectedShapeCollection;
import shape.ShapeCollection;
import shape.ShapeGroup;
import shape.interfaces.IShape;

import java.util.ArrayList;
import java.util.Iterator;


public class GroupCommand implements ICommand, IUndoable {

    private ShapeGroup group;

    public GroupCommand() {
    }

    public void run() {
        group = new ShapeGroup(SelectedShapeCollection.selectedShapes);

        Iterator<IShape> shapeIterator = SelectedShapeCollection.selectedShapes.iterator();

        ShapeCollection.add(group);
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            ShapeCollection.delete(shape);
        }
        CommandHistory.add(this);
    }

    public void undo() {
        ShapeCollection.shapeCollection.addAll(group.getChildren());
        ShapeCollection.delete(group);
    }

    public void redo() {
        Iterator<IShape> shapeIterator = group.getChildren().iterator();

        ShapeCollection.add(group);
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            ShapeCollection.delete(shape);
        }
    }

}
