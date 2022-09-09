package object;

import java.awt.image.*;
import java.awt.*;
import main.*;

public class GameObject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	Utility utility = new Utility();
	
	public void draw(Graphics2D g2d, GamePanel gp) {
		
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		//stop moving camera at the edge of the map;
		if (gp.player.screenX > gp.player.worldX) {
			screenX = worldX;
		}
		if (gp.player.screenY > gp.player.worldY) {
			screenY = worldY;
		}
		int rightOffset = gp.screenWidth - gp.player.screenX;
		if (rightOffset > gp.worldWidth - gp.player.worldX) {
			screenX = gp.screenWidth - (gp.worldWidth - worldX);
		}
		int bottomOffset = gp.screenHeight - gp.player.screenY;
		if (bottomOffset > gp.worldHeight - gp.player.worldY) {
			screenY = gp.screenHeight - (gp.worldHeight - worldY);
		}
		
		if ((worldX + gp.tileSize > gp.player.worldX - gp.player.screenX) && (worldX - gp.tileSize < gp.player.worldX + gp.player.screenX)
				&& (worldY + gp.tileSize > gp.player.worldY - gp.player.screenY) && (worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)) {
			
			g2d.drawImage(image, screenX, screenY, gp.tileSize * 3, gp.tileSize * 3, null);
			
		} else if ((gp.player.screenX > gp.player.worldX) || (gp.player.screenY > gp.player.worldY) ||
				(rightOffset > gp.worldWidth - gp.player.worldX) || (bottomOffset > gp.worldHeight - gp.player.worldY)) {
			
			g2d.drawImage(image, screenX, screenY, gp.tileSize * 3, gp.tileSize * 3, null);
			
		}
		
	}
}
