import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Trank extends Actor
{
    private void treffen()
    {
        if(isTouching(Spieler.class))
        {
            Trank p = (Snickers) getOneIntersectingObject(Snickers.class);
            getWorld().removeObject(p);
            Spieler.setleben(80);
        }
    }
}
