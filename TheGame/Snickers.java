import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snickers extends Actor
{
    public void act()
    {
        treffen();
    }
    public void treffen()
    {   if(isTouching(Spieler.class)) {
            Spieler s = (Spieler) getOneIntersectingObject(Spieler.class);
            getWorld().removeObject(this);
            s.leben+=50;
        }
    }
}
