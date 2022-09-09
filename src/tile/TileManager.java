package tile;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import main.*;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[50];
		mapTileNum = new int [gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/worldmap.txt");
	}
	
	public void loadMap(String filePath) {
		
		try {
			
//			System.out.println("loading map..");
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				//read each line of the map text file
				String line = br.readLine();
				while (col < gp.maxWorldCol) {
					//finds the numbers between the spaces
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if (col == gp.maxWorldCol) {
					col = 0;
					row += 1;
				}
			}
			br.close();
			
//			System.out.println("Map loaded!");
			
		} catch (Exception e) {
		
		}
	}
	
	public void getTileImage() {
		
		
		//don't use tiles 0-9 to avoid null pointer exception error
		setUp(0, "grass_new", false);
		setUp(1, "grass_new", false);
		setUp(2, "grass_new", false);
		setUp(3, "grass_new", false);
		setUp(4, "grass_new", false);
		setUp(5, "grass_new", false);
		setUp(6, "grass_new", false);
		setUp(7, "grass_new", false);
		setUp(8, "grass_new", false);
		setUp(9, "grass_new", false);
		
		
		
		//grass tile
		setUp(10, "grass_new", false);
		
		//stone tile
		setUp(11, "stone", true);
		
		//water tile
		setUp(12, "water_new", false);			
		
		//tree tile
		setUp(13, "tree_new", true);
		
		//sand tile
		setUp(14, "sand_new", false);
		
		//mud tile
		setUp(15, "mud", false);
		
		//stone-ground tile
		setUp(16, "stone-ground", false);
		
		//stone-grass tile
		setUp(17, "stone-grass", false);
		
		
		//water boundary tiles
		setUp(18, "water_bounds_1", false);
		setUp(19, "water_bounds_2", false);
		setUp(20, "water_corner_1", false);
		setUp(21, "water_corner_2", false);
		setUp(22, "sand_water", false);
		setUp(23, "sand_grass_water", false);
		setUp(24, "sand_grass_water_2", false);
		setUp(25, "sand_water_corner", false);
		setUp(26, "sand_water_corner_2", false);
		setUp(27, "sand_grass_water_3", false);
		setUp(28, "sand_grass_water_4", false);
		setUp(29, "sand_water_2", false);
		setUp(30, "sand_water_corner_3", false);
		setUp(31, "sand_water_corner_4", false);
		
		setUp(32, "sand_corner_1", false);
		
		setUp(33, "sand_corner_2", false);
		
		setUp(34, "sand_row_1", false);
		
		setUp(35, "sand_col_1", false);
		
		setUp(36, "sand_row_2", false);
		
		setUp(37, "sand_col_2", false);
		
	}
	
	public void setUp(int index, String name, boolean collision) {
		
		Utility utility = new Utility();
		
		try {
			tile[index] = new Tile();
			tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + name + ".png"));
			tile[index].image = utility.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
			tile[index].collision = collision;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2d) {
		
		int worldCol = 0;
		int worldRow = 0;
		
		while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			//check the tile coordinates of world map
			int worldX = worldCol * gp.tileSize;
			int worldY = worldRow * gp.tileSize;
			
			//finding where the tile is drawn on the screen
			int screenX = worldX - gp.player.worldX + gp.player.screenX;
			int screenY = worldY - gp.player.worldY + gp.player.screenY;
			
			
			//stop moving camera at the edge of the map;
			if (gp.player.screenX > gp.player.worldX) {
				screenX = worldX;
			}
			if (gp.player.screenY > gp.player.worldY) {
				screenY = worldY;
			}
			int rightOffset = gp.screenWidth - gp.player.screenX;
			if (rightOffset > gp.worldWidth - gp.player.worldX) {
				screenX = gp.screenWidth - (gp.worldWidth - worldX);
			}
			int bottomOffset = gp.screenHeight - gp.player.screenY;
			if (bottomOffset > gp.worldHeight - gp.player.worldY) {
				screenY = gp.screenHeight - (gp.worldHeight - worldY);
			}
			
			//checking if the tiles are in the screen, and if it is, then it is being drawn
			if ((worldX + gp.tileSize > gp.player.worldX - gp.player.screenX) && (worldX - gp.tileSize < gp.player.worldX + gp.player.screenX) && 
					(worldY + gp.tileSize > gp.player.worldY - gp.player.screenY) && (worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)) {
				
				g2d.drawImage(tile[tileNum].image, screenX, screenY, null);
				
			} else if ((gp.player.screenX > gp.player.worldX) || (gp.player.screenY > gp.player.worldY) ||
					(rightOffset > gp.worldWidth - gp.player.worldX) || (bottomOffset > gp.worldHeight - gp.player.worldY)) {
				
				g2d.drawImage(tile[tileNum].image, screenX, screenY, null);
				
			}
			
			worldCol += 1;
			
			if (worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow += 1;
			}
		}
		
	}
	
}
