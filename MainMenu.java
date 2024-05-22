import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    public MainMenu(){
        super(600, 400, 1);
        setBackground(new GreenfootImage("menu-background.png"));
        addObject(new StartButton(), 300, 200);
    }
}

