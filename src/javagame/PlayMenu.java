package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class PlayMenu {
	
	Image gameMenu;
	
	float offsetX;
	float offsetY;
	
	String notOpen = "";
	
	public PlayMenu() throws SlickException {
		gameMenu = new Image("res/tlo-menu.jpg");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		if(!notOpen.isEmpty()) { gameMenu.draw(offsetX, offsetY); }
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	public void setOffSetX(float menuOffSetX) {
		offsetX = menuOffSetX;
	}
	
	public void setOffSetY(float menuOffSetY) {
		offsetY = menuOffSetY;
	}
	
	public String checkIfOpen() { return notOpen; }

    public void open(String newHero) {
    	notOpen = (String) newHero;
		
	}
}
