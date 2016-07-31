package pendulum;

import javafx.scene.layout.Pane;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PendulumPane extends Pane{
    
    
    
    /** Header circle */
    private double radiusOne=10,circleOneCenterX=250,circleOneCenterY=20;
    private Circle circleOne=new Circle (circleOneCenterX,circleOneCenterY,radiusOne);
    
    /** Create circle two and set its properties*/
    private double circleTwoCenterX=circleOneCenterX;
    private double circleTwoCenterY=250;
    private double radiusTwo=30;
    private Circle circleTwo=new Circle (circleTwoCenterX,circleTwoCenterY,radiusTwo);
    
    /**line which represent pendulum radius and set its properties */
    Line line=new Line (circleOneCenterX,circleOneCenterY,circleTwoCenterX,circleTwoCenterY);
    
    /** Pendulum radius*/
    private double pendulumRadius=circleOneCenterY+circleTwoCenterY;
    
    /** Pendulum angle*/
    public double angle=(Math.PI/2);
    
    /** Angle distance*/
    public double dAngle=0.1;

    /** Animation*/
    private Timeline animation;
    //default constructor
   public PendulumPane ()
   {
       circleOne.setFill(Color.RED);
       line.setStroke (Color.RED);
       circleTwo.setFill(Color.RED);
       getChildren().addAll(circleOne,line,circleTwo);
       
       //Set style 
       setStyle("-fx-background-color:black;");
       //Create animation
       animation =new Timeline(new KeyFrame (Duration.millis(100),e->movePendulum()));
       animation.setCycleCount(Timeline.INDEFINITE);
       animation.play();
       
   }
   
   public void play()
   {
       animation.play();
   }
   
   public void pause()
   {
       animation.pause();
   }
   public void increaseSpeed()
   {
       animation.setRate (animation.getRate()+0.1);
   }
   public void decreaseSpeed()
   {
       animation.setRate(animation.getRate ()>0 ? animation.getRate()-0.1:animation.getRate());
   }
   
   public void movePendulum()
   {
       if (angle<=Math.PI/4 || angle>=(3*Math.PI)/4)
           dAngle*=-1;
       
       angle-=dAngle;
       
       circleTwoCenterX=circleOneCenterX+pendulumRadius*Math.cos(angle);
       circleTwoCenterY=circleOneCenterY+pendulumRadius*Math.sin(angle);
       
       circleTwo.setCenterX(circleTwoCenterX);
       circleTwo.setCenterY(circleTwoCenterY);
       line.setEndX(circleTwoCenterX);
       line.setEndY(circleTwoCenterY);
   }
}