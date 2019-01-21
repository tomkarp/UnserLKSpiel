
public interface Waffen  
{
    int winkel = 0;
    int cooldown = 0;
    
    public void attacke(int w); 
    public void zielen(int winkel);
    public void tragen(int x , int y , int winkel);
}
