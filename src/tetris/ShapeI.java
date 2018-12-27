package tetris;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

public class ShapeI implements Shape{
	SnakeUserInterface ui;
	CoordinateRow temp;
	
	@Override
	public CoordinateRow make() {
		temp= new CoordinateRow();
		Coordinate blocktemp= new Coordinate(5,0);
		Coordinate blocktemp1= new Coordinate(5,1);
		temp.add(blocktemp1);
		temp.add(blocktemp);
		return temp;
	}

}
