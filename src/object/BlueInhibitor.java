package object;

import java.io.*;
import javax.imageio.*;
import main.*;

public class BlueInhibitor extends GameObject{
	
	GamePanel gp;
	
	public BlueInhibitor(GamePanel gp) {
		
		this.gp = gp;
		
		name = "blue_inhibitor";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/blue_inhibitor.png"));
			utility.scaleImage(image, gp.tileSize * 3, gp.tileSize * 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
