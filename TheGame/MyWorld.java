import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    public MyWorld()
    {    
        super(600, 400, 1); 
        addObject(new Spieler(), 300, 200);
        int zufall;
    }
    
    public void act() {
        erzeugeObjekte();
    }
     private int randX() {
        return Greenfoot.getRandomNumber(getWidth());
    }

    private int randY() {
        return Greenfoot.getRandomNumber(getHeight());
    }
    
    private void erzeugeObjekte() {
        int zufall;
        zufall = Greenfoot.getRandomNumber(300);
        if(zufall == 0)
            addObject(new Snickers(), randX(), randY());
        zufall = Greenfoot.getRandomNumber(300);
        if(zufall == 0)
            addObject(new Trank(), randX(), randY());
    }
}
