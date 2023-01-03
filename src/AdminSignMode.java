
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
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
public class AdminSignMode {
    JFrame adminSignInFrame, adminSignUpFrame;
    JLabel admUsername,admPassword,textMode,space;
    JTextField tfAdm,tfAdmSU;
    JPasswordField tfPswd,tfPswdSU, tfPswdConfirm;
    JButton btnOKAY, btnBACK, btnSignUp;
    JPanel signInCmpPanel,signInPanel, btnPanel,northPanel,signUpPanel;
    
    //----------------------------------
    JLabel SUMode, SUConfirmPass,admUsername2,admPassword2;
    JButton btnDONE,btnBCK;
    JPanel signUPComponent, btnSUPanel, SUModePanel; 
    
    public AdminSignMode()
    {
        initAdminSignGUI();
    }
    
    public void initAdminSignGUI()
    {
        adminSignInFrame = new JFrame("SIGN IN");
        adminSignInFrame.setLayout(new BorderLayout());
        
         space = new JLabel("----------------------------------------------------------------------------------------");
         space.setHorizontalAlignment(SwingConstants.CENTER);
         admUsername = new JLabel("Username: ");
        admPassword = new JLabel("Password: ");
        
        admUsername.setHorizontalAlignment(SwingConstants.CENTER);
        admPassword.setHorizontalAlignment(SwingConstants.CENTER);
        tfAdm = new JTextField(25);
        tfPswd = new JPasswordField(25);
        btnBACK= new JButton("BACK");
        btnBACK.setFocusable(false);
        
        btnOKAY= new JButton("OKAY");
        btnOKAY.setFocusable(false);
        
        btnSignUp=new JButton("SIGN UP");
        btnSignUp.setFocusable(false);
        
        btnBACK.setBorderPainted(false);
        btnBACK.setBackground(Color.white);
        btnOKAY.setBorderPainted(false);
        btnOKAY.setBackground(Color.white);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setBackground(Color.white);
   
        
        Font ft1= btnBACK.getFont().deriveFont(Font.PLAIN,25f);
        btnBACK.setFont(ft1);
        btnOKAY.setFont(ft1);
        btnSignUp.setFont(ft1);
        admUsername.setFont(ft1);
        tfAdm.setFont(ft1);
        admPassword.setFont(ft1);
        tfPswd.setFont(ft1);
        
        
        signInPanel = new JPanel(new GridLayout(4,1)); 
        signInPanel.add(admUsername);
        signInPanel.add(tfAdm);
//        signInPanel.add(space);       
        signInPanel.add(admPassword);
        signInPanel.add(tfPswd);  
  //      signInPanel.add(space);       
     
        btnPanel = new JPanel(new FlowLayout(1,5,20));
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
        signUpPanel = new JPanel(new BorderLayout());
        signUpPanel.add(btnSignUp, BorderLayout.CENTER);
        signUpPanel.setLayout(new FlowLayout(1,0,10));
      
        adminSignInFrame.add(northPanel, BorderLayout.NORTH);
        adminSignInFrame.add(signInCmpPanel, BorderLayout.CENTER);
        adminSignInFrame.add(signUpPanel, BorderLayout.SOUTH);
        
        
        adminSignInFrame.setSize(550,450);
        adminSignInFrame.setLocationRelativeTo(null);
        adminSignInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminSignInFrame.setResizable(false);
        
        //-------------------------------------------------------------------------
        
        adminSignUpFrame = new JFrame("SIGN UP");
        adminSignUpFrame.setLayout(new BorderLayout());
        
        SUMode = new JLabel("SIGN UP");
        SUMode.setFont(ft);
        SUModePanel = new JPanel(new GridLayout(2,1));
        SUModePanel.add(SUMode);
        SUModePanel.add(space);
        SUMode.setHorizontalAlignment(SwingConstants.CENTER);
        signUPComponent = new JPanel(new GridLayout(6,1));
        tfAdmSU = new JTextField(25);
        tfPswdSU = new JPasswordField(25);
        tfPswdConfirm = new JPasswordField(25);
        SUConfirmPass= new JLabel("Confirm Password: ");
        admUsername2 = new JLabel("Username: ");
        admPassword2 = new JLabel("Password: ");
        
        tfAdmSU.setFont(ft1);
        tfPswdSU.setFont(ft1);
        tfPswdConfirm.setFont(ft1);
        SUConfirmPass.setFont(ft1);
        admUsername2.setFont(ft1);
        admPassword2.setFont(ft1);
        
        signUPComponent.add(admUsername2);
        signUPComponent.add(tfAdmSU);
        
        signUPComponent.add(admPassword2);
        signUPComponent.add(tfPswdSU);
        
        signUPComponent.add(SUConfirmPass);
        signUPComponent.add(tfPswdConfirm);
        
        
        btnDONE= new JButton("DONE");
        btnDONE.setFocusable(false);
        btnDONE.setFont(ft1);
        btnDONE.setBorderPainted(false);
        btnDONE.setBackground(Color.white);
   
        btnBCK=new JButton("BACK ");
        btnBCK.setFocusable(false);
        btnBCK.setFont(ft1);
        btnBCK.setBorderPainted(false);
        btnBCK.setBackground(Color.white);
   
        btnSUPanel = new JPanel(new FlowLayout(1,5,30));
        btnSUPanel.add(btnDONE);
        btnSUPanel.add(btnBCK);
        adminSignUpFrame.add(SUModePanel, BorderLayout.NORTH);
        adminSignUpFrame.add(signUPComponent, BorderLayout.CENTER);
        adminSignUpFrame.add(btnSUPanel, BorderLayout.SOUTH);
        
        adminSignUpFrame.setSize(550,500);
        adminSignUpFrame.setLocationRelativeTo(null);
        adminSignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminSignUpFrame.setResizable(false);
   //     adminSignInFrame.setVisible(true);
     //   adminSignUpFrame.setVisible(true);
    }
}
