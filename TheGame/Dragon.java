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
    int rüstung=800;
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
         b.setMax(rüstung);
        getWorld().addObject(b,0,0);
    }

    public void act() 
    {
        if(rüstung<=0){
            setImage("dragon.png");
            getImage().scale(100,100);
            leben=leben+rüstung;
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
        if(rüstung<=0)
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
            getOneIntersectingObject(Spieler.class).damage(schaden);
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
       if(rüstung>0){
           b.scale(rüstung);
        }
        else if(rüstung==0){
            b.switchToHealth();
            b.scale(leben);
        }
    }
}
