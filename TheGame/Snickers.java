import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Snickers extends Actor
{
   
 public void treffen(Spieler s)
    {     if(isTouching(Spieler.class))
        {
            s.leben=10000;
        }
    }
}
