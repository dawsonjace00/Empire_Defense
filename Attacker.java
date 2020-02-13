import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attacker extends Actor
{
    private GreenfootImage img=new GreenfootImage("x-wing.png");
    public Attacker()
    {
        img.scale(img.getWidth()/11,img.getHeight()/11);
        setImage(img);
        
    }
    
    /** 
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getRandomNumber(5000)==1)getWorld().addObject(new Bullet2(10),getX(),getY()+5);
        if(isTouching(Bullet.class))
        {
            removeTouching(Bullet.class);
            getWorld().removeObject(this);
        }
               
    } 
    
    public void moveAttacker()
    {
        Background background=(Background)getWorld();
        setLocation(getX()+background.getSpeed(),getY());
        if(isAtEdge()&&background.getCounter()>1)
        {
            background.moveDown();
            background.setDir(background.getDir()?false:true);
            background.setZero();
        }
    }
    
    public void moveDown()
    {
        Background background=(Background)getWorld();
        setLocation(getX(),getY()+10);
    }
    
}
