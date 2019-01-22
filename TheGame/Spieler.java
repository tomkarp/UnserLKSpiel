import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spieler extends Actor implements Treffbar
{
    int leben;
    int i;
    int x;
    int y;
    double blickWinkel;

    double alpha;
    double beta;
    double a2 ;
    double b2; 
    Waffen aktuelleWaffe; 

    public Spieler(){
        blickWinkel = 1;
        i = 1;
    }

    public void act() 
    {
        if (i> 0){
            waffenWechsel();
            i--;
        }
        x = getX();
        y = getY();
        bewegen();
        if(aktuelleWaffe !=  null){
            kreis();
            attacke();
        }
    }  
    
    public void damage(int s){
        leben = leben - s;
    }

    private void kreis(){
        if(Greenfoot.getMouseInfo() != null){
            int a = Greenfoot.getMouseInfo().getX() - getX();
            int b = Greenfoot.getMouseInfo().getY() - getY();
            double c = Math.sqrt(a*a +  b*b);
            final double gamma = 90;
            final int c2 = 40;
            if(a >= 0 && b > 0){
                beta = Math.toDegrees(Math.asin(b / c));
                blickWinkel = beta + 90;
                alpha = 180 - beta - gamma;

                a2 = Math.sin(alpha * Math.PI / 180) * c2;
                b2 = Math.sin(beta * Math.PI / 180) * c2;   

                aktuelleWaffe.tragen(getX() + (int)a2 , getY() + (int)b2 , (int)blickWinkel);
            }
            if(a < 0 && b >= 0){
                a = a * -1;
                beta = Math.toDegrees(Math.asin(b / c));
                blickWinkel = (beta - 270) * -1 ;
                alpha = 180 - beta - gamma;

                a2 = Math.sin(alpha * Math.PI / 180) * c2;
                b2 = Math.sin(beta * Math.PI / 180) * c2;   

                aktuelleWaffe.tragen(getX() - (int)a2 , getY() + (int)b2 , (int)blickWinkel);
            }
            if(a <= 0 && b < 0){
                a = a * -1;
                b = b * -1;
                beta = Math.toDegrees(Math.asin(b / c));
                blickWinkel = beta + 270;
                alpha = 180 - beta - gamma;

                a2 = Math.sin(alpha * Math.PI / 180) * c2;
                b2 = Math.sin(beta * Math.PI / 180) * c2;   

                aktuelleWaffe.tragen(getX() - (int)a2 , getY() - (int)b2 , (int)blickWinkel);
            }
            if(a > 0 && b <= 0){
                b = b * -1;
                beta = Math.toDegrees(Math.asin(b / c));
                blickWinkel = (beta - 90) * -1 ;
                alpha = 180 - beta - gamma;

                a2 = Math.sin(alpha * Math.PI / 180) * c2;
                b2 = Math.sin(beta * Math.PI / 180) * c2;   

                aktuelleWaffe.tragen(getX() + (int)a2 , getY() - (int)b2 , (int)blickWinkel);
            }
        }
    }

    public void attacke(){
        if(Greenfoot.isKeyDown("space")){
            aktuelleWaffe.attacke((int)blickWinkel);
        }
    }

    public void waffenWechsel(){
        Doomsday p = new Doomsday();
        aktuelleWaffe = p;
        getWorld().addObject(p ,getX() ,getY() );
    }

    private void bewegen(){
        if(Greenfoot.isKeyDown("w"))
            setLocation(getX(), getY() - 3);
        if(Greenfoot.isKeyDown("s"))
            setLocation(getX(), getY() + 3);
        if(Greenfoot.isKeyDown("a"))
            setLocation(getX() - 3, getY());
        if(Greenfoot.isKeyDown("d"))
            setLocation(getX() + 3, getY());
    }
}
