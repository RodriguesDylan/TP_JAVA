package hellofx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;

 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void dessiner(GraphicsContext gc) {
    	double y1 = 500*Math.random();
    	for(int x=0;x<800;x+=2) {
    		double y2 = 500*Math.random();
        	gc.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
    		gc.strokeLine(x,y1, x+2, y2);
    		y1=y2;
    	}
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Oscillateur Fixe");
        
        BorderPane root = new BorderPane();
        Scene s = new Scene(root, 800, 500, Color.WHITE);
        
        Button btn = new Button("Rafraichir");
        root.setRight(btn);
        btn.setMaxHeight(500);

        final Canvas canvas = new Canvas(730,500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        dessiner(gc);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		gc.clearRect(0, 0, 800, 500);
        		dessiner(gc);
        	}     
        });
         
        root.getChildren().add(canvas);
        
        primaryStage.setScene(s);
        primaryStage.show();
    }
}