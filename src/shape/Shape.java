package shape;

import drawer.*;
import model.ShapeMap;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;
import shape.interfaces.IShapeFactory;

import java.awt.*;

public class Shape implements IShape {
    private IPoint startPoint;
    private IPoint endPoint;
    private ShapeType shapeType;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeShadingType shapeShadeType;
    private IShapeDrawer drawer;
    private ApplicationState state;

    public Shape(Point startPoint, Point endPoint, ApplicationState state, IShapeDrawer drawer) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.state = state;
        this.shapeType = state.getActiveShapeType();
        this.primaryColor = ShapeMap.colorMap.get(state.getActivePrimaryColor());
        this.secondaryColor = ShapeMap.colorMap.get(state.getActiveSecondaryColor());
        this.shapeShadeType = state.getActiveShapeShadingType();
        this.drawer = drawer;
    }

    public void draw() {

        IShapeDrawer currentDrawer;
        if(SelectedShapeCollection.selectedShapes.contains(this)) {
            currentDrawer = new SelectedDrawerDecorator(this.drawer);
        } else {
            currentDrawer = this.drawer;
        }

        switch (this.shapeShadeType) {
            case FILLED_IN:
                currentDrawer.drawFilledInShape(this.getMinX(), this.getMinY(), this.getWidth(), this.getHeight(), this.primaryColor);
                break;
            case OUTLINE:
                currentDrawer.drawOutlineShape(this.getMinX(), this.getMinY(), this.getWidth(), this.getHeight(), this.primaryColor, new BasicStroke(5));
                break;
            case OUTLINE_AND_FILLED_IN:
                currentDrawer.drawOutlineFilledInShape(this.getMinX(), this.getMinY(), this.getWidth(), this.getHeight(), this.primaryColor, this.secondaryColor);
                break;
        }


    }

    public void move(int deltaX, int deltaY) {
        System.out.println(deltaX);
        IPoint shapeStartPoint = this.getStartPoint();
        IPoint shapeEndPoint = this.getEndPoint();

        shapeStartPoint.setX(shapeStartPoint.getX() + deltaX);
        shapeStartPoint.setY(shapeStartPoint.getY() + deltaY);

        shapeEndPoint.setX(shapeEndPoint.getX() + deltaX);
        shapeEndPoint.setY(shapeEndPoint.getY() + deltaY);
    }

    public IShape copy() {
        IShapeFactory factory = new ShapeFactory();

        IShape newShape = factory.createShape(new Point(this.startPoint.getX()+100, this.startPoint.getY()+100), new Point(this.endPoint.getX()+100, this.endPoint.getY()+100), this.state, this.drawer);

        return newShape;
    }

    public IPoint getStartPoint() {
        return this.startPoint;
    }

    public IPoint getEndPoint() {
        return this.endPoint;
    }

    public ApplicationState getState() {
        return this.state;
    }

    public IShapeDrawer getDrawer() {
        return this.drawer;
    }

    public int getMinX() {
        return Math.min(startPoint.getX(), endPoint.getX());
    }

    public int getMinY() {
        return Math.min(startPoint.getY(), endPoint.getY());
    }

    public int getMaxX() {
        return Math.max(startPoint.getX(), endPoint.getX());
    }

    public int getMaxY() {
        return Math.max(startPoint.getY(), endPoint.getY());
    }

    public int getWidth() {
        return this.getMaxX() - this.getMinX();
    }

    public int getHeight() {
        return this.getMaxY() - this.getMinY();
    }

    public ShapeType getShapeType() {
        return this.shapeType;
    }

    public Color getPrimaryColor() {
        return this.primaryColor;
    }

    public ShapeShadingType getShapeShadingType() {
        return this.shapeShadeType;
    }

    public void setDrawer(IShapeDrawer drawer) {
        this.drawer = drawer;
    }

}
