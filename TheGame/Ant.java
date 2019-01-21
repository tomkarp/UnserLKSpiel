import greenfoot.*; 

/**
 * Weakest enemy
 * 
 * @author Lennart und Frederik 
 * @version 0.2
 */
import java.util.concurrent.*;
public class Ant extends Actor implements Feind, Treffbar
{
    int leben=100;
    int rüstung=20;
    int schaden=200;
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    HealthBar b =new HealthBar();
    public Ant(){
        setImage("antWithArmor.png");
        getImage().scale(33,20);
        b.setMax(rüstung);
        getWorld().addObject(b,0,0);
    }

    public void act() 
    {
        if(rüstung<=0){
            setImage("ant.png");
            getImage().scale(33,20);
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
            Spieler t = (Spieler) getOneIntersectingObject(Spieler.class);
            t.damage(schaden);
        }
    }

    public void damage(int schaden){
        if(rüstung<=0)
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

    public void healthBar(){
        b.setLocation(getX(),getY()+10);
        if(rüstung>0){
            b.scale(rüstung);

        }
        else if(rüstung==0){
            b.switchToHealth();
            b.scaleB(leben);
        }
    }
}
