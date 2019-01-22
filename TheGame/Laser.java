import greenfoot.*; 
public class Laser extends Actor implements Projektil  
{
    int schaden;
    
    public Laser(int w)
    {
        schaden=70;
        setRotation(w - 90);
        setImage("LaserBlau.png");
        getImage().scale(30,10);
    }

    public void act(){
        checkGegner();
        move(15);
    }

    public void checkGegner(){
        if(isTouching(Treffbar.class) && !isTouching(Dragon.class)){
            Treffbar t=(Treffbar)getOneIntersectingObject(Treffbar.class);
            t.damage(schaden);
            getWorld().removeObject(this);

        }
        else if(isAtEdge()){
            remove();
        }
    }

    public void remove(){
        getWorld().removeObject(this);
    }
}
