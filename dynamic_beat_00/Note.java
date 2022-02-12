package dynamic_beat_00;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 550;
		}
		else if(noteType.equals("D")) {
			x = 654;
		}
		else if(noteType.equals("F")) {
			x = 758;
		}
		else if(noteType.equals("Space")) {
			x = 862;
		}
		else if(noteType.equals("J")) {
			x = 1066;
		}
		else if(noteType.equals("K")) {
			x = 1170;
		}
		else if(noteType.equals("L")) {
			x = 1274;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x+100, y, null);		
			}
		else {
			g.drawImage(noteBasicImage, x, y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 940) {
			System.out.println("Miss");
			close();
		}
	}
	
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;	 
				}
				Thread.sleep(Main.SLEEP_TIME);
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String judge() {
		if(y >= 936) {
			System.out.println("Late");
			close();
			return "Late";
		}
		else if(y >= 927) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 914) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y >= 901) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y >= 888) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y >= 875) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 862) {
			System.out.println("Early");
			close();
			return "Early";
		}
		return "None";
	}
	
	public int getY() {
		return y;
	}

}
