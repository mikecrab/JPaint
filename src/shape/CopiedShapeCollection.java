package shape;

import drawer.ShapeDrawer;
import shape.interfaces.IShape;
import shape.interfaces.IShapeCollection;

import java.util.ArrayList;
import java.util.List;

public class CopiedShapeCollection implements IShapeCollection {
    public static List<IShape> copiedShapes;

    public static void reset() {
        copiedShapes = new ArrayList<>();
    }

    public static void add(IShape shape) {
        copiedShapes.add(shape);
    }
}
