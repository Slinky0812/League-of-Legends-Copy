package entity;

import java.awt.image.*;
import java.awt.*;

public class Entity {
	
	public int worldX, worldY;
	public int speed;
	
	public int health;
	
	public int mana;
	
	//describes an image with an accessible buffer of image data
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;

	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;
}
