import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    int max;
    public HealthBar(){
         setImage("armorBar.png");
         getImage().scale(25,7);
    }
 
    public void setMax(int max){
        this.max=max;
    }

    public void scaleB(int current,int rotation){
        int length=((current/max)*100)/4;
        getImage().scale(length,7);
        setRotation(rotation);
    }

    public void switchToHealth(){
      setImage("healthBar.png");
    }
}
