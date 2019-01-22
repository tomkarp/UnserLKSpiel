import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.*;
/**
 * Write a description of class Wombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wombat extends Actor implements Feind, Treffbar
{
    /**
     * Act - do whatever the Wombat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int ruestung=300;
    int schaden=50;
    int leben=600;
    int max;
    boolean added;
    HealthBar b = new HealthBar();
    static int wombatdeathcounter = 1;
    int act;
    public Wombat(){
        setImage("wombatWithArmor.png");
        max=ruestung+leben;
    }

    public void act() 
    {
        regHealth();
        if(leben>0)
        healthBar();
        
        if(!added){
            getWorld().addObject(b,getX(),getY());
            added=true;
        }
        if(ruestung<=0){
            setImage("wombat.png");
            leben=leben+ruestung;
        }
        move();
        attack();
        act++;
    }    

    public void regHealth(){
        if(leben<(max-ruestung)&&act%50==0){
            leben++;
        }
    }

    public void move(){
        move(2);
        if(Greenfoot.getRandomNumber(50)==0){
            turn(Greenfoot.getRandomNumber(180));
        }
        if(isAtEdge()){
            turn(180);
        }
        if(Greenfoot.getRandomNumber(300)==0){
            int nX=getX()+Greenfoot.getRandomNumber(100);
            int nY=getY()+Greenfoot.getRandomNumber(100);
            if(nX<=getWorld().getWidth()&&nX>=0&&nY<=getWorld().getHeight()&&nY>=0){
                setLocation(nX,nY);
            }
        }
    }

     public void damage(int schaden){
        if(ruestung<=0)
            leben=leben-schaden;
        else if(schaden<ruestung)
            ruestung=ruestung-schaden;
        else if(schaden>ruestung){
            schaden=schaden-ruestung;
            ruestung=0;
            leben=leben-schaden;
        }
        if(leben<=0){
            getWorld().removeObject(b);
            getWorld().removeObject(this);
        }
    }
    

    public void attack(){
        if(isTouching(Spieler.class)){
            Spieler t = (Spieler) getOneIntersectingObject(Spieler.class);
            t.damage(schaden);
        }
    }

    public void healthBar(){
        b.setLocation(getX(),getY()+20);
        b.scaleB(ruestung+leben,max,getRotation());
    }

}
