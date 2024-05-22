import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class QuitButton extends Actor {
    public QuitButton() {
        setImage(new GreenfootImage("quit-button.png"));  // Ensure you have this image in your images folder
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            FlappyWorld world = (FlappyWorld) getWorld();
            world.MainMenu();  // Go back to the main menu
        }
    }
}
