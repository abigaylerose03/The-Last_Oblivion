package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Menu extends BasicGameState {
	
	Music music; 
	Music musicCity; // elif kingdom city1 music 
	
	Image playGame;
	Image exitGame;
	Image dragon; // background image
	
	// public String mouse = "testing 123"; // for the mouse cors, future use
	
	public Menu(int state) {}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		dragon = new Image("res/dragon.jpg");
		playGame = new Image("res/playNow.png");
		exitGame = new Image("res/exitNow.png");
		
		music = new Music("res/music/testMusic.ogg");
		music.setVolume(0.2f);
		
		if(!music.playing() && sbg.getCurrentStateID() == 0) {
			music.play();
		} 
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		dragon.draw(0, 0);
		g.drawString("The Last Oblivion", 100, 50);
		// g.drawString(mouse, 150, 50); 
		playGame.draw(80, 95);
		exitGame.draw(955, 10);
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		// mouse = "Mouse position x: " + posX + "y: " + posY; 

		/* play now button */
		if((posX > 100 && posX < 390) && (posY > 830 && posY < 890)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(3); // play state
			}
		}
		
		/* exit now button */
		if((posX > 950 && posX < 999) && (posY > 950 && posY < 999)) {
			if(Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
		
	}

	@Override
	public int getID() { return 0; }

}
