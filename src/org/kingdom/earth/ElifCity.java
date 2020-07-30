package org.kingdom.earth;

import org.characters.Lily;
import org.characters.Ray;
import org.characters.WeaponsDealer;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import javagame.Collidable;
import javagame.TextBox;
import javagame.PlayMenu;
import javagame.RayTalk;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class ElifCity extends BasicGameState {
	
	Image worldMap;
	
	Ray rayObject;
	Lily lilyObject;
	WeaponsDealer wdObject;
	
	TextBox tb;
	PlayMenu playMenu;
	
	ArrayList<Collidable> objectsColide;
	
	Music music2;
	
	RayTalk rayTalk;
	
	List<String> libraryText;
	
	String mouse;
	
	// List<String> libraryText;
	
	
	
	public ElifCity(int state) {}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		worldMap = new Image("res/earthKingdomTown.bmp");
		
		rayObject = new Ray();
		lilyObject = new Lily();
		wdObject = new WeaponsDealer();
		
		tb = new TextBox();
		playMenu = new PlayMenu();
		
		
		objectsColide = new ArrayList<Collidable>();
		
		objectsColide.add(lilyObject);
		objectsColide.add(wdObject);
		
		music2 = new Music("res/music/elifTheme.ogg");
		music2.setVolume(0.3f);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		worldMap.draw(rayObject.bgOffSetX + 10, rayObject.bgOffSetY - 10);
		
		lilyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY - 50);
		wdObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
		lilyObject.render(gc, sbg, g);
		rayObject.render(gc, sbg, g, null);
		wdObject.render(gc, sbg, g);
		
		// g.drawString(mouse, 200, 200);
		

		g.drawString(Float.toString(rayObject.bgOffSetX), 10, 10);
		g.drawString(Float.toString(rayObject.bgOffSetY), 100, 10);
		
		tb.render(gc, sbg, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
//		int posX = Mouse.getX();
//		int posY = Mouse.getY();
//		
//		mouse =  "Mouse Position X: " + posX + "Position Y: " + posY;
//		
		Input input = gc.getInput();
		
		try {
			libraryText = Files.readAllLines(Paths.get("/Users/abigaylepeterson/library.txt"));
			rayObject.update(gc, sbg, delta, objectsColide, tb, playMenu, libraryText );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rayObject.heroPosX = 233;
		rayObject.heroPosY = 10;

		tb.setOffSetX(rayObject.heroPosX + 25);
	    tb.setOffSetY(rayObject.heroPosY + 50);
	    
	    
	    if(rayObject.bgOffSetY >= 10 && rayObject.bgOffSetX <= 10) {
	    	rayObject.bgOffSetY -= delta * .1f;
	    	
	    	if(input.isKeyPressed(Input.KEY_RETURN)) {
	    		sbg.enterState(1); // enter the elif kingdom castle grounds 
	    	}
	    }
	    
	    if (rayObject.bgOffSetY <= -1140) {
			rayObject.bgOffSetY += delta * .1f;
	    }
	    
	    if(!music2.playing()) {
			music2.play();
		}
	}
	
	
	  
		
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

	

}
