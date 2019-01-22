import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.*;
/**
 * Write a description of class PoisonDartFrog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoisonDartFrog extends Actor implements Feind
{
    int leben=300;
    int schaden=40;
    boolean added;
    int max;
    int act;
    int ruestung=100;
    HealthBar b =new HealthBar();
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    /**
     * Act - do whatever the PoisonDartFrog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PoisonDartFrog(){
        setImage("frogWithArmor.png");
        getImage().scale(40,38);
        max=ruestung+leben;
    }

    public void act() 
    {
        if(leben>0)
        healthBar();
        if(!added){
            getWorld().addObject(b,getX(),getY());
            added=true;
        }
        if(ruestung<=0){
            setImage("frog.png");
            getImage().scale(40,38);
            leben=leben+ruestung;
        }
        move();
        attack();
        regHealth();
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
    }

     public void damage(int schaden){
        if(ruestung<=0)
            leben=leben-schaden;
        else if(schaden<=ruestung)
            ruestung=ruestung-schaden;
        else if(schaden>ruestung){
            schaden=schaden-ruestung;
            ruestung=0;
            leben=leben-schaden;
        }
        if(leben<=0){
            getWorld().removeObject(b);
            getWorld().addObject(new Poison(),getX(),getY());
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
        b.scaleB(leben+ruestung,max,getRotation());        
    }

}
