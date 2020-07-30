package org.characters;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javagame.Collidable;
import javagame.Scriptable;
import javagame.Talkable;


public class Joy implements Collidable, Talkable, Scriptable {
	
	Image joyFaceSet;
	
	public int deltaVal;
	
	int[] duration = {200, 200};
	
	public float joyPosX = 100;
	public float joyPosY = 300;
	
	public float bgOffSetX = 300;
	public float bgOffSetY = 500;
	
	public float joyMoveX = 0;
	public float joyMoveY = 0;
	
	// float myDelta = 0;
	// float maxDelta = 1000;
	
	Animation joy, joyUp, joyUp2, joyDown, joyDown2, joyLeft, joyLeft2, joyRight, joyRight2;
	
	// while colliding 
	String[] joyText = {"Wow, so you really meant that you were pulling an all-nighter "
			+ "\nstudying the final exam for the Elif Guard."};
	
	// while NOT colliding
	String[] joyStoryText = {};
	
	public Joy() throws SlickException {
		joyFaceSet = new Image("res/characters/facesets/joyFaceset.png");
		
		
		Image[] walkUpJoy = { new Image("res/characters/joyBack.png"), new Image("res/characters/joyBack.png") };
		Image[] walkUpJoy2 = { new Image("res/characters/joyBack2.png"), new Image("res/characters/joyBack2.png") };

		Image[] walkDownJoy = { new Image("res/characters/joyFront.png"), new Image("res/characters/joyFront.png") };
		Image[] walkDownJoy2 = { new Image("res/characters/joyFront2.png"),new Image("res/characters/joyFront2.png") };

		Image[] walkLeftJoy = { new Image("res/characters/joyLeft.png"), new Image("res/characters/joyLeft.png") };
		Image[] walkLeftJoy2 = { new Image("res/characters/joyLeft2.png"), new Image("res/characters/joyLeft2.png") };

		Image[] walkRightJoy = { new Image("res/characters/joyRight.png"), new Image("res/characters/joyRight.png") };
		Image[] walkRightJoy2 = { new Image("res/characters/joyRight2.png"), new Image("res/characters/joyRight2.png") };
		
		joyUp = new Animation(walkUpJoy, duration, false);
		joyUp2 = new Animation(walkUpJoy2, duration, false);

		joyDown = new Animation(walkDownJoy, duration, false);
		joyDown2 = new Animation(walkDownJoy2, duration, false);

		joyLeft = new Animation(walkLeftJoy, duration, false);
		joyLeft2 = new Animation(walkLeftJoy2, duration, false);

		joyRight = new Animation(walkRightJoy, duration, false);
		joyRight2 = new Animation(walkRightJoy2, duration, false);

		
		joy = joyDown;
		
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) {
		joy.draw(joyPosX, joyPosY);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		// move(200, 200, "down", .1f, delta);
		// move(800, 200, "right", .1f, delta);
		
		
	}
	
	public void setMapOffset(float offsetX, float offsetY) {
		joyPosX = offsetX + 10 + joyMoveX;
		joyPosY = offsetY + 50 + joyMoveY;
		
	}

	@Override
	public String getDialogueWithCollidable(Collidable actor) {
		// TODO Auto-generated method stub
		return joyText[0];
	}

	@Override
	public Image getFaceSetWithCollidable(Collidable actor) {
		// TODO Auto-generated method stub
		return joyFaceSet;
	}


	@Override
	public float getX() {
		
		return joyPosX;
	}

	@Override
	public float getY() {
		
		return joyPosY;
	}

	@Override
	public float getWidth() {
		
		return 26;
	}

	@Override
	public float getHeight() {
		return 26;
	}
	
	// joyPosX and joyPosY is the ultimate location where Joy is rendered 
	public void move(float x, float y, String direction, double speed, int pDelta) { // animates motion in a certain direction
			switch(direction) {
				case "right":
					if(joyMoveX < x) {
						joy = joyRight;
						
						joyMoveX += pDelta * speed;
					}
					break;
				
				case "down":
					if(joyMoveY < y) {
						joy = joyDown;
					
						joyMoveY += pDelta * speed;
					}  
					break;
				
				default:
					joy = joyDown;
					break;
			
			}
	}

	@Override
	public boolean isScriptable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String talk(String text) {
		// TODO Auto-generated method stub
		return text;
	}

	
	

	// @Override
	// public String talk() {
	//	return null;
	// }
	
	

	// public void moveX(int x, double speed, int delta) {
		// joyNewPosX += delta * speed;
	// }
	
	
	// public void moveY(int y, double speed, int delta) {
		// joyNewPosY += delta * speed;
	// }

}
