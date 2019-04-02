package tetris;
import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

public class PlayTetris {
	final static int WIDTH =10, HEIGHT= 22;
	final static int SHIFT =1;
	final static double FPS = 4.0;
	Coordinate block1;
	CoordinateRow tempShape;
	String direction;
	CoordinateRow floor;
	SnakeUserInterface ui;
	
	public PlayTetris() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		ui.setFramesPerSecond(FPS);
		tempShape = new CoordinateRow();
		direction="D";
	}
	
	void start() {
		block1 = new Coordinate(5,0);
		ui.place(block1.x, block1.y, ui.SNAKE);
		tempShape.add(block1);
		ui.showChanges();
		while(true){
			Event event = ui.getEvent();
			ProcessEvent(event);
			ui.showChanges();
		}
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
		
		if(event.data.equals("R") && !direction.equals("L")){
			direction = event.data;
		}
		
		if(event.data.equals("L") && !direction.equals("R")){
			direction = event.data;
		}
	}
	
	private void ProcessAlarm(Event event) {
		if(tempShape.CorRow[0].y<HEIGHT-1){
			Coordinate block = tempShape.CorRow[0];
			Coordinate prevPos = tempShape.CorRow[tempShape.numberOfElements-1];
			Coordinate newBlock = new Coordinate();
			tempShape.addF(newBlock);
			moveSnake(block, newBlock);
			ui.place(newBlock.x, newBlock.y, ui.SNAKE);
			tempShape.numberOfElements--;
			ui.place(prevPos.x, prevPos.y, ui.EMPTY);
			ui.printf("%d", tempShape.CorRow[0].y);
			ui.showChanges();
		}
	}
	
	private void moveSnake(Coordinate block, Coordinate newBlock) {
		if (direction.equals("D")){
			newBlock.y=block.y+1;
			newBlock.x=block.x;
			
		}		
		
		if (direction.equals("R")){
			newBlock.y=block.y;
			newBlock.x=block.x+1;		
		}	
		
		if (direction.equals("L")){
			newBlock.y=block.y;
			newBlock.x=block.x-1;		
		}	
		
		
		direction = "D";
	}

	public static void main(String[] args) {
		new PlayTetris().start();

	}

}
