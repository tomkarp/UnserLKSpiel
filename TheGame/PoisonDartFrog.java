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
    int schaden=300;
    int rüstung=100;
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    /**
     * Act - do whatever the PoisonDartFrog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PoisonDartFrog(){
        setImage("frogWithArmor.png");
        getImage().scale(40,38);
    }

    public void act() 
    {
        if(rüstung<=0){
            setImage("frog.png");
            getImage().scale(40,38);
            leben=leben+rüstung;
        }
        move();
        attack();
        regHealth();
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
        if(rüstung==0)
            leben=leben-schaden;
        else
            rüstung=rüstung-schaden;
        if(leben<=0){
            getWorld().removeObject(this);
            getWorld().addObject(new Poison(),getX(),getY());
        }
    }

    public void attack(){
        if(isTouching(Spieler.class)){
            // getOneIntersectingObject(Spieler.class).treffeBaby(schaden);
        }
    }

    public void regHealth(){
        t.scheduleAtFixedRate(()->leben++,500,500,TimeUnit.MILLISECONDS);
    }

}
