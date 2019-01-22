import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class KleineImpressionAusDemChinaRestaraunt extends Actor implements Waffen 
{
    int schaden;
    int cooldown;
    int wurf;

    public KleineImpressionAusDemChinaRestaraunt(){
        setImage("stäbchen.png");
        getImage();
        schaden = 1;
    }

    public void act() 
    {
        cooldown--;
        if (wurf == 1){
            if(isAtEdge()){
                getWorld().removeObject(this);
            }
            else{
                move(25);
            } 
        }
    }    

    public void attacke(int w){
        setRotation(getRotation());
        wurf = 1;
    }

    public void zielen(int winkel){
        if (wurf == 0){
            setRotation(winkel);
        }
    }

    public void tragen(int x , int y , int winkel){
        if (wurf == 0){
            setLocation(x,y);
            setRotation(winkel - 90);
        }
    }
}
