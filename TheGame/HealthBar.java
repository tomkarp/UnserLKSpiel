import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{

    public HealthBar(){
        setImage("healthBar.png");
        getImage().scale(25,7);
    }


    public void scaleB(int current,int max,int rotation){
        System.out.println(current+"c"+max+"m");
        float length=current;
        length=length/max;
        System.out.println(length+"percentage");
        length=length*100;
        System.out.println("als richtige Zahl"+length);
        length=length/2;
        System.out.println(length+"angepasst");
        int print= (int) length;
        getImage().scale(print,7);
        setRotation(rotation);
    }

}
