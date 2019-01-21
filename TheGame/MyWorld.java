import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    public MyWorld()
    {    
        super(900, 600, 1); 
        addObject(new Spieler(), getWidth()/2, getHeight()/2);
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
        zufall = Greenfoot.getRandomNumber(600);
        if(zufall == 0)
            addObject(new Snickers(), randX(), randY());
        zufall = Greenfoot.getRandomNumber(500);
        if(zufall == 0)
            addObject(new Trank(), randX(), randY());
        zufall = Greenfoot.getRandomNumber(600);
        if(zufall == 0)
            addObject(new Ant(), randX(), randY());
        zufall = Greenfoot.getRandomNumber(1100);
        if(zufall == 0)
            addObject(new PoisonDartFrog(), randX(), randY());  
        zufall = Greenfoot.getRandomNumber(1500);
        if(zufall == 0)
            addObject(new Wombat(), randX(), randY());
        if(Wombat.wombatdeathcounter%10 == 0&&Wombat.wombatdeathcounter!=0){
            addObject(new Dragon(), randX(), randY()); 
            Wombat.wombatdeathcounter++;
        }
    }
}
