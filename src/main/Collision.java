package main;

import entity.*;

public class Collision {
	
	GamePanel gp;
	
	public Collision (GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = (entityLeftWorldX) / gp.tileSize;
		int entityRightCol = (entityRightWorldX) / gp.tileSize;
		int entityTopRow = (entityTopWorldY) / gp.tileSize;
		int entityBottomRow = (entityBottomWorldY) / gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			//predicting where player will be after he moves
			entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
			
			if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			
			break;
		case "down":
			//predicting where player will be after he moves
			entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			
			if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			
			break;
		case "left":
			//predicting where player will be after he moves
			entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			
			if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			
			break;
		case "right":
			//predicting where player will be after he moves
			entityTopRow = (entityRightWorldX + entity.speed) / gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			
			if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
			}
			
			break;
		}
	}
	
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for (int i = 0; i < gp.object.length; i++) {
			
			if (gp.object[i] != null) {
				//get entity's solid area position
				entity.solidArea.x = entity.solidArea.x + entity.worldX;
				entity.solidArea.y = entity.solidArea.y + entity.worldY;
				
				//get object's solid area position
				gp.object[i].solidArea.x = gp.object[i].solidArea.x + gp.object[i].worldX;
				gp.object[i].solidArea.y = gp.object[i].solidArea.y + gp.object[i].worldY;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if (entity.solidArea.intersects(gp.object[i].solidArea)) {
						if (gp.object[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if (entity.solidArea.intersects(gp.object[i].solidArea)) {
						if (gp.object[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if (entity.solidArea.intersects(gp.object[i].solidArea)) {
						if (gp.object[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if (entity.solidArea.intersects(gp.object[i].solidArea)) {
						if (gp.object[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player == true) {
							index = i;
						}
					}
					break;
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				
				gp.object[i].solidArea.x = gp.object[i].solidAreaDefaultX;
				gp.object[i].solidArea.y = gp.object[i].solidAreaDefaultY;
			}
		}
		
		return index;
		
	}
}




















