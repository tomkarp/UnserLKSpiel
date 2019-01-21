import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Laserphaser extends Actor implements Waffen
{   
    int cooldown;
    
    public Laserphaser()
    { 

    }

    public void act(){
    }

    public void attacke(int w){
        if(cooldown == 0){
            getWorld().addObject(new Laser(w), getX(), getY());
            cooldown = 23;
        }
        else 
            cooldown--;
    }

    public void zielen(int w){
        setRotation(w);
    }

    public void tragen(int x, int y, int winkel){
        setLocation(x,y);
        setRotation(winkel);
    }
}    

