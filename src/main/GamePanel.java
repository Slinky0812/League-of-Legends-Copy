package main;

import java.awt.*;
import javax.swing.*;
import entity.*;
import tile.*;

//will work as a game screen
public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	//screen settings
	public final int originalTileSize = 16; //16 by 16 tile for characters, map tiles, etc.
	public final int scale = 3; //scaling the tiles to look bigger on our screen
	public final int tileSize = originalTileSize * scale; //48x48 tile
	
	//how many tiles can be displayed on the screen
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 10;
	
	public final int screenWidth = tileSize * maxScreenCol; //760 pixels
	public final int screenHeight = tileSize * maxScreenRow; //480 pixels
	
	//world settings
	public final int maxWorldCol = 100;
	public final int maxWorldRow = 100;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	int FPS = 60;
	
	//system settings
	TileManager tileManager = new TileManager(this);
	public Collision cCheck = new Collision(this);
	KeyInput keyHandler = new KeyInput(this);
	public HUD hud = new HUD(this);
	Thread gameThread;
	
	public Player player = new Player(this, keyHandler);
	
	//game state
	public int gameState;
	public final int play = 1;
	public final int pause = 2;
	public final int title = 0;
	

	//constructor
	public GamePanel() {
		
		//set the size of the screen
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		
		//set the background color to black
		this.setBackground(Color.black);

		//all the drawing is done in an offscreen painting buffer, improving rendering performance
		this.setDoubleBuffered(true);

		this.addKeyListener(keyHandler);

		//the game is "focused" to receive keyboard input
		this.setFocusable(true);
	}

	public void start() {
		gameState = title;
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) {

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;

			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
		}

		if (timer >= 1000000000) {
			System.out.println("FPS: " + drawCount);
			drawCount = 0;
			timer = 0;
		}
		
	}

	public void update() {
		
		if (gameState == play) {
			player.update();
		} else if (gameState == pause) {
			
		}

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		
		//Title screen
		if (gameState == title) {
			hud.draw(g2d);
		} else {
			tileManager.draw(g2d);

			player.draw(g2d);
			
			hud.draw(g2d);

			//releases any system resources held by this graphics context.
			g2d.dispose();
		}
		
	}
}
