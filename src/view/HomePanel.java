package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HomePanel extends JPanel
{
    public BufferedImage image;

    public HomePanel()
    {
    	Home();
    }

    public void paintComponent(Graphics g)
    {
        Font fff = new Font("Calibri", Font.PLAIN, 15);
        Color ccc = Color.GRAY;
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        g.setColor(ccc);
        g.setFont(fff);
        g.drawString("Copyright © 2021, All rights reserved.", this.getWidth()/4*3-90,this.getHeight()-10);
    }
    
    private void Home()
    {
        try
        {
            image = ImageIO.read(new File("src/images/BackG.png"));
        }
        catch (IOException e)
        {
            //Not handled.
        }
        
        //font and color

        Font ff = new Font("Calibri", Font.PLAIN, 25);
        Color cc = new Color(66, 134, 244);

        
        //add borders to panels
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(cc),"Welcome"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(cc);
    }
}
