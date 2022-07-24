import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * enemy shark will move randomly and will be the slowest enemy, moving 2 units ate the time
 * 
 * 
 * @author M. Amorim 
 * @version v1.0 9/3/2020
 * 
 */
public class enemyShark extends enemy
{
    private final int DIST_TO_MOVE1 = 2; 
    /**
     * Act - do whatever the enemyShark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        randomTurns(); //turns on edge and randomly
        this.move(DIST_TO_MOVE1);
        eatMeal(); //removes object medal and character
    }    
}

