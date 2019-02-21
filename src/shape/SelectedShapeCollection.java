package shape;

import drawer.ShapeDrawer;
import shape.interfaces.IShape;

import java.util.ArrayList;
import java.util.List;

public class SelectedShapeCollection {
    public static List<IShape> selectedShapes;

    public static void reset() {
        selectedShapes = new ArrayList<>();
    }

    public static void add(IShape shape) {
        selectedShapes.add(shape);
    }
}
