import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spieler extends Actor implements Treffbar
{
    int leben;
    int ausdauer;
    int erholen;
    int x;
    int y;
    double blickWinkel;

    Hellebarde hellebarde = new Hellebarde();
    Laserphaser laserPhaser = new Laserphaser();
    Doomsday doomsday = new Doomsday();
    KleineImpressionAusDemChinaRestaraunt staebchen;
    EricClapThat eric = new EricClapThat();
    Waffen aktuelleWaffe; 
    Actor waffe;

    public Spieler(){
        setImage("CharakterV.png");
        blickWinkel = 1;
        leben=10000;
        ausdauer = 100;
    }

    public void act() 
    {
        x = getX();
        y = getY();
        text();
        bewegen();
        waffenWechsel();
        if(aktuelleWaffe !=  null){
            kreis();
            attacke();
        }

    } 

    public void text(){
        getWorld().showText("Leben: "+leben,100,100);
        getWorld().showText("Ausdauer: "+ausdauer,100, 150);
        if(leben<=0){
            getWorld().showText("GAME OVER",getWorld().getWidth()/2,getWorld().getHeight()/2);
            Greenfoot.stop();
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
            double alpha;
            double beta;
            double a2 ;
            double b2; 
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
            if(aktuelleWaffe == staebchen){
                aktuelleWaffe = null;
                waffe = null;
            }
        }

    }

    public void waffenWechsel(){
        if(Greenfoot.isKeyDown("1") || Greenfoot.isKeyDown("2") || Greenfoot.isKeyDown("3") || Greenfoot.isKeyDown("4") || Greenfoot.isKeyDown("5") ){
            if (aktuelleWaffe != null){
                getWorld().removeObject(waffe);
            }
        }
        if (Greenfoot.isKeyDown("1")){
            waffe = hellebarde;
            aktuelleWaffe = hellebarde;
            getWorld().addObject(waffe,getX(),getY());
        }
        if (Greenfoot.isKeyDown("2")){
            waffe = laserPhaser;
            aktuelleWaffe = laserPhaser;
            getWorld().addObject(waffe,getX(),getY());
        }
        if (Greenfoot.isKeyDown("3")){
            waffe = doomsday;
            aktuelleWaffe = doomsday;
            getWorld().addObject(waffe,getX(),getY());
        }
        if (Greenfoot.isKeyDown("4")){
            waffe = eric;
            aktuelleWaffe = eric;
            getWorld().addObject(waffe,getX(),getY());
        }
        if (Greenfoot.isKeyDown("5")){
            staebchen = new KleineImpressionAusDemChinaRestaraunt();
            waffe = staebchen;
            aktuelleWaffe = staebchen;
            getWorld().addObject(waffe,getX(),getY());
        }
    }

    private void bewegen(){
        if(Greenfoot.isKeyDown("w")){
            if (Greenfoot.isKeyDown("shift") && ausdauer != 0)
                setLocation(getX(), getY() - 7);
            else
                setLocation(getX(), getY() - 3);
            setImage("CharakterH.png");
        }
        if(Greenfoot.isKeyDown("s")){
            if (Greenfoot.isKeyDown("shift") && ausdauer != 0)
                setLocation(getX(), getY() + 7);
            else
                setLocation(getX(), getY() + 3);
            setImage("CharakterV.png");
        }
        if(Greenfoot.isKeyDown("a")){
            if (Greenfoot.isKeyDown("shift") && ausdauer != 0)
                setLocation(getX() - 7, getY());
            else
                setLocation(getX() - 3, getY());
            setImage("CharakterL.png");
        }
        if(Greenfoot.isKeyDown("d")){
            if (Greenfoot.isKeyDown("shift") && ausdauer != 0)
                setLocation(getX() + 7, getY());
            else
                setLocation(getX() + 3, getY());
            setImage("CharakterR.png");
        }

        if (erholen == 0){
            if (ausdauer != 0 && Greenfoot.isKeyDown("shift"))
                ausdauer--;
            if (ausdauer == 0)
                erholen = 50;
            if (!Greenfoot.isKeyDown("shift") && ausdauer <= 99){
                ausdauer++;
            }
        }
        else
            erholen--;
    }
}
