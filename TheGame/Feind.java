public interface Feind extends Treffbar 
{
    //100-1000 leben
    //public void damage(int schaden);
    public void attack();

    public void move();

    public void healthBar();

    public void regHealth();

    public void damage(int s);
}
