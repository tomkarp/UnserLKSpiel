import greenfoot.*; 
public class Laser extends Actor implements Projektil  
{
    int zeit;
    public Laser(int schaden,int w)
    {
        zeit = 100;
        setRotation(w - 90);
        setImage("LaserBlau.png");
        getImage().scale(30,10);
    }

    public void act(){

        if(isAtEdge()){
            remove();
        }
        else{
            move(5);
        } 

    }

    public void remove(){
        getWorld().removeObject(this);
    }
}
