import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spieler extends Actor
{
    public int leben;
    public int punkte;
    public void act() 
    {
        if(Greenfoot.isKeyDown("up"))
            setLocation(getX(), getY() - 2);
        if(Greenfoot.isKeyDown("down"))
            setLocation(getX(), getY() + 2);
        if(Greenfoot.isKeyDown("left"))
            setLocation(getX() - 2, getY());
        if(Greenfoot.isKeyDown("right"))
            setLocation(getX() + 2, getY());        
    }    
   
    public void anzeigen() {
        getWorld().showText("Punktestand: " + punkte , 110, 11);
        getWorld().showText("Leben: " + leben , 350, 11);
    }
    }

