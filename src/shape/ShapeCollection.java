package shape;

import drawer.ShapeDrawer;
import shape.interfaces.IShape;
import shape.interfaces.IShapeCollection;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollection implements IShapeCollection  {
    public static final List<IShape> shapeCollection = new ArrayList<>();

    public static void add(IShape shape) {
        shapeCollection.add(shape);
        ShapeDrawer.draw();
    }

}
