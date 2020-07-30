package org.characters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javagame.Collidable;
import javagame.CollisionDetector;

import javagame.TextBox;
import javagame.Talkable;
import javagame.PlayMenu;

// import javagame.RayTalk;
import javagame.Scriptable;

public class Ray implements Collidable {
	
	public Animation hero;
	Animation heroUp;

	Animation heroUp2;

	Animation heroUp3;

	Animation heroDown;

	Animation heroDown2;

	Animation heroDown3;

	Animation heroLeft;

	Animation heroLeft2;

	Animation heroLeft3;

	public Animation heroRight;

	Animation heroRight2;

	Animation heroRight3;

	Animation heroBlink;

	Animation heroBlink2;

	Animation heroSwordRight;

	boolean move, move2, move3, move4 = true; // the move variables define each movement of the sprite
												// true: can move legs/arms
												// cannot move its legs/arms
	boolean quit = false;
	int[] duration = { 200, 200 };
	static long prevTurn = System.currentTimeMillis();

	public float bgOffSetX = -110;
	public float bgOffSetY = -100;
	
	public float heroPosX = 210;
	public float heroPosY = 250;
	
	public int heroIntPosX = 210;
	public int heroIntPosY = 250;
	
	public float spriteTextX = 0;
	public float spriteTextY = 0;
	
	public float textX;
	public float textY;
	
	public float currentTextX;
	public float currentTextY;
	
	boolean newGame = true;
	
	Animation runUp, runLeft, runDown, runRight;
	
	Image walkUp;
	Image walkUp2;
	Image walkUp3;
	
	Image walkLeft;
	Image walkLeft2;
	Image walkLeft3;
	Image walkLeft4;
	
	Image walkDown;
	Image walkDown2;
	Image walkDown3;
	Image walkDown4;
	
	Image walkRight, walkRight2, walkRight3;
	
	Image fs; // faceset
	
	int numSpace = 0;
	
	
	
	public ArrayList<Collidable> oldCollisions;

