import greenfoot.*; 

/**
 * Weakest enemy
 * 
 * @author Lennart und Frederik 
 * @version 0.2
 */
import java.util.concurrent.*;
public class Ant extends Actor implements Feind
{
    int leben=100;
    int rüstung=20;
    int schaden=200;
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    public Ant(){
        setImage("antWithArmor.png");
        getImage().scale(33,20);
    }

    public void act() 
    {
        if(rüstung<=0){
            setImage("ant.png");
            leben=leben+rüstung;
        }
        move();
        attack();
        regHealth();
    }    

    public void move(){
       move(3);
       if(Greenfoot.getRandomNumber(30)==0){
           turn(Greenfoot.getRandomNumber(360));
        }
        if(isAtEdge()){
            turn(180);
        }
    }

    public void attack(){
        if(isTouching(Spieler.class)){
          // getOneIntersectingObject(Spieler.class).treffeBaby(schaden);
        }
    }

    public void damage(int schaden){
        if(rüstung==0)
            leben=leben-schaden;
        else
            rüstung=rüstung-schaden;
        if(leben<=0){
            getWorld().removeObject(this);
        }
    }

    public void regHealth(){
        t.scheduleAtFixedRate(()->leben++,1,1,TimeUnit.SECONDS);
    }
}
