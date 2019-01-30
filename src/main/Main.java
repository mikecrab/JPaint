package main;

import Commands.DrawShapeCommand;
import Commands.ICommand;
import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import Commands.ClickHandler;
import shape.ShapeCollection;
import shape.interfaces.IShapeCollection;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;

import static shape.ShapeCollection.shapeCollection;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);

        controller.setup();
        // For example purposes only; remove all lines below from your final project.

        ClickHandler click = new ClickHandler(paintCanvas, appState);
        paintCanvas.addMouseListener(click);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Point p = new Point(1,1);

        // Filled in rectangle
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        DrawShapeCommand draw = new DrawShapeCommand(paintCanvas);
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);

        // Clears the Canvas
        //paintCanvas.repaint();
    }
}