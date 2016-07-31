/**
 * A JavaFX application that animates a pendulum swinging. 
 * The user pause and start the animation by clicking a mouse button
 * The user increase the animation speed with UP-arrow key, and decrease the animation speed with the DOWN-arrow key.
 */
package pendulum;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Ballaj
 */
public class Pendulum extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    
    //Create a PendulumPane object 
      PendulumPane pp=new PendulumPane ();
      
      //Register the event handlers 
      //The user pause and start the animation by clicking a mouse button
      pp.setOnMousePressed(e->pp.pause());
      pp.setOnMouseReleased(e->pp.play());
     
      //Increase the animation speed with UP-arrow key, and decrease the animation speed with the DOWN-arrow key.
      pp.setOnKeyPressed(e->{
      
          if(e.getCode()==KeyCode.UP)
             pp.increaseSpeed();
          else if (e.getCode()==KeyCode.DOWN)
              pp.decreaseSpeed();
      });
      
      //Create a scene and place it in the stage 
      Scene scene=new Scene (pp,500,500);
      primaryStage.setTitle ("Pendulum");
      primaryStage.setScene(scene);
      primaryStage.show();   
    
    }
    
      public static void main(String[] args) {
        launch(args);
    }
    
}
