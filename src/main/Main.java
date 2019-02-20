package main;

import drawer.ShapeDrawer;
import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeMap;
import model.persistence.ApplicationState;
import Commands.ClickHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        ShapeDrawer.canvas = paintCanvas;
        //map enum to java.awt colors
        ShapeMap.constructColorMap();

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);

        controller.setup();

        ClickHandler click = new ClickHandler(appState);
        paintCanvas.addMouseListener(click);
    }
}
