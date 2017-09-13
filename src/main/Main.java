package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import util.Camera;

public class Main extends JFrame {
	
	public Main() {
		initUI();

	}

	private void initUI() {

		Surface surface = new Surface();
		add(new Surface());

		setTitle("Space");
		setSize(Camera.CAM_WIDTH, Camera.CAM_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Main ex = new Main();
				ex.setVisible(true);
			}
		});
	}
}
