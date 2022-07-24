import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Counter here.
 * 
 * @author M. Amorim 
 * @version v1.0 9/3/2020
 * 
 */
public class Counter extends Actor
{
    private int score=0;
    /**
     * This method creates a scoreboard
     */ 
    public Counter(){
        GreenfootImage img = new GreenfootImage(100,30);
        img.drawString("Score:" + score,5,25);
        setImage(img);
        
    }
    /**
     * This method adds points to the score if score is less then 5
     * and calls the finishlineAdd method to add a finishline when score is greater then 5 
     */ 
    public void addToScore(){
        score++;
        GreenfootImage img = getImage();
        img.clear();
        img.drawString("Score:" + score,5,25);
        if (score>5){
        finishlineAdd();
        }
    }
    /**
     * This method adds the finishline
     */ 
    public void finishlineAdd(){
        ((MyWorld)getWorld()).finishlineAdder();
    }
    
        /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       // Add your action code here.
    }    
}
