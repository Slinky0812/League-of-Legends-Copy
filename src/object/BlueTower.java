package object;

import java.io.*;
import javax.imageio.*;
import main.*;

public class BlueTower extends GameObject {
	
	GamePanel gp;
	
	public BlueTower(GamePanel gp) {
		
		this.gp = gp;
		
		name = "blue_tower";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/blue_tower.png"));
			utility.scaleImage(image, gp.tileSize * 3, gp.tileSize * 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}

