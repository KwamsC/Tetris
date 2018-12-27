package tetris;
import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

public class PlayTetris {
	final static int WIDTH =10, HEIGHT= 22;
	final static int SHIFT =1;
	final static double FPS = 5.0;
	Coordinate block1;
	CoordinateRow tempShape;
	String direction;
	CoordinateRow floor;
	SnakeUserInterface ui;
	
	public PlayTetris() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		ui.setFramesPerSecond(FPS);
	}
	
	
	 private void ProcessEvent(Event event) {
			if (event.name.equals("alarm")){
				ProcessAlarm(event);
			} else if(event.name.equals("arrow")){
				ProcessArrow(event);
			}
			ui.showChanges();
		}

	
	private void ProcessArrow(Event event) {
		if(event.data.equals("D")){
			direction = event.data;
		}
	}
	
	private void ProcessAlarm(Event event) {
		ui.place(tempShape.CorRow[tempShape.numberOfElements - 1].x,
				tempShape.CorRow[tempShape.numberOfElements - 1].y, ui.EMPTY);
		moveSnake();
		ui.place(tempShape.CorRow[0].x, tempShape.CorRow[0].y, ui.SNAKE);
		ui.place(tempShape.CorRow[1].x, tempShape.CorRow[1].y, ui.SNAKE);
	}
	
	private void moveSnake() {
		if (direction.equals("D")){
			for (int i = tempShape.numberOfElements -1;i > 0; i--) {
				tempShape.CorRow[i].y +=1;
			}
			
		}	
	}

	
	void start() {
		ui.showChanges();
	}

	public static void main(String[] args) {
		new PlayTetris().start();

	}

}