	public Ray() throws SlickException {
	
		walkUp = new Image("res/characters/heroBack.png");
		walkUp2 = new Image("res/characters/heroBack2.png");
		walkUp3 = new Image("res/characters/heroBack3.png");
		
		walkLeft = new Image("res/characters/heroLeft.png");
		walkLeft2 = new Image("res/characters/rayLeft2.png");
		walkLeft3 = new Image("res/characters/rayLeft3.png");
		walkLeft4 = new Image("res/characters/rayLeft4.png");
		
		walkDown = new Image("res/characters/heroFront.png");
		walkDown2 = new Image("res/characters/heroFront2.png");
		walkDown3 = new Image("res/characters/heroFront3.png");
		walkDown4 = new Image("res/characters/heroFront4.png");
		
		walkRight = new Image("res/characters/heroRight.png");
		walkRight2 = new Image("res/characters/heroRight2.png");
		walkRight3 = new Image("res/characters/heroRight3.png");
	
		runUp = new Animation();
		runLeft = new Animation();
		runDown = new Animation();
		runRight = new Animation();
		
		
		runUp.addFrame(walkUp, 100);
		runUp.addFrame(walkUp2, 100);
		runUp.addFrame(walkUp3, 100);
		
		runLeft.addFrame(walkLeft, 100);
		runLeft.addFrame(walkLeft2, 100);
		runLeft.addFrame(walkLeft3, 100);
		runLeft.addFrame(walkLeft4, 100);
		
		runDown.addFrame(walkDown, 100);
		runDown.addFrame(walkDown2, 100);
		runDown.addFrame(walkDown3, 100);
		
		runRight.addFrame(walkRight, 150);
		runRight.addFrame(walkRight2, 150);
		runRight.addFrame(walkRight3, 150);
		
		Image[] walkUp = { new Image("res/characters/heroBack.png"), new Image("res/characters/heroBack.png") };
		Image[] walkUp2 = { new Image("res/characters/heroBack2.png"), new Image("res/characters/heroBack2.png") };
		Image[] walkUp3 = { new Image("res/characters/heroBack3.png"), new Image("res/characters/heroBack3.png") };

		Image[] walkDown = { new Image("res/characters/heroFront.png"), new Image("res/characters/heroFront.png") };
		Image[] walkDown2 = { new Image("res/characters/heroFront2.png"), new Image("res/characters/heroFront2.png") };
		Image[] walkDown3 = { new Image("res/characters/heroFront3.png"), new Image("res/characters/heroFront3.png") };

		Image[] walkLeft = { new Image("res/characters/heroLeft.png"), new Image("res/characters/heroLeft.png") };
		Image[] walkLeft2 = { new Image("res/characters/heroLeft2.png"), new Image("res/characters/heroLeft2.png") };
		Image[] walkLeft3 = { new Image("res/characters/heroLeft3.png"), new Image("res/characters/heroLeft3.png") };
		

		Image[] walkRight = { new Image("res/characters/heroRight.png"), new Image("res/characters/heroRight.png") };
		Image[] walkRight2 = { new Image("res/characters/heroRight2.png"), new Image("res/characters/heroRight2.png") };
		Image[] walkRight3 = { new Image("res/characters/heroRight3.png"), new Image("res/characters/heroRight3.png") };

		fs = new Image("res/characters/facesets/rayFaceset.png");
		
		heroUp = new Animation(walkUp, duration, false);
		heroUp2 = new Animation(walkUp2, duration, false);
		heroUp3 = new Animation(walkUp3, duration, false);

		heroDown = new Animation(walkDown, duration, false);
		heroDown2 = new Animation(walkDown2, duration, false);
		heroDown3 = new Animation(walkDown3, duration, false);

		heroLeft = new Animation(walkLeft, duration, false);
		heroLeft2 = new Animation(walkLeft2, duration, false);
		heroLeft3 = new Animation(walkLeft3, duration, false);

		heroRight = new Animation(walkRight, duration, false);
		heroRight2 = new Animation(walkRight2, duration, false);
		heroRight3 = new Animation(walkRight3, duration, false);
		
		hero = heroDown;

		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g, ArrayList<Collidable> collidables) throws SlickException {
		hero.draw(heroPosX, heroPosY);
		// runUp.draw(heroPosX, heroPosY);
		
	
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta, ArrayList<Collidable> collidables, TextBox tb, PlayMenu pm, List<String> currentScript) throws SlickException, IOException {
		Input input = gc.getInput();

		
		float currentX = bgOffSetX;
		float currentY = bgOffSetY;
		
		float currentHeroX = heroPosX;
		float currentHeroY = heroPosY;
		
		runUp.setAutoUpdate(true);
		runLeft.setAutoUpdate(true);

		/* left movement */
		if (input.isKeyDown(Input.KEY_LEFT)) {
			hero = runLeft;
			bgOffSetX += delta * .1f;
			heroPosX -= delta * .1f;
			
			runLeft.update(delta);
		
		}

		if (sbg.getCurrentStateID() == 1 && bgOffSetX > 206) {
			bgOffSetX -= delta * .1f;
		} 

			/* tree collision 
			if (bgOffSetX > -30 && bgOffSetY < -198 && bgOffSetY > -278) {
				bgOffSetX -= delta * .1f;
			}

			if (bgOffSetX > -424 && bgOffSetY < -163 && bgOffSetY > -414) {
				bgOffSetX -= delta * .1f;
			}

			/* castle bushes 
			if (bgOffSetX > -78 && bgOffSetY < -93 && bgOffSetY > -113) {
				bgOffSetX -= delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetX > -293 && bgOffSetY < -684 && bgOffSetY > -714) {
				bgOffSetX -= delta * .1f;
			}

			if (bgOffSetX > -356 && bgOffSetY < -563 && bgOffSetY > -665) {
				bgOffSetX -= delta * .1f;
			}

			if (bgOffSetX > -4 && bgOffSetY < -483 && bgOffSetY > -559) {
				bgOffSetX -= delta * .1f;
			}

			/* tree with rock 
			if (bgOffSetX > -9 && bgOffSetY < -479 && bgOffSetY > -565) {
				bgOffSetX -= delta * .1f;
			}

		} else if (move == false) {
			hero = heroLeft;
			
			move = true;
		} */

		/* up movement */
		if (input.isKeyDown(Input.KEY_UP)) {
			hero = runUp;
			bgOffSetY += delta * .1f;
			heroPosY -= delta * .1f;
			runUp.update(delta);
		}

		 if (sbg.getCurrentStateID() == 1 && bgOffSetY > 260) {
			bgOffSetY -= delta * .1f;
		} 

			/* tree collisions 
			if (bgOffSetX > 1 && bgOffSetX < 61) {
				bgOffSetY -= delta * .1f;
			}

			if (bgOffSetX > -398 && bgOffSetX < -323) {
				bgOffSetY -= delta * .1f;
			}

			/* castle bushes 
			if (bgOffSetY > -123 && bgOffSetX > -51 && bgOffSetX < 178) {
				bgOffSetY -= delta * .1f;
			}

			if (bgOffSetY > -120 && bgOffSetX > -438 && bgOffSetX < -202) {
				bgOffSetY -= delta * .1f;
			}

			/* castle entrance 
			if (bgOffSetY > -89 && bgOffSetX > -188 && bgOffSetX < -75) {
				bgOffSetY -= delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetY > -668 && bgOffSetX > -366 && bgOffSetX < -283) {
				bgOffSetY -= delta * .1f;
			}

			if (bgOffSetY > -556 && bgOffSetX > 112 && bgOffSetX < 133) {
				bgOffSetY -= delta * .1f;
			}

			/* tree with the rock 
			if (bgOffSetY > -577 && bgOffSetX > 29 && bgOffSetX < 110) {
				bgOffSetY -= delta * .1f;
			}

		} else if (move2 == false) {
			hero = heroUp;
			move2 = true;
		} */

		/* down movement */
		if (input.isKeyDown(Input.KEY_DOWN)) {
			hero = runDown;
			bgOffSetY -= delta * .1f;
			heroPosY += delta * .1f;
			runDown.update(delta);
		} 
	
		// the down collision border for the castle earth kingdom state 
		if (sbg.getCurrentStateID() == 1 && bgOffSetY < -715) {
			bgOffSetY += delta * .1f;
			
			if(input.isKeyPressed(Input.KEY_RETURN)) {
				sbg.enterState(3);
			}
			
			
		} 
		
		if(input.isKeyPressed(Input.KEY_S)) {
			hero = heroSwordRight;
		}
	

			/* tree collisions 
			if (bgOffSetY < -155 && bgOffSetX > -1 && bgOffSetX < 61) {
				bgOffSetY += delta * .1f;
			}

			if (bgOffSetY < -141 && bgOffSetX > -396 && bgOffSetX < -316) {
				bgOffSetY += delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetY < -534 && bgOffSetX > -329 && bgOffSetX < -131) {
				bgOffSetY += delta * .1f;
			}

			if (bgOffSetY < -603 && bgOffSetX > -109 && bgOffSetX < -27) {
				bgOffSetY += delta * .1f;
			}

			/* tree with rock 
			if (bgOffSetY < -441 && bgOffSetX > 46 && bgOffSetX < 101) {
				bgOffSetY += delta * .1f;
			}

			/* cluster of rocks 
			if (bgOffSetY < -663 && bgOffSetX > -780 && bgOffSetX < -641) {
				bgOffSetY += delta * .1f;
			}

			if (bgOffSetY < -667 && bgOffSetX > -718 && bgOffSetX < -678) {
				bgOffSetY += delta * .1f;
			}

		} 
		} */

		/* right movement */
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			hero = runRight;
			bgOffSetX -= delta * .1f;
			heroPosX += delta * .1f;
			runRight.update(delta);
		
			
		} 
		

