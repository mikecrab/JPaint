package Commands;

import shape.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawRectangleCommand implements ICommand {

    private IShape shape;
    private PaintCanvasBase canvas;

    public DrawRectangleCommand(IShape shape, PaintCanvasBase canvas){
        this.shape = shape;
        this.canvas = canvas;
    }

    public void run() {
        int startX = this.shape.getStartX();
        int startY = this.shape.getStartY();
        int endX = this.shape.getEndX();
        int endY = this.shape.getEndY();

        //ShapeColor primaryColor = shape.getPrimaryColor();

        int minX = Math.min(startX, endX);
        int minY = Math.min(startY, endY);
        int width = Math.max(startX, endX) - minX;
        int height = Math.max(startY, endY) - minY;

        Graphics2D graphics2d = this.canvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(minX, minY, width, height);
    }
}
