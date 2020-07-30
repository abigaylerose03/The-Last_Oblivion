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

public class ElifLibrary extends BasicGameState {
	
	Ray rayObject;
	Joy joyObject;
	
	
	Image map;
	
	TextBox tb;
	
	PlayMenu playMenu;
	
	ArrayList<Collidable> objectsColide;
	ArrayList<Scriptable> scriptables2;
	
	RayTalk rayTalk;
	
	private int deltaVal;
	
	List<String> libraryText;
	

	public ElifLibrary(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		rayObject = new Ray();
		joyObject = new Joy();
		tb = new TextBox();
		playMenu = new PlayMenu();
		
		
		objectsColide = new ArrayList<Collidable>();
		objectsColide.add(joyObject);
		
		
//		scriptables2 = new ArrayList<Scriptable>();
//		scriptables2.add(joyObject);
	
		
		map = new Image("res/elifLibrary.bmp");
		
		rayObject.hero = rayObject.heroRight;
		
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.draw(rayObject.bgOffSetX + 20, rayObject.bgOffSetY);
		
		rayObject.render(gc, sbg, g, null);
		joyObject.render(gc, sbg, g);
		// rayObject.hero = rayObject.heroRight;
		tb.render(gc, sbg, g);
		playMenu.render(gc, sbg, g); // renders the play menu
		
		
		joyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		// joyObject.move(200, 200, "down", 0.87f, deltaVal);
		
		g.drawString(Float.toString(rayObject.bgOffSetX), 10, 10);
		g.drawString(Float.toString(rayObject.bgOffSetY), 100, 10);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		// deltaVal = delta;
		try {
			libraryText = Files.readAllLines(Paths.get("/Users/abigaylepeterson/library.txt"));
			for(int i = 0; i < libraryText.size(); i++) {
				if(libraryText.get(i).contains("move")) {
					joyObject.move(200, 200, "down", .1f, delta);
					joyObject.move(800, 200, "right", .1f, delta);
				}
				
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		
		try {
			libraryText = Files.readAllLines(Paths.get("/Users/abigaylepeterson/library.txt"));
			rayObject.update(gc, sbg, delta, objectsColide, tb, playMenu, libraryText);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		joyObject.update(gc, sbg, delta);
		

		rayObject.heroPosX = 810;
		rayObject.heroPosY = 120;
		
		if(rayObject.bgOffSetY >= 10 && rayObject.bgOffSetX <= 10) {
	    	rayObject.bgOffSetY -= delta * .1f;
	    	
	    	if(input.isKeyPressed(Input.KEY_RETURN)) {
	    		sbg.enterState(1); // enter the elif kingdom castle grounds 
	    	}
	    }

		tb.setOffSetX(rayObject.heroPosX - 300);
	    tb.setOffSetY(rayObject.heroPosY + 80);
	    
		
	}

	@Override
	public int getID() {
		
		return 4;
	}
	
}
	