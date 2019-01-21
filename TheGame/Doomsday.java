import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Doomsday extends Actor implements Waffen
{
    int cooldown;

    public Doomsday()
    { 
     setImage("balloon2.png");
    }

    public void act(){
    }

    public void attacke(int w){
        if(cooldown == 0){
            getWorld().addObject(new Granate(w), getX(), getY());
            cooldown = 100;
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
