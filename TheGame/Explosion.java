import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor implements Effekte
{
    private GreenfootImage e1;
    int i;
    
    public Explosion(){

    }
    public void act() 
    {
        remove();
    }    
    public void remove(){
        if (i == 15)
            getWorld().removeObject(this);
        else
            i++;
    }
}
