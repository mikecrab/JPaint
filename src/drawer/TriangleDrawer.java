package drawer;

import shape.interfaces.IShape;

import java.awt.*;

public class TriangleDrawer implements IShapeDrawer {

    public TriangleDrawer(){
//        this.shape = shape;
//        this.canvas = canvas;
    }

    public void drawFilledInShape(int startX, int startY, int width, int height, Color primaryColor) {
        Graphics2D graphics2d = ShapeDrawer.canvas.getGraphics2D();
        graphics2d.setColor(primaryColor);

        int[] xPoints = {startX, startX+width, startX};
        int[] yPoints = {startY, startY+height, startY+height};
        graphics2d.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void drawOutlineShape(int startX, int startY, int width, int height, Color primaryColor, Stroke stroke) {
        Graphics2D graphics2d = ShapeDrawer.canvas.getGraphics2D();
        int[] xPoints = {startX, startX+width, startX};
        int[] yPoints = {startY, startY+height, startY+height};

        graphics2d.setStroke(stroke);
        graphics2d.setColor(primaryColor);
        graphics2d.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void drawOutlineFilledInShape(int startX, int startY, int width, int height, Color primaryColor, Color secondaryColor) {
        Graphics2D graphics2d = ShapeDrawer.canvas.getGraphics2D();
        int[] xPoints = {startX, startX+width, startX};
        int[] yPoints = {startY, startY+height, startY+height};

        graphics2d.setColor(primaryColor);
        graphics2d.fillPolygon(xPoints, yPoints, 3);

        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(secondaryColor);
        graphics2d.drawPolygon(xPoints, yPoints, 3);
    }

}
