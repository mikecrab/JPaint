package shape;

import drawer.IShapeDrawer;
import model.ShapeType;
import model.persistence.ApplicationState;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;
import shape.interfaces.IShapeGroup;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ShapeGroup implements IShape, IShapeGroup {
    private ArrayList<IShape> group;
    private IPoint startPoint;
    private IPoint endPoint;

    public ShapeGroup(ArrayList<IShape> group) {
        this.group = group;
        this.setGroupBounds();

    }

    //function to set bounds of group
    private void setGroupBounds() {
        Iterator<IShape> shapeIterator = group.iterator();
        IShape firstShape = shapeIterator.next();
        int minX = firstShape.getMinX();
        int minY = firstShape.getMinY();
        int maxX = firstShape.getMaxX();
        int maxY = firstShape.getMaxY();
        //loop through all shapes to get absolute min and max to bound
        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            minX = Math.min(minX, shape.getMinX());
            minY = Math.min(minY, shape.getMinY());
            maxX = Math.max(maxX, shape.getMaxX());
            maxY = Math.max(maxY, shape.getMaxY());
        }
        startPoint = new Point(minX, minY);
        endPoint = new Point(maxX, maxY);
    }

    public void draw() {
        Iterator<IShape> shapeIterator = group.iterator();

        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            shape.draw();
        }
    }

    public void move(int deltaX, int deltaY) {
        Iterator<IShape> shapeIterator = group.iterator();

        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            shape.move(deltaX, deltaY);
        }
    }

    public ShapeGroup copy() {
        ArrayList<IShape> newGroup = new ArrayList<IShape>();

        Iterator<IShape> shapeIterator = group.iterator();

        while (shapeIterator.hasNext()) {
            IShape shape = shapeIterator.next();
            IShape newShape = shape.copy();
            newGroup.add(newShape);
        }

        return new ShapeGroup(newGroup);
    }

    public ArrayList<IShape> getChildren() {
        return group;
    }

    @Override
    public IPoint getStartPoint() {
        return startPoint;
    }

    @Override
    public IPoint getEndPoint() {
        return endPoint;
    }

    @Override
    public ApplicationState getState() {
        return null;
    }

    @Override
    public IShapeDrawer getDrawer() {
        return null;
    }

    @Override
    public ShapeType getShapeType() {
        return null;
    }

    @Override
    public Color getPrimaryColor() {
        return null;
    }

    public int getMinX() {
        return startPoint.getX();
    }

    public int getMinY() {
        return startPoint.getY();
    }

    public int getMaxX() {
        return endPoint.getX();
    }

    public int getMaxY() {
        return endPoint.getY();
    }

    public int getWidth() {
        return this.getMaxX() - this.getMinX();
    }

    public int getHeight() {
        return this.getMaxY() - this.getMinY();
    }

    @Override
    public void setDrawer(IShapeDrawer drawer) {

    }
}
