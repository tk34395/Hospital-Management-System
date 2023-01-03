
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class AddBed {
    JLabel lbType,lbWard, msgText;
    JTextField tfType;
    JComboBox<String> wardNo;
    String[] wardStr;
    
    JFrame bedInputFrame;
    JPanel btnPanel,inputPanel,msgPanel;
    JButton btnBack,btnAdd;
    
    ClinicController HC;
    
    public AddBed(ClinicController refgC)
    {
        HC=refgC;
        initAddBedGUI();
    }
    
    public void initAddBedGUI()
    {
        bedInputFrame=new JFrame("Add Bed");
        bedInputFrame.setLayout(new BorderLayout());
        
        
        msgText = new JLabel("Add Bed");
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
        
        lbType = new JLabel("Bed Type:");
        Font ft2= btnAdd.getFont().deriveFont(Font.PLAIN,20f);
        lbType.setFont(ft2);
        tfType= new JTextField(15);
        tfType.setFont(ft1);
        
        inputPanel.add(lbType);
        inputPanel.add(tfType);
        
        
        int totalWards = HC.dbMgr.countWards();
        HC.dbMgr.getWardRecord();

        if(totalWards > 0)
        {
            wardStr = new String[totalWards];
            try {
                int count =0;
                while(HC.dbMgr.rs.next())
                {
                    wardStr[count]= HC.dbMgr.rs.getString("WRD_NO");
                    count++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddNurse.class.getName()).log(Level.SEVERE, null, ex);
            }
            wardNo = new JComboBox<>(wardStr);
        }
        else
        {
            wardStr = new String[1];
            wardStr[0]="null";
            wardNo = new JComboBox<>(wardStr);
        }
        
        lbWard = new JLabel("Select Ward:");
        lbWard.setFont(ft2);
        wardNo.setFont(ft2);
        
        inputPanel.add(lbWard);
        inputPanel.add(wardNo);
        
        lbWard = new JLabel("Ward Charges:");
        lbWard.setFont(ft2);
        
        
        bedInputFrame.add(msgPanel, BorderLayout.NORTH);
        bedInputFrame.add(inputPanel, BorderLayout.CENTER);
        bedInputFrame.add(btnPanel, BorderLayout.SOUTH);
        
        bedInputFrame.setVisible(true);
        bedInputFrame.setSize(700,300);
        bedInputFrame.setLocationRelativeTo(null);
        bedInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bedInputFrame.setResizable(false);
    }
}
