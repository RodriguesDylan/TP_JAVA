package hellofx;

import javafx.concurrent.Task;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;


public class Boucle extends Task<Void> {
	
	private GraphicsContext gc;
	private DrawOneThing canvasTask;
	private StackPane container;
	
	public Boucle (DrawOneThing canvas, StackPane container) {
        this.gc = canvas.getGraphicsContext2D();
        this.canvasTask = canvas;
        this.container=container;
	}
	
	@Override
	protected Void call() throws Exception{
		int i;
		for (i=0;i<10000;i++) {
			canvasTask.drawOneRandom(gc);
			this.updateProgress(i, 10000);
		}	
		return null;	
	}
}

