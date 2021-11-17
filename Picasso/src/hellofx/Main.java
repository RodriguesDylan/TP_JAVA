package hellofx;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Picasso");
        
        BorderPane root = new BorderPane(); //generation de borderpane + menubar
        MenuBar menuBar = new MenuBar();
        ProgressIndicator pi = new ProgressIndicator(0);
        final DrawOneThing canvas = new DrawOneThing(800,500);	//creation canvas + graphicscontext
        StackPane stack = new StackPane();  
        
        root.setTop(menuBar);	//mise en haut de la menubar
        
        Menu menu = new Menu("Affichage");	//contenu du menu
        menuBar.getMenus().add(menu);	//ajout du menu à la menubar
        
        MenuItem item1 = new MenuItem("_Nouveau");	//ajout des sous-menus
        MenuItem item2 = new MenuItem("_Quitter");
        menu.getItems().add(item1);
        menu.getItems().add(item2);

        Scene s = new Scene(root, 800, 500, Color.WHITE);	//création scene 
        
        root.setCenter(canvas);
        //stack.getChildren().add(canvas);
              
        item1.setOnAction(new EventHandler<ActionEvent>() {	//action click sur "Nouveau"
        	@Override 
        	public void handle(ActionEvent e) {
        		Task<Void> task = new Boucle(canvas,stack);
        		pi.progressProperty().unbind();
        		pi.progressProperty().bind(task.progressProperty());
        		
        		stack.getChildren().clear();
        		stack.getChildren().add(pi);
        		new Thread(task).start();
        	}	 		   		
        });
        item2.setOnAction(new EventHandler<ActionEvent>() { //action click sur "Quitter"
        	@Override 
        	public void handle(ActionEvent e) {
        		primaryStage.close();  }		   		
        });
         
        primaryStage.setScene(s); //ajout + affichage scene
        primaryStage.show();
    }
}

