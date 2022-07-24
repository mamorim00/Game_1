import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
  * 
 * @author M. Amorim 
 * @version v1.0 9/3/2020
 * 
 */
public class Character extends Actor
{
     
    private final int DIST_TO_MOVE = 10;
    private final int DEG_TO_TURN = 90;
    
    
     /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();
        eatMeal();
    }
    /**
     * This method checks if the keys are pressed in order to move the character
     */      
        public void checkKey(){
        {   // Move forward
        if (Greenfoot.isKeyDown("right")) {
            this.move(DIST_TO_MOVE);
        }
        
        // Move backward
        if (Greenfoot.isKeyDown("left")) {
            this.move(-DIST_TO_MOVE);
        }
        
        // Move up
        if (Greenfoot.isKeyDown("up")) {
            this.turn (DEG_TO_TURN);
            this.move(-DIST_TO_MOVE);
            this.turn (-DEG_TO_TURN);
        }
        
        // Move down
        if (Greenfoot.isKeyDown("down")) {
            this.turn (DEG_TO_TURN);
            this.move(DIST_TO_MOVE);
            this.turn (-DEG_TO_TURN);
        }
        }   
    }
    /**
     * This method creates an instance of the Medal and Finishline Classes 
     */  
    public void eatMeal(){
         if (this.getOneIntersectingObject(Medal.class) != null) {
            // 1. get a reference to the Medal object
            Medal myMeal = (Medal)this.getOneIntersectingObject(Medal.class);
            // 2. eat myMeal
            eat(myMeal);
            // 3. add points to the score
            ((MyWorld)getWorld()).updateScore();
            //add another medal
            medalAdd();
           
           
        } 
        if (this.getOneIntersectingObject(Finishline.class) != null) {
            // 1. get a reference to the Finishline object
            Finishline myMeal = (Finishline)this.getOneIntersectingObject(Finishline.class);
            // 2. eat myMeal
            eat(myMeal);
            // 3. Go to Win state
            winState();
        }
    }
     /**
     * This method removes the object Medal from the world
     */    
    private void eat(Medal meal) {
        World myWrld = (MyWorld)this.getWorld();
        myWrld.removeObject(meal);
        
    }
    /**
     * This method removes the object Finishline from the world
     */  
    private void eat(Finishline meal) {
        World myWrld = (MyWorld)this.getWorld();
        myWrld.removeObject(meal);
        
    }
    /**
     * This method add the object Medal in a new place whenever a medal is removed
     * by calling  method from MyWorld
     */  
    private void medalAdd(){
        // 4. add another medal
        ((MyWorld)getWorld()).medalAdder();
    }
    /**
     * This method makes the game go to Win state whenever the character touches the finishline
     */  
    private void winState(){
      ((MyWorld)getWorld()).youWin();  
    }
    
   
    
    
    
    
    
    
    
    
    
   
}
