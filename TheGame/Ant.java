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
    int ruestung=20;
    boolean added;
    int schaden=20;
    int max;
    int act;
    HealthBar b =new HealthBar();
    public Ant(){
        setImage("antWithArmor.png");
        getImage().scale(33,20);
        max=ruestung+leben;
    }

    public void act() 
    {
        if(leben>=0)
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
        if(leben<(max-ruestung)&&act%50==0){
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
        else if(schaden<ruestung)
            ruestung=ruestung-schaden;
        else if(schaden>=ruestung){
            schaden=schaden-ruestung;
            ruestung=0;
            leben=leben-schaden;
        }
        if(leben<=0){
            getWorld().removeObject(b);
            getWorld().removeObject(this);
        }
    }

    public void healthBar(){
        b.setLocation(getX(),getY()+15);        
        b.scaleB(leben+ruestung,max,getRotation());
    }

}
