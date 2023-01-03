
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class AddWard {
    JLabel lbCapacity,lbCharges, msgText;
    JTextField tfCapacity,tfCharges;
    
    JFrame wardInputFrame;
    JPanel btnPanel,inputPanel,msgPanel;
    JButton btnBack,btnAdd;
    public AddWard()
    {
        initAddWardGUI();
    }
    
    public void initAddWardGUI()
    {
        wardInputFrame=new JFrame("Add Ward");
        wardInputFrame.setLayout(new BorderLayout());
        
        
        msgText = new JLabel("Add Ward");
        Font ft3= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft3);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        //-----------------------------------------
        btnPanel=new JPanel(new FlowLayout(1,50,10));
        btnAdd= new JButton("ADD");
        btnAdd.setFocusable(false);
        
        Font ft1= btnAdd.getFont().deriveFont(Font.PLAIN,25f);
        btnAdd.setFont(ft1);
        
        btnBack=new JButton("BACK");
        btnBack.setFocusable(false);
        btnBack.setFont(ft1);
        
        btnPanel.add(btnBack);
        btnPanel.add(btnAdd);
        
        //-------------------------------------
        
        inputPanel=new JPanel(new GridLayout(2,2));
        
        lbCapacity = new JLabel("Ward Capacity:");
        Font ft2= btnAdd.getFont().deriveFont(Font.PLAIN,20f);
        lbCapacity.setFont(ft2);
        tfCapacity= new JTextField(15);
        tfCapacity.setFont(ft1);
        
        inputPanel.add(lbCapacity);
        inputPanel.add(tfCapacity);
        
        
        lbCharges = new JLabel("Ward Charges:");
        lbCharges.setFont(ft2);
        tfCharges=new JTextField(15);
        tfCharges.setFont(ft1);
        
        inputPanel.add(lbCharges);
        inputPanel.add(tfCharges);
        
        
        wardInputFrame.add(msgPanel, BorderLayout.NORTH);
        wardInputFrame.add(inputPanel, BorderLayout.CENTER);
        wardInputFrame.add(btnPanel, BorderLayout.SOUTH);
        
        wardInputFrame.setVisible(true);
        wardInputFrame.setSize(700,300);
        wardInputFrame.setLocationRelativeTo(null);
        wardInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wardInputFrame.setResizable(false);
    }
}
