import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.*;
/**
 * Write a description of class Wombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wombat extends Actor implements Feind, Treffbar
{
    /**
     * Act - do whatever the Wombat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int r�stung=300;
    int schaden=600;
    int leben=600;
    boolean added;
    HealthBar b = new HealthBar();
    static int wombatdeathcounter;

    ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
    public Wombat(){
        setImage("wombatWithArmor.png");
        b.setMax(r�stung);
       
    }
  
      
  
    public void act() 
    {
        healthBar();
        if(!added){
             getWorld().addObject(b,getX(),getY());
             added=true;
        }
        if(r�stung<=0){
            setImage("wombat.png");
            leben=leben+r�stung;
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
        if(Greenfoot.getRandomNumber(300)==0){
            int nX=getX()+Greenfoot.getRandomNumber(100);
            int nY=getY()+Greenfoot.getRandomNumber(100);
            if(nX<=getWorld().getWidth()&&nX>=0&&nY<=getWorld().getHeight()&&nY>=0){
                setLocation(nX,nY);
            }
        }
    }

    public void damage(int schaden){
        if(r�stung<=0)
            leben=leben-schaden;
        else
            r�stung=r�stung-schaden;
        if(leben<=0){
            getWorld().removeObject(this);
            wombatdeathcounter++;

        }
    }

    public void attack(){
        if(isTouching(Spieler.class)){
            Spieler t = (Spieler) getOneIntersectingObject(Spieler.class);
            t.damage(schaden);
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
       if(r�stung==0){
            b.switchToHealth();
            b.scaleB(leben);
        }
    }

}
