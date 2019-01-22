import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Laserphaser extends Actor implements Waffen
{   
    int cooldown;
    
    public Laserphaser()
    { 
    setImage("balloon1.png");
    }

    public void act(){
    }

    public void attacke(int w){
       
            getWorld().addObject(new Laser(w,200), getX(), getY());
           
       
    }

    public void zielen(int w){
        setRotation(w);
    }

    public void tragen(int x, int y, int winkel){
        setLocation(x,y);
        setRotation(winkel);
    }
}    

