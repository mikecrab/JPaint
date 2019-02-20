package Commands;

import model.persistence.ApplicationState;
import shape.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ClickHandler extends MouseAdapter {
    private ApplicationState state;

    private Point startPoint;
    private Point endPoint;

    public ClickHandler(ApplicationState state) {
        this.state = state;
    }

    public void mousePressed(MouseEvent e) {
        this.startPoint = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        this.endPoint = new Point(e.getX(), e.getY());
        ICommand command = new CreateShapeCommand(this.startPoint, this.endPoint, this.state);
        command.run();
    }

}
