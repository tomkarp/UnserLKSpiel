import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Laserphaser extends Actor implements Waffen
{   
    int cooldown;

    public Laserphaser()
    { 
        setImage("balloon1.png");
    }

    public void act(){
        if (cooldown != 0){
            cooldown--;
        }
    }

    public void attacke(int w){
        if(cooldown == 0){
            getWorld().addObject(new Laser(w),getX(),getY() );
            cooldown = 10;
        }
    }

    public void zielen(int w){
        setRotation(w);
    }

    public void tragen(int x, int y, int winkel){
        setLocation(x,y);
        setRotation(winkel);
    }
}    

