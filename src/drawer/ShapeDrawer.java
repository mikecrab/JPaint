package drawer;

import Commands.DrawRectangleCommand;
import Commands.ICommand;
import shape.ShapeCollection;
import shape.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Iterator;

public class ShapeDrawer {

    public static PaintCanvasBase canvas;

    public static void draw() {
        //canvas.repaint();

        //HACK TO GET AROUND REPAINT BUG. PAINTS WHOLE CANVAS WHITE
        Rectangle bounds = canvas.getBounds();
        Graphics2D graphics2d = canvas.getGraphics2D();
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect((int) bounds.getX(), (int) bounds.getY(), (int) bounds.getWidth(), (int) bounds.getHeight());
        //END REPAINT BUG HACK

        Iterator<IShape> shapeIterator = ShapeCollection.shapeCollection.iterator();
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            shape.draw();

//            ICommand command = new DrawRectangleCommand(shape, canvas);
//            command.run();
        }
    }
}
