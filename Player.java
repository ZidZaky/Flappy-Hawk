import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor {
    private final double FLAP = 1.8;
    private boolean oldSpace = false;
    private double yVel = 0;
    private double y = 300;
    private boolean oldTouchingPipe = false;
    private static boolean dead;

    public Player(double yVel) {
        GreenfootImage image = getImage();
        image.scale(46, 34);
        dead = false;
        this.yVel = yVel;
    }

    public Player() {
        this(0);
    }

    public void act() {
        if (((FlappyWorld) getWorld()).isPaused()) return;

        yVel += 0.02;
        if (spacePressed()) {
            yVel = -FLAP;
        }
        y += yVel;
        setLocation(getX(), y);
        setRotation((int)(yVel * 16));
        if (isAtEdge()) {
            dead = true;
        }

        boolean touchingPipe = false;
        for (Pipe pipe : getWorld().getObjects(Pipe.class)) {
            if (Math.abs(pipe.getX() - getX()) < 40) {
                if (Math.abs(pipe.getY() + 30 - getY()) > 37) {
                    dead = true;
                }
                touchingPipe = true;
            }
        }
        
        oldTouchingPipe = touchingPipe;

        if (dead) {
            FlappyWorld myWorld = (FlappyWorld) getWorld();
            myWorld.gameOver();
            getWorld().removeObject(this);
        }
    }

    public boolean spacePressed() {
        boolean pressed = false;
        if (Greenfoot.isKeyDown("space")) {
            if (!oldSpace) {
                pressed = true;
            }
            oldSpace = true;
        } else {
            oldSpace = false;
        }
        return pressed;
    }

    public static boolean isAlive() {
        return !dead;
    }

    public void setLocation(double x, double y) {
        super.setLocation((int) x, (int) y);
    }
}
