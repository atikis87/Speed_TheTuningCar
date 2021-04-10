package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class ExitPanel extends JPanel
{
    private BufferedImage imageExit;
    private JButton okButton;
   
    //CONSTRUCTOR
	public ExitPanel()
	{
		exitUI();
	}

	private void exitUI()
	{
        try
        {
            imageExit = ImageIO.read(new File("src/images/exit_Back2.png"));
        }
        catch (IOException e){};	
        
        //font and color
        Font f = new Font("Times New Roman", Font.PLAIN, 15);
        Font ff = new Font("Calibri", Font.PLAIN, 25);
        Color myBlue = new Color(66, 134, 244);
        Color white = Color.white;

        //ADD PANEL AND LABEL
        JPanel messagePanel = new JPanel();
        JLabel mLabel = new JLabel();
        mLabel.setText("<html>&#32; Do you really want to exit the 'Speed The Tuning Car' application? &#32;</html>");
        mLabel.setFont(new Font("Calibri",3,20));
        JLabel mLabel2 = new JLabel();
        JLabel mLabel3 = new JLabel("Click the button");
        mLabel3.setFont(new Font("Calibri",2,18));
        messagePanel.setBorder(new LineBorder(myBlue, 3, true));

        // ADD BUTTON
        this.okButton = new JButton("Bye Bye");
        this.okButton.setFont(f);
        this.okButton.setForeground(myBlue);
        this.okButton.setBackground(white);

        messagePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        messagePanel.add(mLabel,gbc);
        messagePanel.add(mLabel2, gbc);
        gbc.insets = new Insets(30, 0, 0, 0);
        messagePanel.add(okButton,gbc);
        messagePanel.add(mLabel3,gbc);

        // SET ICONS ==================================================
        ImageIcon ok = new ImageIcon("src/images/bye.PNG");
        this.okButton.setIcon(ok);
        ImageIcon arrow = new ImageIcon("src/images/bottom_arrow.PNG");
        mLabel2.setIcon(arrow);

        //ADD BORDER TO PANELS
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(myBlue),"Exit from Speed The Tuning Car"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(myBlue);
        this.add(messagePanel);

	}
	
    public void paintComponent(Graphics g)
    {
        g.drawImage(imageExit, 0, 0, getWidth(), getHeight(), this);
    }

    //GETTER
    
    public JButton getOkButton()
    {
        return okButton;
    }

}
