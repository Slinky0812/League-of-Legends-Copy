package main;

import java.awt.event.*;

public class KeyInput implements KeyListener {

	public boolean up, down, left, right;
	
	public GamePanel gp;

	public KeyInput (GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	        
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//returns the integer key code of the key pressed
		int code = e.getKeyCode();
		
		if (gp.gameState == gp.title) {
			
			if (gp.hud.titleScreen == 0) {
				if (code == KeyEvent.VK_W) {
					gp.hud.commandNum--;
					if (gp.hud.commandNum < 0) {
						gp.hud.commandNum = 1;
					}
				} else if (code == KeyEvent.VK_S) {
					gp.hud.commandNum++;
					if (gp.hud.commandNum > 1) {
						gp.hud.commandNum = 0;
					}
				} else if (code == KeyEvent.VK_ENTER) {
					if (gp.hud.commandNum == 0) {
						gp.hud.titleScreen = 1;
					} else if (gp.hud.commandNum == 1) {
						System.exit(1);
					}
				}
			} else if (gp.hud.titleScreen == 1) {
				if (code == KeyEvent.VK_W) {
					gp.hud.commandNum--;
					if (gp.hud.commandNum < 0) {
						gp.hud.commandNum = 3;
					}
				} else if (code == KeyEvent.VK_S) {
					gp.hud.commandNum++;
					if (gp.hud.commandNum > 3) {
						gp.hud.commandNum = 0;
					}
				} else if (code == KeyEvent.VK_ENTER) {
					if (gp.hud.commandNum == 0) {
						//draw miss fortune on screen
						gp.gameState = gp.play;
					} else if (gp.hud.commandNum == 1) {
						//draw master yi on screen
						gp.gameState = gp.play;
					} else if (gp.hud.commandNum == 2) {
						//draw illaoi on screen
						gp.gameState = gp.play;
					} else if (gp.hud.commandNum == 3) {
						gp.hud.titleScreen = 0;
					}
				}
			}
			
			
		} else if (gp.gameState == gp.play) {
		
			if (code == KeyEvent.VK_W) {
		        up = true;
		    } else if (code == KeyEvent.VK_S) {
		        down = true;
		    } else if (code == KeyEvent.VK_A) {
		        left = true;
		    } else if (code == KeyEvent.VK_D) {
		        right = true;
		    }
		    
		    //pause the game
		    if (code == KeyEvent.VK_ESCAPE) {
		    	if (gp.gameState == gp.play) {
		    		gp.gameState = gp.pause;
		    	} else if (gp.gameState == gp.pause) {
		    		gp.gameState = gp.play;
		    	}
		    }
		    
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
    
		//returns the integer key code of the key pressed
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            up = false;
        } else if (code == KeyEvent.VK_S) {
            down = false;
        } else if (code == KeyEvent.VK_A) {
            left = false;
        } else if (code == KeyEvent.VK_D) {
            right = false;
        }
    }
	    
}

