import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class enemy moves and removes Medals and the Character when touching them.
 * 
 * @author M. Amorim 
 * @version v1.0 9/3/2020
 * 
 */
public class enemy extends Actor
{
    private final int TURN_LIMIT = 179;
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }  
    public void randomTurns(){
        if (this.isAtEdge() || (Greenfoot.getRandomNumber(100)<5)) {
            int degToTurn = Greenfoot.getRandomNumber(TURN_LIMIT);
            this.turn(degToTurn);
        }
    }
    public void eatMeal(){
        if (this.getOneIntersectingObject(Character.class) != null) {
            // 1. get a reference to the Character object
            Character myMeal = (Character)this.getOneIntersectingObject(Character.class);
            // 2. eat myMeal
            eat(myMeal);
            // 3. Go to Lose state
            loseState();
            
        } 
        {if (this.getOneIntersectingObject(Medal.class) != null) {
            // 1. get a reference to the Medal object
            Medal myMeal = (Medal)this.getOneIntersectingObject(Medal.class);
            // 2. eat myMeal
            eat(myMeal);
            // 3. Add the replacing medal
            medalAdd();
        } } 
    }
    
    /**
     * This method removes the object Character from the world.
     */
    private void eat(Character meal) {
        World myWrld = (MyWorld)this.getWorld();
        myWrld.removeObject(meal);
    }
    /**
     * This method removes the object Medal from the world.
     */
    private void eat(Medal meal) {
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
     * This method makes the game go to Lose state whenever the character touches the finishline
     */ 
    private void loseState(){
      ((MyWorld)getWorld()).youLose(); 
    }
}
