import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FlappyWorld extends World {
    private boolean isPaused;
    private boolean inMainMenu;
    private QuitButton quitButton;
    private PauseButton pauseButton;

    public FlappyWorld() {
        super(600, 400, 1);
        quitButton = new QuitButton();
        pauseButton = new PauseButton();
        inMainMenu = true;
        MainMenu();
    }

    public void MainMenu() {
        setBackground(new GreenfootImage("menu-background.png"));
        removeObjects(getObjects(null));  // Remove all existing objects
        addObject(new StartButton(), 300, 270);
        inMainMenu = true;
    }

    public void startGame() {
        inMainMenu = false;
        isPaused = false;  // Ensure the game is not paused when starting
        setBackground(new GreenfootImage("new-background.png"));
        addObject(new Player(-1.3), 100, 300);
        addObject(new Pipe(), 300, 175);
        addObject(new Pipe(), 600, 175);
        addObject(pauseButton, 550, 50);
    }

    public void resetGame() {
        removeObjects(getObjects(null));  // Remove all objects
        startGame();  // Restart the game
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
        if (paused) {
            addObject(quitButton, 300, 350);  // Add the quit button when paused
        } else {
            removeObject(quitButton);  // Remove the quit button when unpaused
        }
    }

    public boolean isPaused() {
        return isPaused;
    }

    public boolean inMainMenu() {
        return inMainMenu;
    }

    public void act() {
        if (inMainMenu) return;
        if (isPaused) return;
        // rest of your world logic
    }

    public void gameOver() {
        addObject(new GameOver(), getWidth() / 2, 150);
        addObject(new RestartButton(), 250, 350);
        addObject(quitButton, 380, 350);
        removeObject(pauseButton);
    }
}
