import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Poison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Poison extends Actor 
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
       
    }    

    public void vanish(){
        schritte++;
        if(schritte==1000){
            getWorld().removeObject(this);
        }else{
             attack();
        }
    }

    public void attack(){
        if(isTouching(Spieler.class)){
            Spieler t = (Spieler) getOneIntersectingObject(Spieler.class);
            t.damage(schaden);
        }
    }

}
