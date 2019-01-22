import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hellebarde extends Actor implements Waffen 
{
    int cooldown;
    
    public Hellebarde(){
        setImage("Hellebarde.png");
    }
    
    public void act() 
    {
        cooldown--;
    }    
    
    public void attacke(int w){
        
    }
    
    public void zielen(int winkel){
        
    }
    
    public void tragen(int x , int y , int winkel){
        
    }
}
