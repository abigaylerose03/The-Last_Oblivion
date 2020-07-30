package javagame;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import org.characters.*;
 
public class TextParser {
	
	String currentLine;
	
	int numSpace = 0;
	
	Joy joyObject;
	Ray rayObject;

	public TextParser() throws IOException, SlickException {
	
		joyObject = new Joy();
		rayObject = new Ray();
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta, TextBox tb, PlayMenu pm, ArrayList<Scriptable> scriptables, ArrayList<Collidable> collidables) throws SlickException, IOException {
		
		// List<String> line = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt"));
		
//		for(String l : line) {
//			l.split(" ");
//			
//		}
		// change to collidable, but must be pushing A and must know the faceset with the particular character 
		Input input = gc.getInput();
		
		
		
		if(input.isKeyPressed(Input.KEY_A)) {
			ArrayList<Collidable> collisionsInter = CollisionDetector.detectColsWithMargin(rayObject, collidables, 5);
			Scriptable charScript = (Scriptable)collisionsInter.get(0);
			
			System.out.println(charScript);
			
			if(tb.getText().isEmpty() && !collisionsInter.isEmpty()) {
				if(Scriptable.class.isAssignableFrom(charScript.getClass())) {
					tb.setText(charScript.talk("test"));
					tb.setFaceSet(charScript.getFaceSetWithCollidable(rayObject));
					// charScript.move(200, 800, "right", 0.2f, delta);
					
				}
			} else {
				tb.setText("");
			}
				
		}
	
	
			
			
			// ((Scriptable) characterScript).move(200, 200, "down", .1f, delta);
			// ((Scriptable) characterScript).move(800, 200, "right", .1f, delta);
			
			// use that for talking if not move
			// tb.setText(((Scriptable)characterScript.talk(line.get(i)));
			
		
	}
		
	
	
	
		
	
			
		
		
		/* for large files:
		String line;
		try(Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
			line32 = lines.skip(previous lines ex. 31).findFirst().get();
		
		}
		*/
	
	
	public static void main(String[] args) throws IOException {
		
		List<String> line = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt"));
		
		for(int i = 0; i < line.size(); i++) {
			
			if(line.get(i).contains("move")) {
				// move the character
			} else if(!line.get(i).contains("move")) {
				// output the string
				
			}
			System.out.println(line.get(i));
		}
		
		
	}
		
	
	

}
