import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.*;
/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{

    int leben=900;
    int schaden=800;
    int rüstung=800;
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    /**
     * Act - do whatever the PoisonDartFrog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dragon(){
        setImage("dragonWithArmor.png");
        getImage().scale(40,38);
    }

    public void act() 
    {
        if(rüstung<=0){
            setImage("dragon.png");
            leben=leben+rüstung;
        }
        move();
        attack();
        regHealth();
    }    

    public void move(){
        move(1);
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
        t.scheduleAtFixedRate(()->leben++,200,200,TimeUnit.MILLISECONDS);
    }
}
