package drawer;

import shape.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class SelectedDrawerDecorator implements IShapeDrawer {

    private IShapeDrawer drawer;

    public SelectedDrawerDecorator(IShapeDrawer drawer){
        this.drawer = drawer;
    }

    public void drawFilledInShape(int startX, int startY, int width, int height, Color primaryColor) {
        this.drawer.drawFilledInShape(startX, startY, width, height, primaryColor);
        this.drawSelectedShape(startX, startY, width, height);
    }

    @Override
    public void drawOutlineShape(int startX, int startY, int width, int height, Color primaryColor, Stroke stroke) {
        this.drawer.drawOutlineShape(startX, startY, width, height, primaryColor,  new BasicStroke(5));
        this.drawSelectedShape(startX, startY, width, height);
    }

    @Override
    public void drawOutlineFilledInShape(int startX, int startY, int width, int height, Color primaryColor, Color secondaryColor) {
        this.drawer.drawOutlineFilledInShape(startX, startY, width, height, primaryColor, secondaryColor);
        this.drawSelectedShape(startX, startY, width, height);
    }

    private void drawSelectedShape(int startX, int startY, int width, int height) {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        int offset = 5;
        startX = startX - offset;
        startY = startY-offset;
        width = width + offset*2;
        height = height + offset*2;

        this.drawer.drawOutlineShape(startX, startY, width, height, Color.black, stroke);
    }

}
