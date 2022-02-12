package dynamic_beat_00;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	public void keyPressed(KeyEvent e) {
		if(Dynamic_Beat.game == null) {
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			Dynamic_Beat.game.pressS();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			Dynamic_Beat.game.pressD();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			Dynamic_Beat.game.pressF();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Dynamic_Beat.game.pressSpace();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			Dynamic_Beat.game.pressJ();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			Dynamic_Beat.game.pressK();	
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			Dynamic_Beat.game.pressL();
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(Dynamic_Beat.game == null) {
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			Dynamic_Beat.game.releaseS();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			Dynamic_Beat.game.releaseD();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			Dynamic_Beat.game.releaseF();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			Dynamic_Beat.game.releaseSpace();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			Dynamic_Beat.game.releaseJ();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			Dynamic_Beat.game.releaseK();
		}
		
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			Dynamic_Beat.game.releaseL();
		}
	}
}
