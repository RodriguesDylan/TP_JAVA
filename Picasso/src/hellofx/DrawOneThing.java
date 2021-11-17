package hellofx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawOneThing extends Canvas {
	
	public DrawOneThing(int x, int y) {
		super(x,y);
	}
	
	public void drawOneRandom(GraphicsContext gc) {
		double X = 800*Math.random();
		double Y = 500*Math.random();
		double radius=150*Math.random();
		
		gc.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
		
		gc.fillOval(X, Y, radius * 2, radius * 2);
	}
}
