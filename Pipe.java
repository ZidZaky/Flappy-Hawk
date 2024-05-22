import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pipe extends Actor
{
    public Pipe(){
        GreenfootImage image = getImage();
        image.scale(512, 900);
    }
    public void act() 
    {
        
        FlappyWorld world = (FlappyWorld) getWorld();
        if (world.isPaused()) return;  // Skip the rest of the act method if the game is paused
        
        if(Player.isAlive()){
            setLocation(getX() - 1, getY());
        }
        if(getX() <= 1){
            setLocation(getX() + 700, 75 + Greenfoot.getRandomNumber(225));
        }
    }
}
