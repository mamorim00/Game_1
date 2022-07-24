import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * enemy Jelly will be the fatstest enemy, moving 5 units ate the time, but only turn on edges
 * 
 * @author M. Amorim 
 * @version v1.0 9/3/2020
 * 
 */
public class enemyJelly extends enemy
{
    private final int DIST_TO_MOVE3 = 5;
    private final int TURN_LIMIT = 90;
    /**
     * Act - do whatever the enemyJelly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.move (DIST_TO_MOVE3);
        if (this.isAtEdge()){
            int degToTurn = Greenfoot.getRandomNumber(TURN_LIMIT); //turns on edges
            this.turn(degToTurn);
        }
        eatMeal();//removes object medal and character
    }    
}
