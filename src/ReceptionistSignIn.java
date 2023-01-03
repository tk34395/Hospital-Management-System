
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
public class ReceptionistSignIn {
    JFrame rptSignInFrame;
    JLabel rptUsername,rptPassword,textMode,space;
    JTextField tfRpt;
    JPasswordField tfPswd;
    JButton btnOKAY, btnBACK;
    JPanel signInCmpPanel,signInPanel, btnPanel,northPanel;
    
    public ReceptionistSignIn()
    {
        initAdminSignGUI();
    }
    
    public void initAdminSignGUI()
    {
        rptSignInFrame = new JFrame("Receptionist SIGN IN");
        rptSignInFrame.setLayout(new BorderLayout());
        
        space = new JLabel("----------------------------------------------------------------------------------------");
        space.setHorizontalAlignment(SwingConstants.CENTER);
  
        rptUsername = new JLabel("Username: ");
        rptPassword = new JLabel("Password: ");
        
        tfRpt = new JTextField(25);
        tfPswd = new JPasswordField(25);
        rptUsername.setHorizontalAlignment(SwingConstants.CENTER);
        rptPassword.setHorizontalAlignment(SwingConstants.CENTER);
     
        
        btnBACK= new JButton("BACK");
        btnBACK.setFocusable(false);
        
        btnOKAY= new JButton("OKAY");
        btnOKAY.setFocusable(false);
        
       
        
        Font ft1= btnBACK.getFont().deriveFont(Font.PLAIN,25f);
        btnBACK.setFont(ft1);
        btnOKAY.setFont(ft1);
        rptUsername.setFont(ft1);
        tfRpt.setFont(ft1);
        rptPassword.setFont(ft1);
        tfPswd.setFont(ft1);
        btnBACK.setBorderPainted(false);
        btnBACK.setBackground(Color.white);
        btnOKAY.setBorderPainted(false);
        btnOKAY.setBackground(Color.white);

        
        signInPanel = new JPanel(new GridLayout(4,1));
        signInPanel.add(rptUsername);
        signInPanel.add(tfRpt);
        signInPanel.add(rptPassword);
        signInPanel.add(tfPswd);
        
        btnPanel = new JPanel(new FlowLayout(1,5,30));
        btnPanel.add(btnOKAY);
        btnPanel.add(btnBACK);
        
        signInCmpPanel = new JPanel(new BorderLayout());
        signInCmpPanel.add(signInPanel, BorderLayout.CENTER);
        signInCmpPanel.add(btnPanel, BorderLayout.SOUTH);
        
        
        textMode= new JLabel("SIGN IN ");
        Font ft= btnBACK.getFont().deriveFont(Font.PLAIN,35f);
        textMode.setFont(ft);
        textMode.setHorizontalAlignment(SwingConstants.CENTER);
     
       northPanel= new JPanel(new GridLayout(2,1));
        northPanel.add(textMode);
        northPanel.add(space);       
        
        rptSignInFrame.add(northPanel, BorderLayout.NORTH);
        rptSignInFrame.add(signInCmpPanel, BorderLayout.CENTER);
        
        rptSignInFrame.setSize(550,390);
        rptSignInFrame.setLocationRelativeTo(null);
        rptSignInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rptSignInFrame.setResizable(false);
  //      rptSignInFrame.setVisible(true);
    }
}
