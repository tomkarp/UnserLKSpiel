import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.*;
/**
 * Write a description of class PoisonDartFrog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PoisonDartFrog extends Actor implements Feind, Treffbar
{
    int leben=300;
    int schaden=40;
    boolean added;
    int maxleben;
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
        b.setMax(ruestung);
        maxleben=leben;
    }

    public void act() 
    {
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
        if(leben<maxleben&&act%50==0){
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
        else
            ruestung=ruestung-schaden;
        if(leben<=0){
            getWorld().removeObject(this);
            getWorld().addObject(new Poison(),getX(),getY());
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
        if(ruestung>0){
            b.scaleB(ruestung,getRotation());
        }
        else if(ruestung<=0){
            b.switchToHealth();
            b.scaleB(leben,getRotation());
        }
    }

}
