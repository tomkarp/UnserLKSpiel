import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Trank extends Actor    
{        
    public void Trank(){
        setImage("Juice.png");
    }

    public void act()
    {
        treffen();
    }

    private void treffen()
    {
        if(isTouching(Spieler.class)) {
            Spieler s = (Spieler) getOneIntersectingObject(Spieler.class);
            getWorld().removeObject(this);
            s.leben+=50;
        }
    }   
}
