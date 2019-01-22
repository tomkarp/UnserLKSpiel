import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Trank extends Actor    
{        
    public Trank(){
       setImage("SlurpJuice.png");
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
            s.leben+=300;
        }
    }   
}
