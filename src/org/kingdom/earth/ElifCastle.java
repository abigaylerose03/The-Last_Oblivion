package org.kingdom.earth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.characters.Lily;
import org.characters.Ray;
import org.lwjgl.input.Mouse;
import org.characters.Auston;

import javagame.Collidable;
import javagame.TextBox;
import javagame.PlayMenu;
import javagame.RayTalk;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ElifCastle extends BasicGameState {

	Image worldMap;
	
	/* external game character entities */
	Lily lilyObject;
	Ray rayObject;
	Auston austonObject;
	
	float spriteTextX;
	float spriteTextY;
	
	TextBox tb;
	PlayMenu playMenu;
	
	public String mouse = "testtt";
	
	RayTalk rayTalk;
	
	ArrayList<Collidable> objectsColide;
	
	List<String> libraryText;
	
	// List<String> hi;

	public ElifCastle(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		lilyObject = new Lily();
		
		rayObject = new Ray();
		
		austonObject = new Auston();
		tb = new TextBox(); 
		playMenu = new PlayMenu();
		rayTalk = new RayTalk();
		
		// all of the objects you could POTENTIALLY collide with
		objectsColide = new ArrayList<Collidable>(); 
		objectsColide.add(lilyObject);
		objectsColide.add(austonObject);
		
		worldMap = new Image("res/earthKingdom.png");
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		/* the fields of heroPosX and heroPosY are public */
		worldMap.draw(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
		lilyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		austonObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
		lilyObject.render(gc, sbg, g);
		rayObject.render(gc, sbg, g, objectsColide);
		austonObject.render(gc, sbg, g);
		
		tb.render(gc, sbg, g); // renders the sprite's text box
		
		playMenu.render(gc, sbg, g); // renders the play menu
		
		g.drawString(mouse, 200, 100);

		
	}
	
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		try {
			rayObject.update(gc, sbg, delta, objectsColide, tb, playMenu, null);// libraryText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rayTalk.update(gc, sbg, tb, 0);
		
		tb.setOffSetX(rayObject.heroPosX + 25);
		tb.setOffSetY(rayObject.heroPosY + 50);
		
		playMenu.setOffSetX(rayObject.heroPosX + 20);
		playMenu.setOffSetY(rayObject.heroPosY + 40);
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		mouse =  "Mouse Position X: " + posX + "Position Y: " + posY;
		
		// if playMenu is open and user clicks on the Quit, exit to main menu state
		if(!playMenu.checkIfOpen().isEmpty() && posX > 470 && posY < 469) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(0);
			}
		}
		

		try {
			libraryText = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt"));
			rayObject.update(gc, sbg, delta, objectsColide, tb, playMenu, libraryText);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
	}
	
	@Override
	public int getID() {
		return 1;
	}

	


}
