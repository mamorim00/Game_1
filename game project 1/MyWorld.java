   import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
/**
 * Write a description of class MyWorld here.
 * 
 * @author M. Amorim 
 * @version v1.0 9/3/2020
 * 
 */
public class MyWorld extends World
{
    private final String START = "START";
    private final String LEVEL_1 = "LEVEL_1";
    private final String LEVEL_1COMPLETED = "LEVEL_1COMPLETED";
    private final String LEVEL_2 = "LEVEL_2";
    private final String LEVEL_2COMPLETED = "LEVEL_2COMPLETED";
    private final String LEVEL_3 = "LEVEL_3";
    private final String LEVEL_3COMPLETED = "LEVEL_3COMPLETED";
    private final String LEVEL_4 = "LEVEL_4";
    private final String LEVEL_4COMPLETED = "LEVEL_4COMPLETED";
    private final String LOSE = "LOSE";
    private final String WIN = "WIN";
    private String curState;
    private Counter score;
    private final int MLIMITX = 550;
    private final int MLIMITY = 350;
    private final int EnemyX = 250;
    private final int EnemyY = 250;
    private final int CHARACTERX= 1;
    private final int CHARACTERY= 250;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 600x400 pixels.
        super(600, 400, 1);
        // set starting state
        curState = START;
        // set background to level select screen
        this.setBackground("LevelSelect.png");
        
    }
    /**
     * This method swiches the states in the game
     */ 
    public void act() {
        if (curState.equals(START) && Greenfoot.isKeyDown("space"))
        {
            curState = LEVEL_1;
            this.setBackground("ocean1.jpg");
            level1_start();
            //add counter
            Counter();
            
        }
        if (curState.equals(LEVEL_1COMPLETED)){
            // remove all the objects from the world
            this.removeObjects(getObjects(null));
            this.setBackground("Level1C.jpg");
        }
        if (curState.equals(LEVEL_1COMPLETED) &&(Greenfoot.isKeyDown("space") ))
        {
            curState = LEVEL_2;
            this.setBackground("ocean2.jpg");
            level2_start();
            //add counter
            Counter();
        }
        if (curState.equals(LEVEL_2COMPLETED)){
        // remove all the objects from the world
        this.removeObjects(getObjects(null));
        this.setBackground("Level2C.jpg");
        }
        if (curState.equals(LEVEL_2COMPLETED) &&(Greenfoot.isKeyDown("space") ))
        {
            curState = LEVEL_3;
            this.setBackground("ocean3.png");
            level3_start();
            //add counter
            Counter();
        }
        if (curState.equals(LEVEL_3COMPLETED)){
        // remove all the objects from the world
        this.removeObjects(getObjects(null));
        this.setBackground("Level3C.jpg");
        }
        if (curState.equals(LEVEL_3COMPLETED) &&(Greenfoot.isKeyDown("space") ))
        {
            curState = LEVEL_4;
            this.setBackground("ocean4.png");
            level4_start();
            //add counter
            Counter();
        }
        if (curState.equals(LOSE)){
           this.setBackground("background2.jpg");
           // remove all the objects from the world
           this.removeObjects(getObjects(null));
        } 
        if (curState.equals(WIN)){
        this.setBackground("background1.jpg");
        // remove all the objects from the world
        this.removeObjects(getObjects(null));
        }
        if (((curState.equals(WIN)||(curState.equals(LOSE))) &&(Greenfoot.isKeyDown("space")))){
        curState=START;
        // set background to level select screen
        this.setBackground("LevelSelect.png");
        }
    }
    /**
     * This method starts level 1 with it's characteristics
     */
    public void level1_start() {
        // Add the character 
        characterAdd();
        // Add the Enemy Shark
        enemySharkAdd();
        // Add the first Medal
        firstmedalAdd();
    }
    /**
     * This method starts level 2 with it's characteristics
     */
    public void level2_start() {
        // Add the character 
        characterAdd();
        // Add the Enemy Shark
        enemySharkAdd();
        // Add the Enemy Fish
        enemyFishAdd();
        // Add the first Medal
        firstmedalAdd();
     }
    /**
     * This method starts level 3 with it's characteristics
     */
    public void level3_start() {
        // Add the character 
        characterAdd();
        // Add the Enemy Shark
        enemySharkAdd();
        // Add the Enemy Fish
        enemyFishAdd();
        // Add the Enemy Jelly
        enemyJellyAdd();
        // Add the first Medal
        firstmedalAdd();
    }
    /**
     * This method starts level 4 with it's characteristics
     */
    public void level4_start() {
        // Add the character 
        characterAdd();
        // Add the Enemy Shark1
        enemySharkAdd();
        // Add the Enemy Shark2
        enemySharkAdd();
        // Add the Enemy Jelly
        enemyJellyAdd();
        // Add the Enemy Fish
        enemyFishAdd();
        // Add the first Medal
        firstmedalAdd();
        
        
       
    }
    /**
     * This method creates the counter on the top left of the screen
     */
    public void Counter (){
    score= new Counter();
    addObject(score,50,35);
    }
    /**
     * This method updates the score on the counter whenever the character gets a medal
     */
    public void updateScore(){
    score.addToScore();
    }
    /**
     * This method add a finishline whenever the method is called in the Counter class
     */
    public void finishlineAdder() {
    int finishLineX=200;
    int finishLineY=200;
    this.addObject(new Finishline(), finishLineX, finishLineY);
    }
    /**
     * This method adds the first medal
     */
    public void firstmedalAdd(){
     int medalX1 = Greenfoot.getRandomNumber(MLIMITX);
     int medalY1 = Greenfoot.getRandomNumber(MLIMITY);
     this.addObject(new Medal(),50+ medalX1,50+ medalY1);   
    }
    /**
     * This method add a finishline whenever a medal is removed
     */
    public void medalAdder() {
    int medalX2=Greenfoot.getRandomNumber(MLIMITX);
    int medalY2=Greenfoot.getRandomNumber(MLIMITY);
    this.addObject(new Medal(), 50+ medalX2,50+ medalY2);
    }
    /**
     * This method add a Fish to the World
     */
    public void enemyFishAdd(){
        this.addObject(new enemyFish(), EnemyX,EnemyY);
    }
    /**
     * This method add a Shark to the World
     */
    public void enemySharkAdd(){
       this.addObject(new enemyShark(), EnemyX+100,EnemyY+100);
    }
    /**
     * This method add a JellyFish to the World
     */
    public void enemyJellyAdd(){
    this.addObject(new enemyJelly(), EnemyX+50,EnemyY+100);
    }
    /**
     * This method adds the character to the World
     */
    public void characterAdd(){
    this.addObject(new Character(), CHARACTERX,CHARACTERY);
    }
    /**
     * This method makes the game go to next level or state Win
     */
    public void youWin(){
         if ((curState.equals(LEVEL_1))){
         curState = LEVEL_1COMPLETED;
         }  
         else if ((curState.equals(LEVEL_2))){
         curState = LEVEL_2COMPLETED;
         }  
         else if ((curState.equals(LEVEL_3))){
         curState = LEVEL_3COMPLETED;
         }  
         else if ((curState.equals(LEVEL_4))){
         curState = WIN;
         }  
    }
    /**
     * This method makes the game go to state Lose
     */
    public void youLose(){ 
         if ((curState.equals(LEVEL_1))|| (curState.equals(LEVEL_2)) || (curState.equals(LEVEL_3)) || (curState.equals(LEVEL_4))){
         curState = LOSE;
         }
    
    }
}
