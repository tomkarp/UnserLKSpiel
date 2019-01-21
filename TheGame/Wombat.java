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
   int rüstung=300;
   int schaden=600;
   int leben=600;
   static int wombatdeathcounter;
   ScheduledThreadPoolExecutor t=new ScheduledThreadPoolExecutor(1);
   public Wombat(){
       setImage("wombatWithArmor.png");
       
    }
    public void act() 
    {
        if(rüstung<=0){
            setImage("wombat.png");
            leben=leben+rüstung;
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
        if(rüstung<=0)
            leben=leben-schaden;
        else
            rüstung=rüstung-schaden;
        if(leben<=0){
            getWorld().removeObject(this);
            wombatdeathcounter++;
        }
    }

    public void attack(){
        if(isTouching(Spieler.class)){
            getOneIntersectingObject(Spieler.class).damage(schaden);
        }
    }
        public void regHealth(){
            t.scheduleAtFixedRate(()->leben++,200,200,TimeUnit.MILLISECONDS);
        }
    
}
