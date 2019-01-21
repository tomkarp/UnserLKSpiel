import greenfoot.*; 
public class Laser extends Actor implements Projektil  
{
    int zeit;
    public Laser(int schaden,int w)
    {
        zeit = 50;
        setRotation(w - 90);
    }
    public void act(){
        move(33);
        remove();
    }
    
    public void remove(){
        if(zeit != 0)
            zeit--;
        else
            getWorld().removeObject(this);
    }
}
