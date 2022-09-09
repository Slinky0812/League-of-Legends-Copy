package main;

import object.*;

public class Handler {
	GamePanel gp;
	
	public Handler(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		//BLUE TOWERS
		//top lane
		setUpBlueTower(0, 3, 19);
		setUpBlueTower(1, 7, 49);
		setUpBlueTower(2, 5, 80);
		
		//bot lane
		setUpBlueTower(3, 81, 94);
		setUpBlueTower(4, 49, 91);
		setUpBlueTower(5, 17, 93);
		
		//mid lane
		setUpBlueTower(6, 17, 80);
		setUpBlueTower(7, 42, 52);
		setUpBlueTower(8, 29, 70);
		
		
		//RED TOWERS
		//top lane
		setUpRedTower(9, 19, 3);
		setUpRedTower(10, 49, 6);
		setUpRedTower(11, 80, 5);
		
		//bot lane
		setUpRedTower(12, 95, 81);
		setUpRedTower(13, 90, 49);
		setUpRedTower(14, 93, 17);
		
		//mid lane
		setUpRedTower(15, 80, 17);
		setUpRedTower(16, 57, 42);
		setUpRedTower(17, 70, 25);
		
		
		//BLUE INHIBITORS
		//top
		setUpBlueInhib(18, 5, 85);
		//bot
		setUpBlueInhib(19, 12, 93);
		//mid
		setUpBlueInhib(20, 14, 83);
		
		//RED INHIBITORS
		setUpRedInhib(21, 85, 5);
		setUpRedInhib(22, 93, 12);
		setUpRedInhib(23, 83, 14); 
		
		//BLUE towers around nexus
		setUpBlueTower(24, 7, 88);
		setUpBlueTower(25, 9, 90);
		
		//BLUE NEXUS
		setUpBlueNexus(26, 6, 91);
		
		//RED towers around nexus
		setUpRedTower(27, 88, 7);
		setUpRedTower(28, 90, 9);
		
		//RED NEXUS
		setUpRedNexus(29, 91, 6);
	}
	
	public void setUpBlueTower(int index, int x, int y) {
		gp.object[index] = new BlueTower(gp);
		gp.object[index].worldX = x * gp.tileSize;
		gp.object[index].worldY = y * gp.tileSize;
	}
	
	public void setUpRedTower(int index, int x, int y) {
		gp.object[index] = new RedTower(gp);
		gp.object[index].worldX = x * gp.tileSize;
		gp.object[index].worldY = y * gp.tileSize;
	}
	
	public void setUpBlueInhib(int index, int x, int y) {
		gp.object[index] = new BlueInhibitor(gp);
		gp.object[index].worldX = x * gp.tileSize;
		gp.object[index].worldY = y * gp.tileSize;
	}
	
	public void setUpRedInhib(int index, int x, int y) {
		gp.object[index] = new RedInhibitor(gp);
		gp.object[index].worldX = x * gp.tileSize;
		gp.object[index].worldY = y * gp.tileSize;
	}
	
	public void setUpBlueNexus(int index, int x, int y) {
		gp.object[index] = new BlueNexus(gp);
		gp.object[index].worldX = x * gp.tileSize;
		gp.object[index].worldY = y * gp.tileSize;
	}
	
	public void setUpRedNexus(int index, int x, int y) {
		gp.object[index] = new RedNexus(gp);
		gp.object[index].worldX = x * gp.tileSize;
		gp.object[index].worldY = y * gp.tileSize;
	}
}
