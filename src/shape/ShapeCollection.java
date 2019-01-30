package shape;

import Commands.DrawShapeCommand;
import shape.interfaces.IShape;
import shape.interfaces.IShapeCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class ShapeCollection extends Observable implements IShapeCollection  {
    public static Collection<IShape> shapeCollection = new ArrayList<IShape>();

    public static void add(IShape shape) {
        shapeCollection.add(shape);
        DrawShapeCommand draw = new DrawShapeCommand();
    }

    public static void delete(Shape shape) {
    }
}
