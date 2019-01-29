package view.gui;

import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ClickHandler extends MouseAdapter {
    private PaintCanvasBase canvas;
    private ApplicationState state;

    private double startX;
    private double startY;
    private double endX;
    private double endY;

    public ClickHandler(PaintCanvasBase canvas, ApplicationState state) {
        this.canvas = canvas;
        this.state = state;
    }

    public void mousePressed(MouseEvent e) {
        this.startX = e.getX();
        this.startY = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
        this.endX = e.getY();
        this.endY = e.getY();
    }

}
