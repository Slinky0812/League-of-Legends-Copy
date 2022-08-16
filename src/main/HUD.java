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
		
			g2d.setColor(Color.black);
			g2d.fillRect(190, 400, 380, 80);
			
			g2d.setColor(Color.red);
			g2d.fillRect(166, 420, gp.tileSize, gp.tileSize);
			g2d.drawImage(gp.player.down1, 166, 420, gp.tileSize, gp.tileSize, null);
			
			g2d.setFont(arial_40);
			g2d.setColor(Color.white);
			int x = getXForCentreText("HUD", g2d);
			g2d.drawString("HUD", x, 450);
			
		} else if (gp.gameState == gp.pause) {
			drawPause(g2d);
		} else if (gp.gameState == gp.title) {
			drawTitle(g2d);
		}
		
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
			g2d.setColor(Color.white);
			g2d.setFont(arial_40);
			
			String text = "Choose your character";
			int x = getXForCentreText(text, g2d);
			int y = gp.tileSize * 3;
			g2d.drawString(text, x, y);
			
			text = "Miss Fortune";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize;
			g2d.drawString(text, x - gp.tileSize, y);
			if (commandNum == 0) {
				g2d.drawString(">", x-gp.tileSize, y);
			}

			text = "Master Yi";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize;
			g2d.drawString(text, x - gp.tileSize, y);
			if (commandNum == 1) {
				g2d.drawString(">", x-gp.tileSize, y);
			}

			text = "Illaoi";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize;
			g2d.drawString(text, x - gp.tileSize, y);
			if (commandNum == 2) {
				g2d.drawString(">", x-gp.tileSize, y);
			}

			text = "Back";
			x = getXForCentreText(text, g2d);
			y += gp.tileSize * 2;
			g2d.drawString(text, x - gp.tileSize, y);
			if (commandNum == 3) {
				g2d.drawString(">", x-gp.tileSize, y);
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
