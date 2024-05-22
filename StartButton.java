import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartButton extends Actor {
    public StartButton() {
        setImage(new GreenfootImage("start-button.png")); // Make sure you have the appropriate image file
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            FlappyWorld world = (FlappyWorld) getWorld();
            world.removeObjects(world.getObjects(null)); // Clear all objects
            world.startGame(); // Start the game
        }
    }
}
