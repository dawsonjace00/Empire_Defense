import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Velt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    private static final int SPD=4;
    private int num=10;
    private int speed;
    private boolean dir=false;
    private int counter=0;
    private int amntAttackers=0;
    
    private final String START = "START";
    private final String PLAYING = "PLAYING";
    private final String WIN = "WIN";
    private final String LOSE = "LOSE";
    
    private String curState; 
    private int playState = 1;
    /**
     * Constructor for objects of class Velt.
     * 
     */
    public Background()
    {    
        super(800,600, 1); 
        speed=dir?-SPD:SPD;
        addObject(new Defender(),400,550);
        for(int i=50;i<271;i+=50)
        {
            for(int j=100;j<626;j+=35)
            {
                addObject(new Attacker(),j,i);
            }
        }
        this.setBackground("background.png");
    }

    public void act()
    {
        counter++;
        speed=dir?-SPD:SPD;
        List <Attacker> attackers=getObjects(Attacker.class);
        for(Attacker attacker:attackers)
        {
            attacker.moveAttacker();
            amntAttackers++;
        }
        if(amntAttackers==0)
        {
            /*for(int i=50;i<271;i+=50)
            {
                for(int j=100;j<626;j+=35)
                {
                    addObject(new Attacker(),j,i);
                }
            }*/
            Greenfoot.setWorld(new Background2());
        }
        amntAttackers=0;
        if (Greenfoot.isKeyDown("space"))
        {
            curState = PLAYING;
            this.setBackground("background.png");
        }
        if (Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("w"))
        {
            curState = WIN;
            this.setBackground("win.png");
        }
        if (Greenfoot.isKeyDown("L") || Greenfoot.isKeyDown("l"))
        {
            curState = LOSE;
            this.setBackground("lose.png");
        }    
    }

    /**
     * Getter for int variable "num".
     */
    public int getNum()
    {
        return num;
    }

    /**
     * Getter for int variable "speed".
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * Setter for int variable "speed".
     */
    public void setSpeed(int spd)
    {
        speed=spd;
    }

    /**
     * Getter for boolean variable dir.
     */
    public boolean getDir()
    {
        return dir;
    }

    /**
     * Setter for boolean variable dir.
     */
    public void setDir(boolean direction)
    {
        dir=direction;
    }

    /**
     * Getter for int variable counte.
     */
    public int getCounter()
    {
        return counter;
    }

    /**
     * Set int variablr counter to zero.
     */
    public void setZero()
    {
        counter=0;
    }

    /**
     * Move all the aliens down.
     */
    public void moveDown()
    {
        List <Attacker> attackers=getObjects(Attacker.class);
        for(Attacker attacker:attackers)
        {
            attacker.moveDown();
        }
    }
}














