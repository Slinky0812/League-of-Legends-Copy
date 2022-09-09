package object;

import java.io.*;
import javax.imageio.*;
import main.*;

public class RedTower extends GameObject{

	GamePanel gp;
	
	public RedTower(GamePanel gp) {
		
		this.gp = gp;
		
		name = "red_tower";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/red_tower.png"));
			utility.scaleImage(image, gp.tileSize * 3, gp.tileSize * 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
