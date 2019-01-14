import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    public MyWorld()
    {    
        super(600, 400, 1); 
        addObject(new Spieler(), 300, 200);
        int zufall;
        zufall = Greenfoot.getRandomNumber(400);
        if(zufall == 0)
            addObject(new Vogel(), randX(), randY());
        zufall = Greenfoot.getRandomNumber(400);
        if(zufall == 0)
            addObject(new Wildschwein(), randX(), randY());
    }
}
