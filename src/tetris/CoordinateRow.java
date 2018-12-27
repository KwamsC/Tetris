package tetris;

public class CoordinateRow {
	Coordinate [] CorRow;
	int numberOfElements;
	static final int MAX_LENGTH=100;

	public CoordinateRow() {
		CorRow = new Coordinate [MAX_LENGTH];
		numberOfElements=0;
	}
	void add(Coordinate cor){
		CorRow[numberOfElements]= cor;
		numberOfElements++;
	}
	
	void addF(Coordinate cor){
		for (int i=numberOfElements-1; i>=0; i--){
			CorRow[i+1]=CorRow[i];
		}
		CorRow[0]= cor;
		numberOfElements++;
	}
	
	boolean checkCollision(Coordinate cor){
		for (int i=1; i<numberOfElements; i++){
			if(cor.x==CorRow[i].x && cor.y==CorRow[i].y){
				return true;
			}
		}
		return false;
	}
}
