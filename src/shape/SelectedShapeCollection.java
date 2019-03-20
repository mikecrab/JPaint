package shape;

import drawer.ShapeDrawer;
import shape.interfaces.IShape;
import shape.interfaces.IShapeCollection;

import java.util.ArrayList;
import java.util.List;

public class SelectedShapeCollection implements IShapeCollection {
    public static ArrayList<IShape> selectedShapes = new ArrayList<>();

    public static void reset() {
        selectedShapes = new ArrayList<>();
    }

    public static void add(IShape shape) {
        selectedShapes.add(shape);
    }
}
