package poing.backend;

import java.awt.geom.Ellipse2D;
import java.net.URL;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import poing.Constants;
import poing.Constants.Globals;

public class Ball extends Ellipse2D.Double {
	public int dx;
	public int dy;
	public int scoreP1;
	public int scoreP2;
	final URL url_p = this.getClass().getResource("/sounds/pep_point.wav");
	final URL url_w = this.getClass().getResource("/sounds/plop_wall.wav");
	public Ball() {
		this.x=Constants.width/2;
		this.y=Constants.height/2;
		this.height=Constants.ball_size;
		this.width=Constants.ball_size;
		this.dx=2;
		this.dy=1;
		scoreP1=0;
		scoreP2=0;
	}
	void update(){
		this.x+=this.dx;
		this.y+=this.dy;
		if (this.x<0) {
			this.x = 0;
			this.dx = -this.dx;
			scoreP2++;
			Globals.update_ball=Constants.update_ball;
			try {
				Clip clip = AudioSystem.getClip();
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(url_p));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (this.x + Constants.ball_size+1 > Constants.width) {
			x = Constants.width-Constants.ball_size;
		    this.dx = -this.dx;
		    scoreP1++;
		    Globals.update_ball=Constants.update_ball;
		    try {
				Clip clip = AudioSystem.getClip();
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(url_p));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (this.y<0) {
		    this.y = 0;
		    this.dy = -this.dy;
		    try {
				Clip clip = AudioSystem.getClip();
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(url_w));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (this.y + Constants.ball_size+1>Constants.height) {
		    this.y =Constants.height-Constants.ball_size;
		    this.dy = -this.dy;
		    try {
				Clip clip = AudioSystem.getClip();
				clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(url_w));
				clip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
