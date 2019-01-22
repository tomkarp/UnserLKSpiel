import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


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
        System.out.println(current+"vorher2");
        int length=((current/max)*100)/4;
        System.out.println(length);
        getImage().scale(length,7);
        setRotation(rotation);
    }

    public void switchToHealth(){
      setImage("healthBar.png");
    }
}
