package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import sprites.BasicShip;

public class Surface extends JPanel implements Runnable {

	private Graphics2D ctx;
	private Thread t;
	
	private final int DELAY = 25;
	
	private BasicShip player;
	
	public Surface() {
		super();
		player = new BasicShip(0f, 0f);
		player.speed.setXY(-5f, -4f);
		setBackground(Color.black);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    this.ctx = (Graphics2D) g;
	    
	    this.draw();
	}
	
	@Override
    public void addNotify() {
        super.addNotify();

        this.t = new Thread(this);
        this.t.start();
    }
	
	@Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            this.update();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e.getMessage());
            }

            beforeTime = System.currentTimeMillis();
        }
    }
	
	private void draw() {
		//visual updates here
		
		player.draw(this.ctx);
	}
	
	private void update() {
		//physics updates here
		
		player.update();
	}
	
}
