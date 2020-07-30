package javagame;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.awt.Font;

public class IntroPart1 extends BasicGameState {
	
	private int timer;
	private int timerLast = 9200;
	boolean fade;
	
	Font font;
	TrueTypeFont ttf;
	
	private String currentText;
	// private Boolean transition = true;

	ArrayList<String> begin; // stores every start game message
	
	Music introMusic;
	
	// int sum;
	
	public IntroPart1(int state) {
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		begin = new ArrayList<String>();
		begin.add("I will remember this day forever.");
		begin.add("This cold day...everything changed");
		begin.add("Ice, guardian of the trechorous snowy wastelands...");
		begin.add("Ice betrayed the rest of the dragons without hesitation");
		begin.add("I coudl hear his angry voice");
		begin.add("Why? For as long as I started my training\n "
				+ "with the blessed gift of frost YOU gave me...");
		begin.add("I did not know what to do next");
		begin.add("Ice let out\n"
				+ " a ferocious roar that was incomprehensible");
		begin.add("Nobody could come and rescue me");
		begin.add("The dream I had last night...led me here");
		begin.add("Before I could literally do anything, just anything...\n"
				+ "Ice disappeared. To steal the Heart. To Oblvion.");
		
		
		font = new Font("Century Gothic", Font.PLAIN, 13);
		ttf = new TrueTypeFont(font, true);
		
		introMusic = new Music("res/music/introMusic.ogg");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		g.drawString("Year 1010, Nefroz Kingdom", 10, 10);
		
	    float timerPercent = (float) timer / timerLast;
	   
	    int alphaPercent = (int) (100 * timerPercent);
	      
        g.setColor(new Color(255, 255, 255, alphaPercent));
    
        ttf.drawString(250, 250, currentText);
     // g.drawString(Integer.toString(sum), 100, 100);
        
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
			for(int i = 0; i < begin.size(); i++) {
				if (fade) {
			        timer += delta;
			        
			    
			         if (timer > timerLast) {
			        	currentText = begin.get(i);
			            fade = !fade;
			            
			        
			          	// currentText = begin.get(i);
			            
			         }
			         
			      } else {
			         timer -= delta;
			       	
			         if (timer < 0) { 
			            fade = !fade;
			           
			          	currentText = begin.get(i);
			         
			         }
			         
			         if(i == 6 || i == 8) { // fade to starting screen if the index equals 6 or 8
			        	 fade = !fade;
			        	 sbg.enterState(4, new FadeOutTransition(), new FadeInTransition());
			         }
			         // transition = !transition;
			         
		      
			    } 
		} 
		
			
	
		
		if(!introMusic.playing()) {
			introMusic.setVolume(0.3f);
			introMusic.loop();
		}
		
	}
	
	public int getID() { return 5; }


}
