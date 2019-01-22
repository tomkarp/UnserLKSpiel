import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor implements Effekte
{
    private GreenfootImage e1;
    int i;
    int schaden;

    public Explosion(){
        setImage("explosion1.png");
        getImage().scale(120,120);
        schaden=300;
    }

    public void act() 
    {
        remove();

    }    

    public void remove(){
        if (i == 15 || isAtEdge())
            getWorld().removeObject(this);
        else{
            checkGegner();
            i++;
        }
    }

    public void checkGegner(){
        if(isTouching(Treffbar.class)){
            Treffbar t=(Treffbar)getOneIntersectingObject(Treffbar.class);
            t.damage(schaden);
        }
    }
}
