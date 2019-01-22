import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Granate extends Actor implements Projektil
{
    int zeit = 0;
    public Granate(int w){
        setImage("steel-ball.png");
        setRotation(w - 90);
    }

    public void act() 
    {
        remove();
    }    

    public void remove(){
        zeit++;
        if(zeit < 27)
            move(12);
        else if(zeit == 28)
            getWorld().addObject(new Explosion(),getX(),getY());

        else if(zeit == 35){
            getWorld().addObject(new Explosion(),getX() + (int)(zeit * 1.5),getY()+ (int)(zeit * 1.3));
            getWorld().addObject(new Explosion(), getX() + (int)(zeit * 1.5),getY() - (int)(zeit * 1.3));
            getWorld().addObject(new Explosion(),getX() - (int)(zeit * 1.5),getY()+ (int)(zeit * 1.3));
            getWorld().addObject(new Explosion(),getX() - (int)(zeit * 1.5),getY()- (int)(zeit * 1.3));
        }
        else if(zeit > 35){
            getWorld().removeObject(this);
        }
    }
}
