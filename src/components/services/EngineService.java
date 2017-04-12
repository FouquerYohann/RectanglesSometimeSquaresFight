package components.services;

public interface EngineService {
    public int getHeight();
    public int getWidth();
    public FighterService getChar(int i);
    public PlayerService getPlayer(int i);
    public void init(int height,int width,int distance, PlayerService p1, PlayerService p2);
//    public void step(Commande comP1,Commande comP2);
}
