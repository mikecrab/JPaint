package Commands;

import model.ShapeColor;
import shape.Shape;
import shape.ShapeCollection;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Iterator;

public class DrawShapeCommand {

    public DrawShapeCommand(){
    }

    public void draw() {
        Iterator<Shape> shapeIterator = ShapeCollection.shapeCollection.iterator();
        while (shapeIterator.hasNext()) {
            Shape shape = shapeIterator.next();

            double startX = shape.getStartPoint().getX();
            double startY = shape.getStartPoint().getY();
            ShapeColor primaryColor = shape.getPrimaryColor();

            double endX = shape.getEndPoint().getX();
            double endY = shape.getEndPoint().getY();


            double width = Math.max(startX, endX) - Math.min(startX, endX);
            double height = Math.max(startY, endY) - Math.min(startY, endY);

        }
    }
}
