import processing.core.*;

public class Hello extends PApplet
{
    public void settings()
    {
        size(400, 400); // must be in settings(), not setup()
    }

    public void setup()
    {
        x = -50;
    }

    public void draw()
    {
        background(0);
        ellipse(x, 200, 100, 50);

        x += 5;

        if (x > width + 50)
            x = -50;
    }

    private float x;

    public static void main(String[] args)
    {
        PApplet.main("Hello");
    }
}