		 if (bgOffSetX < -781) {
			 bgOffSetX += delta * .1f;
		}

			/* tree collisions 
			if (bgOffSetX < 80 && bgOffSetY < -178 && bgOffSetY > -268) {
				bgOffSetX += delta * .1f;
			}

			if (bgOffSetX < -300 && bgOffSetY < -159 && bgOffSetY > -235) {
				bgOffSetX += delta * .1f;
			}

			/* castle bushes 
			if (bgOffSetX < -182 & bgOffSetY < -85 && bgOffSetY > -113) {
				bgOffSetX += delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetX < -110 & bgOffSetY < -563 && bgOffSetY > -602) {
				bgOffSetX += delta * .1f;
			}

			if (bgOffSetX < -6 & bgOffSetY < -637 && bgOffSetY > -714) {
				bgOffSetX += delta * .1f;
			}

			/* tree with rock 
			if (bgOffSetX < 132 & bgOffSetY < -467 && bgOffSetY > -554) {
				bgOffSetX += delta * .1f;
			}

			/* cluster of rocks 
			if (bgOffSetX < -656 & bgOffSetY < -677 && bgOffSetY > -714) {
				bgOffSetX += delta * .1f;
			}

		} else if (move4 == false) {
			hero = heroRight;
			move4 = true;
		} */
		
		 
		// List<String> libraryText = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt"));

		
		ArrayList<Collidable> collisions = CollisionDetector.detectCols(this, collidables);
		
