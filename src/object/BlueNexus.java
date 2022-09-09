package object;

import java.io.*;

import javax.imageio.*;

import main.*;

public class BlueNexus extends GameObject {
	GamePanel gp;
	
	public BlueNexus(GamePanel gp) {
		
		this.gp = gp;
		
		name = "blue_nexus";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/blue_nexus.png"));
			utility.scaleImage(image, gp.tileSize * 3, gp.tileSize * 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
