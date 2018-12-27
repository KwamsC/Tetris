package tetris;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

public class PlayTetris {
	final static int WIDTH =10, HEIGHT= 22;
	final static int SHIFT =1;
	final static double FPS = 5.0;
	SnakeUserInterface ui;
	
	public PlayTetris() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, HEIGHT);
		ui.setFramesPerSecond(FPS);
	}
	
	void start() {
		ui.showChanges();
	}

	public static void main(String[] args) {
		new PlayTetris().start();

	}

}
