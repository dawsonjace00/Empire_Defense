import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attacker2 extends Actor
{
    private GreenfootImage img=new GreenfootImage("x-wing.png");
    public Attacker2()
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
        if(Greenfoot.getRandomNumber(3000)==1)getWorld().addObject(new Bullet2(10),getX(),getY()+5);
        if(isTouching(Bullet.class))
        {
            removeTouching(Bullet.class);
            getWorld().removeObject(this);
        }
               
    } 
    
    public void moveAttacker()
    {
        Background2 background2=(Background2)getWorld();
        setLocation(getX()+background2.getSpeed(),getY());
        if(isAtEdge()&&background2.getCounter()>1)
        {
            background2.moveDown();
            background2.setDir(background2.getDir()?false:true);
            background2.setZero();
        }
    }
    
    public void moveDown()
    {
        Background2 background2=(Background2)getWorld();
        setLocation(getX(),getY()+10);
    }
    
}
