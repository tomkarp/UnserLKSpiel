import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{

    public HealthBar(){
        setImage("healthBar.png");
        getImage().scale(25,7);
    }


    public void scaleB(int current,int max,int rotation){
        float length=current;
        length=length/max;
        length=length*100;
        length=length/2;
        int print= (int) length;
        if(print!=0)
        getImage().scale(print,7);
        else if(print==0)
        getImage().scale(1,7);
        setRotation(rotation);
    }

}
