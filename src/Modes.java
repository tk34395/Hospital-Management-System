
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class Modes {
    
    JFrame modeFrame;
    JButton admMode,rptMode, exitBtn;
    JLabel welcomeLabel,modeLabel;
    JPanel welcomePanel,mainPanel, btnPanel, exitPanel;
    
    public Modes()
    {
        initModeGUI();
    }
    
    public void initModeGUI()
    {
        modeFrame = new JFrame("HOSPITAL");
        modeFrame.setLayout(new BorderLayout());
   
        welcomeLabel = new JLabel("Welcome to Hospital");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        modeLabel = new JLabel("Select a mode");
        modeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        modeLabel.setForeground(Color.WHITE);
        mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(modeLabel, BorderLayout.NORTH);
                   
        ImageIcon icon;
        Image img, newimg;
        icon = new ImageIcon("admin.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

        admMode = new JButton("Administrator Mode", icon);
        admMode.setFocusable(false);
        admMode.setBackground(Color.white);
        admMode.setVerticalTextPosition(admMode.TOP);
        admMode.setHorizontalTextPosition(SwingConstants.CENTER);      
        admMode.setPreferredSize(new Dimension(285, 240));
        admMode.setBorderPainted(false);
   
        icon = new ImageIcon("recep.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);  
        rptMode = new JButton("Receptionist Mode",icon);
        rptMode.setFocusable(false);                
        rptMode.setBorderPainted(false);
        rptMode.setBackground(Color.white);
        rptMode.setVerticalTextPosition(admMode.TOP);
        rptMode.setHorizontalTextPosition(SwingConstants.CENTER);      
        rptMode.setPreferredSize(new Dimension(285, 240));
                    
        exitBtn= new JButton("EXIT");
        exitBtn.setFocusable(false);
        exitBtn.setPreferredSize(new Dimension(185, 80));
        exitBtn.setBackground(Color.white);                  
        exitBtn.setBorderPainted(false);
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(1,10,70));
        btnPanel.add(admMode);
        btnPanel.add(rptMode);
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(1,8,30));
        exitPanel.add(exitBtn);
        mainPanel.add(exitPanel,BorderLayout.SOUTH);
        mainPanel.setBackground(Color.BLACK);
        welcomePanel.setBackground(Color.BLACK);

        btnPanel.setBackground(Color.BLACK);
        exitPanel.setBackground(Color.BLACK);
        
        //Font Adjustment:
        Font ft1= welcomeLabel.getFont().deriveFont(Font.PLAIN,50f);
        welcomeLabel.setFont(ft1);
        
        Font ft2= modeLabel.getFont().deriveFont(Font.PLAIN,30f);
        modeLabel.setFont(ft2);
        exitBtn.setFont(ft2);
        Font ft3= admMode.getFont().deriveFont(Font.PLAIN,25f);
        admMode.setFont(ft3);
        rptMode.setFont(ft3);
        modeFrame.getContentPane().setBackground(Color.gray);
        
        //Add component into Frame:
        modeFrame.add(welcomePanel, BorderLayout.NORTH);
        modeFrame.add(mainPanel, BorderLayout.CENTER);
        modeFrame.setSize(750,600);
        modeFrame.setLocationRelativeTo(null);
       // modeFrame.setVisible(true);
        modeFrame.setResizable(false);
        modeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
