import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hellebarde extends Actor implements Waffen 
{
    int cooldown;
    int schaden;

    public Hellebarde(){
        setImage("Hellebarde.png");
        schaden = 100;
    }

    public void act() 
    {
        cooldown--;
        if(isTouching(Feind.class)){
            Feind t = (Feind)getOneIntersectingObject(Feind.class);
            t.damage(schaden);
        }
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
