import java.awt.*;
import java.applet.*;

/**
 *
 * @author siddharthsinghrathour
 */
public class Siddharth extends Applet
{
    @Override
    public void init()
    {
        setBackground(Color.red);
    }
    @Override
    public void paint(Graphics g)
    {
        int y=50,x=50;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if((i+j)%2!=0)
                {
                    g.setColor(Color.black);
                }
                else
                {
                    g.setColor(Color.white);
                }
                g.fillRect(x,y,50,50);
                x=x+50;
            }
            y=y+50;
            x=50;
        }
    }
}

