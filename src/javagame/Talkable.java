package javagame;

import org.newdawn.slick.*;

public interface Talkable {
	
	public String getDialogueWithCollidable(Collidable actor);
	
	public Image getFaceSetWithCollidable(Collidable actor);


}
