package org.kingdom.earth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.characters.Lily;
import org.characters.Ray;
import org.characters.Auston;
import org.characters.Joy;

import javagame.Collidable;
import javagame.TextBox;
import javagame.TextParser;
import javagame.PlayMenu;
import javagame.RayTalk;
import javagame.Scriptable;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class EarthKingdomForest extends BasicGameState {
	Ray rayObject;
	Image worldMap;
	
	public EarthKingdomForest(int state) {
		
	}
	

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		rayObject = new Ray();
		worldMap = new Image("res/magicForest.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		worldMap.draw(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 6;
	}

}
