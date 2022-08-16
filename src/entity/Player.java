package entity;

import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

import main.*;

public class Player extends Entity {
	
	GamePanel gp;
	KeyInput keyHandler;
	//where we draw player on the screen (centre)
	public final int screenX;
	public final int screenY;
	
	public Player (GamePanel gp, KeyInput keyHandler) {
		
		this.gp = gp;
		this.keyHandler = keyHandler;

		//spawns player in the middle of the screen
		screenX = (gp.screenWidth / 2) - (gp.tileSize / 2); 
		screenY = (gp.screenHeight / 2) - (gp.tileSize / 2);
		
		//area for collision detection < player area
		solidArea = new Rectangle(8, 16, 32, 32);
		
		setDefaultValues();
		getPlayerImage();
		
		direction = "down";
		
	}
	
	public void setDefaultValues() {
		worldX = gp.tileSize * 50;
		worldY = gp.tileSize * 50;
		speed = 5;
	}
	
	public void getPlayerImage() {
		
		//player up images
		up1 = setUp("up1");
		up2 = setUp("up2");
		
		//player down images
		down1 = setUp("down1");
		down2 = setUp("down2");
		
		//player left images
		left1 = setUp("left1");
		left2 = setUp("left2");
		
		//player right images
		right1 = setUp("right1");
		right2 = setUp("right2");
		
	}
	
	public BufferedImage setUp(String name) {
		Utility utility = new Utility();
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/" + name + ".png"));
			image = utility.scaleImage(image, gp.tileSize, gp.tileSize); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	
	public void update() {
		//move the player

		if (keyHandler.up == true || keyHandler.down == true || keyHandler.left == true || keyHandler.right == true) {

			//checking direction of player
			if (keyHandler.up == true) {
				direction = "up";	
			} else if (keyHandler.down == true) {
				direction = "down";
			} else if (keyHandler.left == true) {
				direction = "left";
			} else if (keyHandler.right == true) {
				direction = "right";
			}
			
			//check collision
			collisionOn = false;
			gp.cCheck.checkTile(this);
			
			//if collision is false, player can move
			if (collisionOn == false) {

				switch (direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX  += speed;
					break;
				}
			}
	
			spriteCounter += 1;
			if (spriteCounter > 15) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			
		}
	}
	
	public void draw(Graphics2D g2d) {
		
		BufferedImage image = null;
		
		//using a switch-case loop to change image when direction changes
		switch(direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			} else if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			} else if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			} else if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			} else if (spriteNum == 2) {
				image = right2;
			}
			break;
		}
		
		
		int x = screenX;
		int y = screenY;
		
		if (screenX > worldX) {
			x = worldX;
		}
		if (screenY > worldY) {
			y = worldY;
		}
		
		int rightOffset = gp.screenWidth - screenX;
		if (rightOffset > gp.worldWidth - worldX) {
			x = gp.screenWidth - (gp.worldWidth - worldX);
		}
		
		int bottomOffset = gp.screenHeight - screenY;
		if (bottomOffset > gp.worldHeight - worldY) {
			y = gp.screenHeight - (gp.worldHeight - worldY);
		}		
		
		g2d.drawImage(image, x, y, null);
		
	}

}