		if(!collisions.isEmpty()) {
			bgOffSetX = currentX;
			bgOffSetY = currentY;
			
		}
		heroPosX = currentHeroX;
		heroPosY = currentHeroY;
		
		if(input.isKeyPressed(Input.KEY_SPACE)) {	
			ArrayList<Collidable> collisionsInter = CollisionDetector.detectColsWithMargin(this, collidables, 5);
			Talkable character = (Talkable)collisionsInter.get(0);
			// if the text box isn't already up and there's a collision 
			if(tb.getText().isEmpty() && !collisionsInter.isEmpty()) {
				
				// is it safe to treat the object, anything, we collided with as Talkable interface
				if(Talkable.class.isAssignableFrom(collisionsInter.get(0).getClass())) {
					
					tb.setText(character.getDialogueWithCollidable(this));
					tb.setFaceSet(character.getFaceSetWithCollidable(this));			
				}
				
			
			
			} else {
				tb.setText("");
				
			}
			
		// when writing the script, make sure to go every other line, due to pressing 'A' to exit out the textbox	
		} else if(input.isKeyPressed(Input.KEY_A)) {
			numSpace++;
			System.out.println(numSpace);
			
			ArrayList<Collidable> collisionsInter = CollisionDetector.detectColsWithMargin(this, collidables, 5);
			Scriptable charScript = (Scriptable)collisionsInter.get(0);
			
			
			
			// if the text box isn't already up and there's a collision 
			if(tb.getText().isEmpty() && !collisionsInter.isEmpty()) {
				
				// is it safe to treat the object, anything, we collided with as Talkable interface
				if(Scriptable.class.isAssignableFrom(collisionsInter.get(0).getClass())) {
					
						if(currentScript.get(0).contains("move")) {
							tb.setText(charScript.talk(currentScript.get(numSpace)));
							
							tb.setFaceSet(charScript.getFaceSetWithCollidable(this));
							
							if(currentScript.get(numSpace).contains("Ray:")) {
								tb.setText(currentScript.get(numSpace));
								tb.setFaceSet(fs);
							}
						}
									
					}
				
			
			
			} else {
				tb.setText(""); // maybe set this to Ray's interaction?
				
			}
					
			
//		} if(numSpace > currentScript.size()) {
//			tb.setText("");
//		}
		
		// play menu will soon allow for different party members
		if(input.isKeyPressed(Input.KEY_M)) {
			if(pm.checkIfOpen().isEmpty()) {
				pm.open("placeholder");
			} else {
				pm.open("");
			}
		}
		
		}
	
		
		
	}
	

	@Override
	public float getX() {
		
		return heroPosX;
	}

	@Override
	public float getY() {
		
		return heroPosY;
	}

	@Override
	public float getWidth() {
		
		return 26;
	}

	@Override
	public float getHeight() {

		return 26;
	}

	@Override
	public boolean isScriptable() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
