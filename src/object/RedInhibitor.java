package object;

import java.io.*;
import javax.imageio.*;
import main.*;

public class RedInhibitor extends GameObject{
	
	GamePanel gp;
	
	public RedInhibitor(GamePanel gp) {
		
		this.gp = gp;
		
		name = "red_inhibitor";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/red_inhibitor.png"));
			utility.scaleImage(image, gp.tileSize * 3, gp.tileSize * 3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
