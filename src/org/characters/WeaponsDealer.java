package org.characters;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import javagame.Collidable;
import javagame.Talkable;
import javagame.TextBox;

public class WeaponsDealer implements Collidable, Talkable { 
	
	static Animation wdDealer, wdDown;
	int duration[] = {200, 200};
	
	float wdPosX = -400;
	float wdPosY = 270;
	
	float textX;
	float textY;
	
	TextBox tb;
	
	int dialogIndex;
	
	Image wdFaceSet = new Image("res/characters/facesets/weaponsDealerFaceset.png"); 
	
	public String wdText[] = {"Weapons Dealer:\n" + "Only the best weapons in all of Unkwnovian!\n" + "What would you like to buy?", "hi"};
	
	public WeaponsDealer() throws SlickException {
		Image[] wdFront = { new Image("res/characters/elifWeaponsDealer.png"), new Image("res/characters/elifWeaponsDealer.png") };
		
		wdDown = new Animation(wdFront, duration, false);
		wdDealer = wdDown;
		
	}
	
	public void render(GameContainer gc, StateBasedGame arg1, Graphics arg2) throws SlickException {
		wdDealer.draw(wdPosX, wdPosY);
	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, ArrayList<Collidable> collidables, TextBox tb) {
	
	}
	
	public void setMapOffset(float offsetx, float offsety) {
		wdPosX = offsetx + 980;
		wdPosY = offsety + 95;
		
	}
		
		

	@Override
	public float getX() { return wdPosX; }

	@Override
	public float getY() { return wdPosY; }

	@Override
	public float getWidth() { return 26; }

	@Override
	public float getHeight() { return 26; }

	@Override
	public String getDialogueWithCollidable(Collidable actor) {
		return wdText[0];
	}

	@Override
	public Image getFaceSetWithCollidable(Collidable actor) {
		// TODO Auto-generated method stub
		return wdFaceSet;
	}

	@Override
	public boolean isScriptable() {
		// TODO Auto-generated method stub
		return false;
	}


}

	