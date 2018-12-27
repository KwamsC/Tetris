package tetris;


public class ShapeFactory {
	
	   //use getShape method to get object of type shape 
	   public Shape getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("I")){
	         return new ShapeI();
	         
	      } else if(shapeType.equalsIgnoreCase("L")){
	         return new ShapeL();
	      }
	      
	      return null;
	   }
	}
