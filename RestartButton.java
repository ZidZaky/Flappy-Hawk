import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RestartButton extends Actor {
    public RestartButton() {
        setImage(new GreenfootImage("restart-button.png"));  // Ensure you have this image in your images folder
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            FlappyWorld world = (FlappyWorld) getWorld();
            world.resetGame();  // Reset the game instead of creating a new world
        }
    }
}
