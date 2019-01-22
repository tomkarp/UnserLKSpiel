
import greenfoot.*;
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
    int schaden=200;
    boolean added;
    int ruestung=800;
    int schussSchaden=900;
    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    HealthBar b =new HealthBar();
    /**
     * Act - do whatever the PoisonDartFrog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dragon(){
        setImage("dragonWithArmor.png");
        getImage().scale(100,100);
        b.setMax(ruestung);
     
    }

    public void act() 
    {
         healthBar();
         if(!added){
             getWorld().addObject(b,getX(),getY());
              t.scheduleAtFixedRate(()->leben++,300,300,TimeUnit.MILLISECONDS);
             added=true;
        }
        if(ruestung<=0){
            setImage("dragon.png");
            getImage().scale(100,100);
            leben=leben+ruestung;
        }
        move();
        attack();
       
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
        if(Greenfoot.getRandomNumber(200)==0){
            getWorld().addObject(new Laser(getRotation()+90),getX()+10,getY()+10);
        }
    }

    


    public void healthBar(){
        b.setLocation(getX(),getY()+20);
        if(ruestung>0){
            b.scaleB(ruestung,getRotation());

        }
        else if(ruestung==0){
            b.switchToHealth();
            b.scaleB(leben,getRotation());
        }
    }
}
