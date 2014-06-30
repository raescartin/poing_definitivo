package poing.backend;


import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import poing.Constants;
import poing.Constants.Globals;

public class Game {
    public Game(final Ball ball, final Paddle paddle1, final Paddle paddle2) {
    	final URL url = this.getClass().getResource("/sounds/bep_paddle.wav");
    	
		
			
		
    	Thread ball_thread = new Thread( new Runnable(){
            public void run(){
            	while(!Globals.end){
            		ball.update();
            		try {
        				Thread.sleep(Globals.update_ball);
        			} catch (InterruptedException e) {
        				e.printStackTrace();
        			}
    			}	
            }
    	});
    	ball_thread.start();
    	Thread paddles_thread = new Thread( new Runnable(){
            public void run(){
            	while(!Globals.end){
            		paddle1.update();
            		paddle2.update();
            		
            		if(ball.x<=Constants.paddle_to_border+Constants.paddle_width){
            			if(ball.getBounds().intersects(paddle1)){
            				if(ball.dx<0){
            					if(Globals.update_ball>Constants.update_paddles){Globals.update_ball--;}
            							ball.dx=-ball.dx;
            							if(ball.y>paddle1.y+Constants.paddle_height/3){
            								ball.dy=1;
            							}
            							if(ball.y<paddle1.y-Constants.paddle_height/3){
            								ball.dy=-1;
            							}
            							try {
            								Clip clip = AudioSystem.getClip();
            								clip.open(AudioSystem.getAudioInputStream(url));
            								clip.start();
            							} catch (Exception e) {
            								e.printStackTrace();
            							}
            				}
            			}
            		}
            		if(ball.x>=Constants.width-Constants.paddle_to_border){
            			if(ball.getBounds().intersects(paddle2)){
            				if(ball.dx>0){
            					if(Globals.update_ball>Constants.update_paddles){Globals.update_ball--;}
            					
	            					ball.dx=-ball.dx;
	            					if(ball.y>paddle2.y+Constants.paddle_height/3){
	    								ball.dy=1;
	    							}
	    							if(ball.y<paddle2.y-Constants.paddle_height/3){
	    								ball.dy=-1;
	    							}
	            					try {
	            						Clip clip = AudioSystem.getClip();
	    								clip = AudioSystem.getClip();
	    								clip.open(AudioSystem.getAudioInputStream(url));
	    								clip.start();
	    							} catch (Exception e) {
	    								e.printStackTrace();
	    							}
            					}
            			}
            		}
            		try {
        				Thread.sleep(Constants.update_paddles);
        			} catch (InterruptedException e) {
        				e.printStackTrace();
        			}
    			}	
            }
    	});
    	paddles_thread.start();
	
    
    }
}
