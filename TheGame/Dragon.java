
import greenfoot.*;
import java.util.concurrent.*;
/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor implements Feind
{

    int leben=900;
    int schaden=200;
    boolean added;
    int ruestung=800;
    int schussSchaden=900;
    int max;
    int act;
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    HealthBar b =new HealthBar();
    /**
     * Act - do whatever the PoisonDartFrog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dragon(){
        setImage("dragonWithArmor.png");
        getImage().scale(100,100);
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
            setImage("dragon.png");
            getImage().scale(100,100);
            leben=leben+ruestung;
        }
        move();
        attack();
        act++;
        regHealth();
    }   

    public void regHealth(){
        if(leben<(max-ruestung)&&act%30==0){
            leben++;
        }
    }

    public void move(){
        move(1);
        if(Greenfoot.getRandomNumber(90)==0){
            turn(Greenfoot.getRandomNumber(180));
        }
        if(isAtEdge()){
            turn(180);
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
        if(Greenfoot.getRandomNumber(200)==0){
            getWorld().addObject(new Laser(getRotation()+90),getX()+10,getY()+10);
        }
    }


    public void healthBar(){
        b.setLocation(getX(),getY()+20);
        b.scaleB(leben+ruestung,max,getRotation());
        }
    }

