package dynamic_beat_00;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

public class Game extends Thread{

	private boolean gameMaker=false; 

	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeEffectImage;
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;	
	private Music gameMusic;
	
	private double tiktok1;
	private double tiktok2;
	private double tiktok3;
	private double tiktok4;
	private double tiktok5;
	private double tiktok6;
	private double tiktok7;

	
	ArrayList<Note> noteList = new ArrayList<Note>(); 
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(gameInfoImage, 0, 1020, null);
		g.drawImage(noteRouteSImage, 550, 0, null);
		g.drawImage(noteRouteDImage, 654, 0, null);
		g.drawImage(noteRouteFImage, 758, 0, null);
		g.drawImage(noteRouteSpace1Image, 862, 0, null);
		g.drawImage(noteRouteSpace2Image, 962, 0, null);
		g.drawImage(noteRouteJImage, 1066, 0, null);
		g.drawImage(noteRouteKImage, 1170, 0, null);
		g.drawImage(noteRouteLImage, 1274, 0, null);
		g.drawImage(judgementLineImage, 0, 900, null);
		
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 923) {
				judgeEffectImage = new ImageIcon(Main.class.getResource("../images/MissEffect.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 1062);
		g.drawString(difficulty, 1830, 1062);
		
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 915, 1062);
		
		g.drawImage(blueFlareImage, 160, 370, null);
		g.drawImage(judgeEffectImage, 760, 530, null);
		
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 592, 929);
		g.drawString("D", 696, 929);
		g.drawString("F", 800, 929);
		g.drawString("Space Bar", 903, 929);
		g.drawString("J", 1108, 929);
		g.drawString("K", 1212, 929);
		g.drawString("L", 1316, 929);
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSnare.mp3", false).start();
		if(gameMaker == true) {
			   System.out.println(gameMusic.getTime()+"S");
			  }
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSnare.mp3", false).start();
		if(gameMaker == true) {
			   System.out.println(gameMusic.getTime()+"D");
			  }
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSnare.mp3", false).start();
		if(gameMaker == true) {
			   System.out.println(gameMusic.getTime()+"F");
			  }
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSnareHigh.mp3", false).start();
		if(gameMaker == true) {
			   System.out.println(gameMusic.getTime()+"Space");
			  }
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSnare.mp3", false).start();
		if(gameMaker == true) {
			   System.out.println(gameMusic.getTime()+"J");
			  }
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSnare.mp3", false).start();
		if(gameMaker == true) {
			   System.out.println(gameMusic.getTime()+"K");
			  }
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSnare.mp3", false).start();
		if(gameMaker == true) {
			   System.out.println(gameMusic.getTime()+"L");
			  }
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	/*public void metronom() {
		Random rand = new Random();
		
		Metronom[] tiktoks = null;

		for (double i = 0; i <= 247000; i += 508.4745762711864) {
			int k = rand.nextInt(2);
			if (k != 0) {
				tiktok1 =+ i;
			}
		}
		for (double i = 0; i <= 247000; i += 508.4745762711864) {
			int k = rand.nextInt(2);
			if (k != 0) {
				tiktok2 =+ i;
			}
		}
		for (double i = 0; i <= 247000; i += 508.4745762711864) {
			int k = rand.nextInt(2);
			if (k != 0) {
				tiktok3 =+ i;
			}
		}
		for (double i = 0; i <= 247000; i += 508.4745762711864) {
			int k = rand.nextInt(2);
			if (k != 0) {
				tiktok4 =+ i;
			}
		}
		for (double i = 0; i <= 247000; i += 508.4745762711864) {
			int k = rand.nextInt(2);
			if (k != 0) {
				tiktok5 =+ i;
			}
		}
		for (double i = 0; i <= 247000; i += 508.4745762711864) {
			int k = rand.nextInt(2);
			if (k != 0) {
				tiktok6 =+ i;
			}
		}
		for (double i = 0; i <= 247000; i += 508.4745762711864) {
			int k = rand.nextInt(2);
			if (k != 0) {
				tiktok7 =+ i;
			}
		}
	}*/
	
	public void dropNotes(String titleName) {
		
		Beat[] beats = null;
				
		if(titleName.equals("fanService_Gosegu") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			
			/*metronom();*/
						
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "Space"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "F"),
					new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 16, "F"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 20, "J"),
					new Beat(startTime + gap * 22, "K"),
					new Beat(startTime + gap * 24, "L"),
					new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 28, "J"),
					new Beat(startTime + gap * 30, "K"),
					new Beat(startTime + gap * 32, "L"),
					new Beat(startTime + gap * 34, "Space"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 38, "J")
			};
		}
		else if(titleName.equals("fanService_Gosegu") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			
			/*metronom();*/
						
			beats = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + gap * 2, "Space"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "F"),
					new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 16, "F"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 20, "J"),
					new Beat(startTime + gap * 22, "K"),
					new Beat(startTime + gap * 24, "L"),
					new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 28, "J"),
					new Beat(startTime + gap * 30, "K"),
					new Beat(startTime + gap * 32, "L"),
					new Beat(startTime + gap * 34, "Space"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 38, "J")
			};
		}
		else if(titleName.equals("Re-Wind") && difficulty.equals("Easy")) {
			int startTime = 500;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime + gap * 2, "Space"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "F"),
					new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 16, "F"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 20, "J"),
					new Beat(startTime + gap * 22, "K"),
					new Beat(startTime + gap * 24, "L"),
					new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 28, "J"),
					new Beat(startTime + gap * 30, "K"),
					new Beat(startTime + gap * 32, "L"),
					new Beat(startTime + gap * 34, "Space"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 38, "J")
			};
		}
		else if(titleName.equals("Re-Wind") && difficulty.equals("Hard")) {
			int startTime = 500;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime + gap * 2, "Space"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "F"),
					new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"),
					new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 16, "F"),
					new Beat(startTime + gap * 18, "Space"),
					new Beat(startTime + gap * 20, "J"),
					new Beat(startTime + gap * 22, "K"),
					new Beat(startTime + gap * 24, "L"),
					new Beat(startTime + gap * 26, "K"),
					new Beat(startTime + gap * 28, "J"),
					new Beat(startTime + gap * 30, "K"),
					new Beat(startTime + gap * 32, "L"),
					new Beat(startTime + gap * 34, "Space"),
					new Beat(startTime + gap * 36, "S"),
					new Beat(startTime + gap * 38, "J")
			};
		}
		int i = 0;
		gameMusic.start();	
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
		}

	}
	
	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			blueFlareImage= new ImageIcon(Main.class.getResource("../images/blueFlareEffect.png")).getImage();
		}
		
		if(judge.equals("Ealry")) {
			judgeEffectImage = new ImageIcon(Main.class.getResource("../images/EarlyEffect.png")).getImage();
		}
		
		else if(judge.equals("Late")) {
			judgeEffectImage = new ImageIcon(Main.class.getResource("../images/LateEffect.png")).getImage();
		}

		else if(judge.equals("Good")) {
			judgeEffectImage = new ImageIcon(Main.class.getResource("../images/GoodEffect.png")).getImage();
		}
		
		else if(judge.equals("Great")) {
			judgeEffectImage = new ImageIcon(Main.class.getResource("../images/GreatEffect.png")).getImage();
		}
		
		else if(judge.equals("Perfect")) {
			judgeEffectImage = new ImageIcon(Main.class.getResource("../images/PerfectEffect.png")).getImage();
		}
	}
	
}
