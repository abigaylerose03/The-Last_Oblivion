package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.kingdom.earth.*;

public class Game extends StateBasedGame {
	
	public static final String gamename = "The Last Oblivion";
	/* the individual game states */
	public static final int mainMenu = 0;
	public static final int localMap = 1;
	// public static final int castle = 2; 
	public static final int earthKingdomCity = 3;
	public static final int elifLibrary = 4;
	public static final int introGame = 5;
	public static final int elifForest = 6;

	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(mainMenu));// add menu class
		this.addState(new ElifCastle(localMap)); // remember to use enterState(id);
		this.addState(new ElifCity(earthKingdomCity));
		this.addState(new ElifLibrary(elifLibrary));
		this.addState(new IntroPart1(introGame));
		this.addState(new EarthKingdomForest(elifForest));
		// all the names of the different kingdoms
		// a battle state
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(localMap).init(gc, this);
		this.getState(earthKingdomCity).init(gc, this);
		this.getState(elifLibrary).init(gc, this);
		this.getState(introGame).init(gc,  this);
		this.getState(elifForest).init(gc, this);
		this.enterState(mainMenu);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setShowFPS(false); // removes frames per seconds from gameplay
			appgc.setDisplayMode(1000, 1000, false);
			appgc.start();
			

		} catch (SlickException e) {
			e.printStackTrace();

		}
	}
}
