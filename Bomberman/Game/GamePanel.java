package Game;

import AI.ShortestPathFinder;
import Entity.Entity;
import Entity.Player;
import Tile.TileManager;
import Objects.SuperObject;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Tiles Setting
    final int originalTileSize = 36;
    final int scale = 1;
    public final int tileSize = originalTileSize * scale;

    //Screen Setting
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 18;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int FPS = 60;

    //Game Component
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    public TileManager tileM = new TileManager(this);
    public BotSetter bSetter = new BotSetter(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public ShortestPathFinder pFinder = new ShortestPathFinder(this);
    public Player player = new Player(this, keyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Entity[] bot = new Entity[15];
    public SuperObject[] obj = new SuperObject[15];

    //Game Variables
    public int maxLevel = 3;
    public int level = 1;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
     public void setupGame() {
        bSetter.setBot();
        aSetter.setObject();
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    
    public void update() {
        player.update();

        if (!player.haveBomb) {
            player.bomb.update();
            if (player.bomb.bombTimer == 30) {
                player.bomb.explode = true;
            } else if (player.bomb.bombTimer < 0) {
                player.haveBomb = true;
            }
        }

        for (int i = 0; i < bot.length; i++) {
            if (bot[i] != null && cChecker.checkExplosion(bot[i])) {
                bot[i] = null;
            }
        }

        for (Entity entity : bot) {
            if (entity != null) {
                entity.update();
            }
        }
    }
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.drawBackground(g2);

        for (SuperObject object : obj) {
            if (object != null) {
                object.draw(g2, this);
            }
        }

        tileM.draw(g2);

        if (!player.haveBomb) {
            player.bomb.draw(g2);
        }

        for (Entity entity : bot) {
            if (entity != null) {
                entity.draw(g2, this);
            }
         }

        player.draw(g2);

        ui.draw(g2);

        g2.dispose();
    }
    
     public void changeLevel() {
        changeLevel(3);
    }

    public void changeLevel(int life) {
        aSetter.clearObjectList();
        bSetter.clearBotList();

        if (life <= 0) {
            tileM.loadMap("/Res/maps/lose.txt");
            player.setDefaultValues();
        } else if (level > 0 && level <= maxLevel) {
            setupGame();
            tileM.loadMap("/Res/maps/" + level + ".txt");
            player.setDefaultValues();
            player.life = life;

        } else if (level > maxLevel) {
            tileM.loadMap("/Res/maps/end.txt");
            player.setDefaultValues();

        }
    }
    
}
