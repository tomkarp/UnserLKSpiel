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
    int ruestung=20;
    boolean added;
    int schaden=20;
    int maxleben;
    int act;
    HealthBar b =new HealthBar();
    public Ant(){
        setImage("antWithArmor.png");
        getImage().scale(33,20);
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
            setImage("ant.png");
            getImage().scale(33,20);
            leben=leben+ruestung;
        }
        move();
        attack();
        act++;
        regHealth();
    }    

    public void regHealth(){
        if(leben<maxleben&&act%50==0){
            leben++;
        }
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
        if(ruestung<=0)
            leben=leben-schaden;
        else
            ruestung=ruestung-schaden;
        if(leben<=0){
            getWorld().removeObject(this);
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
