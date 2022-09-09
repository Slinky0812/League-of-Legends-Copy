package main;

import java.awt.*;

public class HUD {
	
	GamePanel gp;
	Font arial_40;
	Font arial_100;
	public int commandNum = 0;
	public int titleScreen = 0; //0 - title screen. //1 - character selection screen
	
	public HUD (GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_100 = new Font("Arial", Font.BOLD, 100);
	}
	
	
	public void draw(Graphics2D g2d) {
		
		if (gp.gameState == gp.play) {
			drawGame(g2d);
		} else if (gp.gameState == gp.pause) {
			drawPause(g2d);
		} else if (gp.gameState == gp.title) {
			drawTitle(g2d);
		}
		
	}
	
	public void drawGame(Graphics2D g2d) {
		//background of box
		g2d.setColor(Color.black);
		g2d.fillRect(256, 560, 512, 80);
		
		//player image
		g2d.setColor(Color.red);
		g2d.fillRect(224, 570, gp.tileSize, gp.tileSize);
		g2d.drawImage(gp.player.down1, 224, 570, gp.tileSize, gp.tileSize, null);
		
		//health bar
		g2d.setColor(Color.white);
		g2d.drawRect(308, 570, 300, 25);
		g2d.setColor(Color.green);
		g2d.fillRect(309, 571, 299, 24);
		
		g2d.setColor(Color.white);
		String text = "Health = " + gp.player.health + "/100";
		int x = (int) (((309 + 299)/2) + (gp.tileSize * 1.75));
		int y = (int) (((571 + 24)/2) + (gp.tileSize*4.52));
		g2d.drawString(text, x, y);
		
		//mana bar
		g2d.setColor(Color.white);
		g2d.drawRect(308, 609, 300, 25);
		g2d.setColor(Color.blue);
		g2d.fillRect(309, 610, 299, 24);
		
		g2d.setColor(Color.white);
		text = "Mana = " + gp.player.mana + "/100";
		x = (int) (((309 + 299)/2) + (gp.tileSize * 1.75));
		y = (int) (((610 + 24)/2) + (gp.tileSize*4.82));
		g2d.drawString(text, x, y);
		
		//inventory
		g2d.setColor(Color.darkGray);
		g2d.fillRect(624, 570, 130, 64);
		
		g2d.setColor(Color.black);
		g2d.fillRect(634, 578, 20, 20);
		g2d.fillRect(664, 578, 20, 20);
		g2d.fillRect(694, 578, 20, 20);
		g2d.fillRect(724, 578, 20, 20);
		g2d.fillRect(634, 606, 20, 20);
		g2d.fillRect(664, 606, 20, 20);
		g2d.fillRect(694, 606, 20, 20);
		g2d.fillRect(724, 606, 20, 20);
		
		
	}
	
	public void drawTitle(Graphics2D g2d) {
				
		if (titleScreen == 0) {
			g2d.setFont(arial_100);
			
			String text = "League Copy";
			int x = getXForCentreText(text, g2d);
			int y = gp.tileSize * 3;
			
			//shadow
			g2d.setColor(Color.gray);
			g2d.drawString(text, x+5, y+5);
			
			//title
			g2d.setColor(Color.white);
			g2d.drawString(text, x, y);
			
			//player image
			x = gp.screenWidth/2 - ((gp.tileSize*2)/ 2);
			y += gp.tileSize * 2;
			
			g2d.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
			
			//menu
			g2d.setFont(arial_40);
			
			text = "Find Game";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize * 3;
			g2d.drawString(text, x, y);
			if (commandNum == 0) {
				g2d.drawString(">", x-gp.tileSize, y);
			}
			
			text = "Quit";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize;
			g2d.drawString(text, x, y);
			if (commandNum == 1) {
				g2d.drawString(">", x-gp.tileSize, y);
			}	
		} else if (titleScreen == 1) {
			
			//character selection screen
			g2d.setFont(arial_100);
			
			String text = "Choose character";
			int x = getXForCentreText(text, g2d);
			int y = gp.tileSize * 3;
			
			//shadow
			g2d.setColor(Color.gray);
			g2d.drawString(text, x+5, y+5);
			
			//title
			g2d.setColor(Color.white);
			g2d.drawString(text, x, y);
			
			g2d.setFont(arial_40);
			
			text = "Miss Fortune";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize;
			g2d.drawString(text, x, y);
			if (commandNum == 0) {
				g2d.drawString(">", x - gp.tileSize, y);
			}

			text = "Master Yi";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize;
			g2d.drawString(text, x, y);
			if (commandNum == 1) {
				g2d.drawString(">", x - gp.tileSize, y);
			}

			text = "Illaoi";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize;
			g2d.drawString(text, x, y);
			if (commandNum == 2) {
				g2d.drawString(">", x - gp.tileSize, y);
			}

			text = "Back";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize * 2;
			g2d.drawString(text, x, y);
			if (commandNum == 3) {
				g2d.drawString(">", x - gp.tileSize, y);
			}
		}
	}
	



	public void drawPause(Graphics2D g2d) {
		
		g2d.setFont(arial_40);
		g2d.setColor(Color.white);
		
		String text = "pause";
		int x = getXForCentreText(text, g2d);		
		int y = gp.screenHeight / 2;
		
		g2d.drawString(text, x, y);
	}
	
	public int getXForCentreText(String text, Graphics2D g2d) {
		int length = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
		int x = gp.screenWidth/2 - length/2;
		
		return x;
	}
}
