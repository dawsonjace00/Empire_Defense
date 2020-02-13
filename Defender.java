import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Defender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Defender extends Actor
{
    private GreenfootImage img=new GreenfootImage("tiefighter.png");
    private int counter=0;
    public Defender()
    {
        setImage(img);
        img.scale(img.getWidth()/6,img.getHeight()/6);
        
    }
    
    /**
     * Act - do whatever the Defender wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        counter++;
        if(Greenfoot.isKeyDown("Right")||Greenfoot.isKeyDown("d"))move(6);
        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))move(-6);
        if(isTouching(Attacker.class))Greenfoot.stop();
        if(counter>10)
        {
            if(Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("space"))
            {
                getWorld().addObject(new Bullet(-10),getX(),getY()-50);
                counter=0;
            }
        }
        if(isTouching(Bullet2.class))Greenfoot.setWorld(new GameOver());
    }    
}
