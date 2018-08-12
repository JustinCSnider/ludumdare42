package colorRunner;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public abstract class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 200;
	public static final int HEIGHT = WIDTH/16*9;
	public static final int SCALE = 5;
	public static final String NAME = "Game";
	
	private JFrame frame;
	
	public boolean isRunning = false;
	public int tickCount = 0;
	
	public Game(){
		setMinimumSize(new Dimension(WIDTH * SCALE , HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE , HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE , HEIGHT * SCALE));
		
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public synchronized void start(){
		isRunning = true;
		new Thread(this).start();
	}
	
	private synchronized void stop(){
		isRunning = false;
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int frames =0;
		int ticks =0;
		
		long lastTimer= System.currentTimeMillis();
		double delta= 0;
		while(isRunning){
			long now = System.nanoTime();
			delta +=(now - lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			
			while(delta >= 1){
				ticks++;
				tick();
				delta -=1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender){
				frames++;
				render();
			}
			
			if (System.currentTimeMillis() - lastTimer > 1000){
				lastTimer += 1000;
				System.out.println(ticks + "ticks, " + frames + "frames");
				getBufferStrategy().getDrawGraphics().clearRect(0, 0, getWidth(), getHeight());
				this.postTick(getBufferStrategy().getDrawGraphics());
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public abstract void postTick(Graphics g);
	public abstract void init();
	
	public void tick(){
		tickCount++;
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.dispose();
		bs.show();
	}
}