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
		
		setDefaultValues();
		getPlayerImage();
		
		direction = "down";
		
	}
	
	public void setDefaultValues() {
		worldX = gp.tileSize * 1;
		worldY = gp.tileSize * 1;
		speed = 5;
	}
	
	public void getPlayerImage() {
		try {
			
			//images for player moving up
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));

			//images for player moving down
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			
			//images for player moving left
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			
			//images for player moving right
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void update() {
		//move the player

		if (keyHandler.up == true || keyHandler.down == true || keyHandler.left == true || keyHandler.right == true) {

			if (keyHandler.up == true) {
				direction = "up";
				worldY -= speed;
			} else if (keyHandler.down == true) {
				direction = "down";
				worldY += speed;
			} else if (keyHandler.left == true) {
				direction = "left";
				worldX -= speed;
			} else if (keyHandler.right == true) {
				direction = "right";
				worldX += speed;
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
		
		g2d.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}

}
