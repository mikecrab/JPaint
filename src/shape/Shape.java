package shape;

import drawer.EclipseDrawer;
import drawer.IShapeDrawer;
import drawer.RectangleDrawer;
import drawer.TriangleDrawer;
import model.ShapeColor;
import model.ShapeMap;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;
import shape.interfaces.IPoint;
import shape.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class Shape implements IShape {
    private IPoint startPoint;
    private IPoint endPoint;
    private ShapeType shapeType;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeShadingType shapeShadeType;
    private IShapeDrawer drawer;

    public Shape(Point startPoint, Point endPoint, ApplicationState state, IShapeDrawer drawer) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = state.getActiveShapeType();
        this.primaryColor = ShapeMap.colorMap.get(state.getActivePrimaryColor());
        this.secondaryColor = ShapeMap.colorMap.get(state.getActiveSecondaryColor());
        this.shapeShadeType = state.getActiveShapeShadingType();
        this.drawer = drawer;
    }

    public void draw() {
        int minX = Math.min(startPoint.getX(), endPoint.getX());
        int minY = Math.min(startPoint.getY(), endPoint.getY());
        int width = Math.max(startPoint.getX(), endPoint.getX()) - minX;
        int height = Math.max(startPoint.getY(), endPoint.getY()) - minY;

        switch (this.shapeShadeType) {
            case FILLED_IN:
                drawer.drawFilledInShape(minX, minY, width, height, this.primaryColor);
                break;
            case OUTLINE:
                drawer.drawOutlineShape(minX, minY, width, height, this.primaryColor);
                break;
            case OUTLINE_AND_FILLED_IN:
                drawer.drawOutlineFilledInShape(minX, minY, width, height, this.primaryColor, this.secondaryColor);
                break;
        }
    }

    public IPoint getStartPoint() {
        return this.startPoint;
    }

    public IPoint getEndPoint() {
        return this.endPoint;
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

}
