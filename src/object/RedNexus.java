package object;

import java.io.*;
import javax.imageio.*;
import main.*;

public class RedNexus extends GameObject {

	GamePanel gp;
	
	public RedNexus(GamePanel gp) {
		
		this.gp = gp;
		
		name = "red_nexus";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/red_nexus.png"));
			utility.scaleImage(image, gp.tileSize * 3, gp.tileSize * 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
