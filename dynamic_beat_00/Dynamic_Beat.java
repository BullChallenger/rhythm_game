package dynamic_beat_00;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dynamic_Beat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image background = new ImageIcon(Main.class.getResource("../images/background_wallpaper.jpg")).getImage();

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuicon.png")));
	
	private ImageIcon enteredExit = new ImageIcon(Main.class.getResource("../images/entered_exit.png"));
	private ImageIcon basicExit = new ImageIcon(Main.class.getResource("../images/exit.png"));
	private ImageIcon startButtonBasic = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonPressed = new ImageIcon(Main.class.getResource("../images/startButtonPressed.png"));
	private ImageIcon quitButtonBasic = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonPressed = new ImageIcon(Main.class.getResource("../images/startButtonPressed.png"));
	private ImageIcon rightButtonBasic = new ImageIcon(Main.class.getResource("../images/rightButton.png"));
	private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getResource("../images/leftButton.png"));
	private ImageIcon easyButtonBasic = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonPressed = new ImageIcon(Main.class.getResource("../images/easyButtonPressed.png"));
	private ImageIcon hardButtonBasic = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonPressed = new ImageIcon(Main.class.getResource("../images/hardButtonPressed.png"));
	private ImageIcon backButtonBasic = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonPressed = new ImageIcon(Main.class.getResource("../images/backButtonPressed.png"));
	
	
	private JButton exitButton = new JButton(basicExit);	
	private JButton startButton = new JButton(startButtonBasic);
	private JButton quitButton = new JButton(quitButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);
	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton easyButton = new JButton(easyButtonBasic);
	private JButton hardButton = new JButton(hardButtonBasic);
	private JButton backButton = new JButton(backButtonBasic);
	
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	static ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Music intro = new Music("intro.mp3", true);
	
	private Music selectedMusic;
	private Image titleImage; 
	private Image selectedImage;
	private static int nowSelected = 0;
	
	public static Game game;
	
	public Dynamic_Beat() {
		
		trackList.add(new Track("titleImage.png", "Caaaat.jpg", "Gosegu.png", "fanService_Gosegu_Selected.mp3", "fanService_Gosegu.mp3", "fanService_Gosegu"));
		trackList.add(new Track("titleImage.png", "Re_Wind_Title.png", "Gosegu.png", "Re_Wind_Selected.mp3", "Re_Wind.mp3", "Re-Wind"));
		
		
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		intro.start();

		
		menuBar.setBounds(0, 0, 1920, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		exitButton.setBounds(30, 300, 180, 120);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(enteredExit);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(basicExit);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// try {
				//	 Thread.sleep(1000);
				/* } catch (InterruptedException ex) {
			  	 ex.printStackTrace(); 
				} */
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(30, 470, 180, 120);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonPressed);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasic);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// 게임 시작 이벤트 
				enterMain();
				
			}
		});
		add(startButton);
		
		quitButton.setBounds(30, 640, 180, 120);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(startButtonPressed);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(startButtonBasic);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// try {
				//	 Thread.sleep(1000);
				/* } catch (InterruptedException ex) {
			  	 ex.printStackTrace(); 
				} */
				System.exit(0);
			}
		});
		add(quitButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 500, 211);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonPressed);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasic);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// 메인 화면으로 돌아가는 이벤트
				backMain();
				
			}
		});
		add(backButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1520, 450, 120, 120);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonBasic);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasic);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// 오른쪽 버튼 이벤트
				selectRight();
			}
		});
		add(rightButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(320, 450, 120, 120);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonBasic);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasic);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// 완쪽 버튼 이벤트
				selectLeft();
			}
		});
		add(leftButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(920, 350, 300, 280);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonPressed);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasic);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// 쉬움 난이도 이벤트
				gameStart(nowSelected, "Easy");
				
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(920, 550, 300, 238);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonPressed);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start();
			}
			
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasic);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			public void mousePressed(MouseEvent e) {
				// Music buttonEnteredMusic = new Music(".mp3", false); 버튼 효과음
				// buttonEnteredMusic.start(); 
				// 어려움 난이도 이벤트
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);
		
	}
	
	public void paint(Graphics g) {
		screenImage	= createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic); 
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 180, null);
			g.drawImage(titleImage, 340, 180, null);
		}
		
		if(isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		} else {
			nowSelected--;
		}
		selectTrack(nowSelected);
		}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		} else {
			nowSelected++;
		}
		selectTrack(nowSelected);
		}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		backButton.setVisible(true);
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		isGameScreen = true;
		game.start();
		setFocusable(true);
		requestFocus();
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
		
		game.close();
	}
	
	public void enterMain() {
		isMainScreen = true;
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();

		startButton.setVisible(false);
		quitButton.setVisible(false);
		menuBar.setVisible(false);
		exitButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		
		intro.close();
		
		selectTrack(0);
	}

}
