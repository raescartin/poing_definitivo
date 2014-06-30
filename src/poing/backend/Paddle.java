package poing.backend;

import java.awt.geom.Rectangle2D;

import poing.Constants;

public class Paddle extends Rectangle2D.Double {
	public int dy;
	public Paddle(int x)
    {
        this.x=x;
        this.y=Constants.height/2;
        this.width=Constants.paddle_width;
        this.height=Constants.paddle_height;
    }
	public void update() {
		this.y+=this.dy*2;
		if(this.y<0){
			this.y=0;
	    }
	    if(this.y+Constants.paddle_height>Constants.height){
	    	this.y=Constants.height-Constants.paddle_height;
	    }
	}
}
