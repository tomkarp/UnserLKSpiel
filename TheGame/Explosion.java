import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor implements Effekte
{
    private GreenfootImage e1;
    int i;
<<<<<<< HEAD

=======
    int schaden;
>>>>>>> 9c2badcaeba310500577e03702a8b1886a008061
    public Explosion(){
     setImage("beeper.png");
     schaden=300;
    }

    public void act() 
    {
        remove();
        schaden();
    }    

    public void remove(){
        if (i == 15)
            getWorld().removeObject(this);
        else
            i++;
    }
<<<<<<< HEAD

    public void schaden(){
        //if (isTouching(Treffbar.class)){
         //}
=======
    public void checkGegner(){
        if(isTouching(Treffbar.class)){
            Treffbar t=(Treffbar)getOneIntersectingObject(Treffbar.class);
            t.damage(schaden);
        }
>>>>>>> 9c2badcaeba310500577e03702a8b1886a008061
    }
}
