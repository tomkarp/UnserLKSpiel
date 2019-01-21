import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Poison extends Actor implements Feind
{
    int schritte;
    int schaden=400;
    /**
     * Act - do whatever the Poison wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Poison(){
        setImage("poison.png");
        getImage().scale(20,50);
    }

    public void act() 
    {
        vanish();
       attack();
    }    

    public void vanish(){
        schritte++;
        if(schritte==600){
            getWorld().removeObject(this);
        }
    }
    public void attack(){
        if(isTouching(Spieler.class)){
            //treffeBaby(schaden)
        }
    }
    public void move(){
        
        
    }
    public void regHealth(){
        
    }
    public void damage( int d){
    }
}
