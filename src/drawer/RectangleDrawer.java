package drawer;

import shape.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class RectangleDrawer implements IShapeDrawer {

    private PaintCanvasBase canvas;

    public RectangleDrawer(){
//        this.shape = shape;
//        this.canvas = canvas;
    }

    public void drawFilledInShape(int startX, int startY, int width, int height, Color primaryColor) {
        Graphics2D graphics2d = ShapeDrawer.canvas.getGraphics2D();

        graphics2d.setColor(primaryColor);
        graphics2d.fillRect(startX, startY, width, height);
    }

    @Override
    public void drawOutlineShape(int startX, int startY, int width, int height, Color primaryColor, Stroke stroke) {

        Graphics2D graphics2d = ShapeDrawer.canvas.getGraphics2D();

        graphics2d.setStroke(stroke);
        graphics2d.setColor(primaryColor);
        graphics2d.drawRect(startX, startY, width, height);
    }

    @Override
    public void drawOutlineFilledInShape(int startX, int startY, int width, int height, Color primaryColor, Color secondaryColor) {
        Graphics2D graphics2d = ShapeDrawer.canvas.getGraphics2D();

        //filled in shape
        graphics2d.setColor(primaryColor);
        graphics2d.fillRect(startX, startY, width, height);

        //shape outline
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(secondaryColor);
        graphics2d.drawRect(startX, startY, width, height);
    }

}
