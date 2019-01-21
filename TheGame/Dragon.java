import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.*;
/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor implements Feind, Treffbar
{

    int leben=900;
    int schaden=800;
    boolean added;
    int r�stung=800;
    int schussSchaden=400;
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    HealthBar b =new HealthBar();
    /**
     * Act - do whatever the PoisonDartFrog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dragon(){
        setImage("dragonWithArmor.png");
        getImage().scale(100,100);
        b.setMax(r�stung);
     
    }

    public void act() 
    {
         if(!added){
             getWorld().addObject(b,getX(),getY());
             added=true;
        }
        if(r�stung<=0){
            setImage("dragon.png");
            getImage().scale(100,100);
            leben=leben+r�stung;
        }
        move();
        attack();
        regHealth();
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
        if(r�stung<=0)
            leben=leben-schaden;
        else
            r�stung=r�stung-schaden;
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
        if(Greenfoot.getRandomNumber(200)==0){
            getWorld().addObject(new Laser(schussSchaden,getRotation()+90),getX()+10,getY()+10);
        }
    }

    public void regHealth(){
        t.scheduleAtFixedRate(()->leben++,200,200,TimeUnit.MILLISECONDS);
    }


    public void healthBar(){
        b.setLocation(getX(),getY()+10);
        if(r�stung>0){
            b.scaleB(r�stung);
        }
        else if(r�stung==0){
            b.switchToHealth();
            b.scaleB(leben);
        }
    }
}
