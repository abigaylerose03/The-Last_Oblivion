package org.characters;

import java.util.Random;

// import org.kingdom.earth.Play;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javagame.Collidable;
import javagame.Talkable;
import javagame.RayTalk;

public class Lily implements Collidable, Talkable {
	
	static Animation lily, lilyUp, lilyUp2, lilyDown, lilyDown2, lilyLeft, lilyLeft2, lilyRight, lilyRight2;

	int[] duration = { 200, 200 };
	static long prevTurn = System.currentTimeMillis();
	
	float lilyPosX = -320;
	float lilyPosY = 200;
	
	int dialogIndex;
	
	Boolean eventStart = false;
	
	String lilyText[] = {"Merry Christmas!",
					    "Are you busy? Check out the tree of wisdom.", "Bored? There's plenty to do!"};
	
	Image lilyFaceSet = new Image("res/characters/facesets/lilyFaceset.png");
	
	
	public Lily() throws SlickException {
		Image[] walkUpLily = { new Image("res/characters/lilyBack.png"), new Image("res/characters/lilyBack.png") };
		Image[] walkUpLily2 = { new Image("res/characters/lilyBack2.png"), new Image("res/characters/lilyBack2.png") };

		Image[] walkDownLily = { new Image("res/characters/lilyFront.png"), new Image("res/characters/lilyFront.png") };
		Image[] walkDownLily2 = { new Image("res/characters/lilyFront2.png"),new Image("res/characters/lilyFront2.png") };

		Image[] walkLeftLily = { new Image("res/characters/lilyLeft.png"), new Image("res/characters/lilyLeft.png") };
		Image[] walkLeftLily2 = { new Image("res/characters/lilyLeft2.png"),
				new Image("res/characters/lilyLeft2.png") };

		Image[] walkRightLily = { new Image("res/characters/lilyRight.png"),
				new Image("res/characters/lilyRight.png") };
		Image[] walkRightLily2 = { new Image("res/characters/lilyRight2.png"),
				new Image("res/characters/lilyRight2.png") };
		

		/* Lily animations */
		lilyUp = new Animation(walkUpLily, duration, false);
		lilyUp2 = new Animation(walkUpLily2, duration, false);

		lilyDown = new Animation(walkDownLily, duration, false);
		lilyDown2 = new Animation(walkDownLily2, duration, false);

		lilyLeft = new Animation(walkLeftLily, duration, false);
		lilyLeft2 = new Animation(walkLeftLily2, duration, false);

		lilyRight = new Animation(walkRightLily, duration, false);
		lilyRight2 = new Animation(walkRightLily2, duration, false);

		lily = lilyDown;
		
		
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		lily.isStopped();
		lily.draw(lilyPosX, lilyPosY);
		
		Random r_lily = new Random();
		int lilyMove = r_lily.nextInt(4);
		System.out.println(lilyMove);
		
		switch(lilyMove) {
			
			case 0:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyRight;
					lily.draw(lilyPosX, lilyPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 1:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyUp;
					lily.draw(lilyPosX, lilyPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 2:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyLeft;
					lily.draw(lilyPosX, lilyPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 3:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyDown;
					lily.draw(lilyPosX, lilyPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			default:
				lily = lilyDown;
				break;
		}
		
	}
	
	
	public void setMapOffset(float offsetX, float offsetY) {
		lilyPosX = offsetX + 420;
		lilyPosY = offsetY + 390;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return lilyPosX;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return lilyPosY;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 26;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 26;
	}

	@Override
	public String getDialogueWithCollidable(Collidable actor) {
		return lilyText[0];
	}

	@Override
	public Image getFaceSetWithCollidable(Collidable actor) {
		return lilyFaceSet;
	}

	@Override
	public boolean isScriptable() {
		// TODO Auto-generated method stub
		return false;
	}

}
