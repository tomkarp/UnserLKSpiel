import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class EricClapThat extends Actor implements Waffen
{
    int cooldown;

    public EricClapThat(){
        setImage("EricClapThat.png");    
    }

    public void act() 
    {
        cooldown--;
    }    

    public void attacke(int w){

    }

    public void zielen(int winkel){
        setRotation(winkel);
    }

    public void tragen(int x , int y , int winkel){
        setLocation(x,y);
        setRotation(winkel);
    }
}
