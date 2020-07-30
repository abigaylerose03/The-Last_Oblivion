package javagame;

import java.util.ArrayList;
import javagame.Collidable;

public class CollisionDetector {
	
	public static ArrayList<Collidable> detectCols(Collidable actor, ArrayList<Collidable> others) {
		ArrayList<Collidable> collisions = new ArrayList<Collidable>();
		return detectColsWithMargin(actor, others, 0);
		
	}
	
	// for sprite interactions, intertwines with Ray class for collision detection space bars
	public static ArrayList<Collidable> detectColsWithMargin(Collidable actor, ArrayList<Collidable> others, float margin) {
		ArrayList<Collidable> collisions = new ArrayList<Collidable>();
		for(Collidable collision : others) { // iterate through the ArrayList of collidable objects
			if(pointInX(actor, collision.getX(), collision.getY(), margin) 
			   || pointInX(actor, collision.getX() + collision.getWidth(), collision.getY(), margin) 
			   || pointInX(actor, collision.getX(), collision.getY() + collision.getHeight(), margin) 
			   || pointInX(actor, collision.getX() + collision.getWidth(), collision.getY() + collision.getHeight(), margin)) {
				
			collisions.add(collision);
				
			}
			
			
		} return collisions;
		
	}
	
	public static boolean pointInX(Collidable otherStuff, float x, float y, float margin) {
		if(x >= otherStuff.getX() - margin && x <= otherStuff.getX() + otherStuff.getWidth() + margin
		&& y >= otherStuff.getY() - margin && y <= otherStuff.getY() + otherStuff.getHeight() + margin) {
			return true;
		}
		return false;
		
	}

}
