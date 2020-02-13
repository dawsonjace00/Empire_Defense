import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private GreenfootImage img=new GreenfootImage("bullet.png");
    private int speed;
    public Bullet(int speed)
    {
        this.speed=speed;
        setImage(img);
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(),getY()+speed);
        if(isAtEdge())getWorld().removeObject(this);
    }    
}
