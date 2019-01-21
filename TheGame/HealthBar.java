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
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void HealthBar(){
        setImage("armorBar.png");
    }

    public void setMax(int max){
        this.max=max;
    }

    public void scaleB(int current){
        int length=(current/max)*100;
        getImage().scale(length,20);
    }

    public void switchToHealth(){
      setImage("healthBar.png");
    }
}
