import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PauseButton extends Actor {
    private boolean paused = false;

    public PauseButton() {
        setImage(new GreenfootImage("pause-button.png"));  // Ensure you have this image in your images folder
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            paused = !paused;
            ((FlappyWorld) getWorld()).setPaused(paused);
            if (paused) {
                setImage(new GreenfootImage("play-button.png"));
            } else {
                setImage(new GreenfootImage("pause-button.png"));
            }
        }
    }
}
