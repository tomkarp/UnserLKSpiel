import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor implements Effekte
{
    private GreenfootImage e1;
    int i;
    int schaden;

    public Explosion(){
        setImage("explosion1.png");
        schaden=300;
    }

    public void act() 
    {
        remove();
    }    

    public void remove(){
        if (i == 15)
            getWorld().removeObject(this);
        else
            i++;
    }

    public void checkGegner(){
        if(isTouching(Treffbar.class)){
            Treffbar t=(Treffbar)getOneIntersectingObject(Treffbar.class);
            t.damage(schaden);
        }

    }
}
