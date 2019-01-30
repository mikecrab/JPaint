package Commands;

import model.persistence.ApplicationState;
import shape.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ClickHandler extends MouseAdapter {
    private PaintCanvasBase canvas;
    private ApplicationState state;

    private Point startPoint;
    private Point endPoint;

    public ClickHandler(PaintCanvasBase canvas, ApplicationState state) {
        this.canvas = canvas;
        this.state = state;
    }

    public void mousePressed(MouseEvent e) {
        this.startPoint = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        this.endPoint = new Point(e.getX(), e.getY());
        System.out.println(this.endPoint.getX());
        System.out.println(this.endPoint.getY());
        System.out.println(this.startPoint.getX());
        System.out.println(this.startPoint.getY());

        ICommand command = new CreateShapeCommand(this.startPoint, this.endPoint, this.state);
        command.run();
    }

}
