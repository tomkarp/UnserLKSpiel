import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class KleineImpressionAusDemChinaRestaraunt extends Actor implements Waffen 
{
    int cooldown;
    int wurf;

    public KleineImpressionAusDemChinaRestaraunt(){
        setImage("stäbchen.png");
        getImage();
    }

    public void act() 
    {
        cooldown--;
        if (wurf == 1){
            move(25);
        }
    }    

    public void attacke(int w){
        
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
            setRotation(winkel);
        }
    }
}
