package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javagame.TextBox;

// the purpose of RayTalk is to provide event functionality when Ray needs to say something

public class RayTalk {
	
	TextBox tb;
	Image rayFaceset;
	
	String[] rayText = {"Well, I'm looking for someone."};
	
	public RayTalk() throws SlickException {
		rayFaceset = new Image("res/characters/facesets/rayFaceset.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, TextBox tb, int arc) {
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_A)) {
			if(tb.getText().isEmpty()) {
				tb.setText(rayText[arc]);
				tb.setFaceSet(rayFaceset);
			} else {
				tb.setText("");
			}
		} 
		
	}

}
