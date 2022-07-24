import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * enemy Fish will move randomly and will move 3 units ate the time.
 * 
 * @author M. Amorim 
 * @version v1.0 9/3/2020
 * 
 */
public class enemyFish extends enemy
{
    private final int DIST_TO_MOVE2 = 3;
    /**
     * Act - do whatever the enemyFish wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        randomTurns(); //turns on edge and randomly
        this.move(DIST_TO_MOVE2);
        eatMeal(); //removes object medal and character
    }    
}
