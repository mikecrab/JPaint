package drawer;

import shape.ShapeCollection;
import shape.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Iterator;

public class ShapeDrawer {

    public static PaintCanvasBase canvas;

    public static void draw() {
        //clear canvas
        canvas.paintImmediately(0, 0, canvas.getWidth(), canvas.getHeight());

        Iterator<IShape> shapeIterator = ShapeCollection.shapeCollection.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            shape.draw();
        }
    }
}
