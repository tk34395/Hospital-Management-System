
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddNurse {
    JLabel lbFName,lbLName,lbSal,lbDOB,lbGender,lbPhone,lbHouse,lbWard,
            lbCity,lbZip,lbShift,msgText;
    JTextField tfFName,tfLName,tfSal,tfDOB,tfPhone,tfHouse,tfCity,tfZip;
    
    JFrame nurseInputFrame;
    JPanel btnPanel,inputPanel,msgPanel;
    JButton btnBack,btnCreate;
    JComboBox<String> shift,cbGender,wardNo;
    String shiftTime[] = {"DAY","NIGHT"}, genderStr[] = {"MALE","FEMALE"};
    String wardStr[];
    ClinicController HC;
    public AddNurse(ClinicController refgHC)
    {
        HC=refgHC;
        initAddNurseGUI();
    }
    
    public void initAddNurseGUI()
    {
        nurseInputFrame=new JFrame("Add Nurse");
        nurseInputFrame.setLayout(new BorderLayout());
        
        
        msgText = new JLabel("Add Nurse");
        Font ft3= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft3);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        //-----------------------------------------
        btnPanel=new JPanel(new FlowLayout(1,50,10));
        btnCreate= new JButton("CREATE");
        btnCreate.setFocusable(false);
        
        Font ft1= btnCreate.getFont().deriveFont(Font.PLAIN,25f);
        btnCreate.setFont(ft1);
        
        btnBack=new JButton("BACK");
        btnBack.setFocusable(false);
        btnBack.setFont(ft1);
        
        btnPanel.add(btnBack);
        btnPanel.add(btnCreate);
        
        //-------------------------------------
        
        inputPanel=new JPanel(new GridLayout(11,2));
        
        Font ft2= btnCreate.getFont().deriveFont(Font.PLAIN,20f);
        
        lbFName = new JLabel("First Name:");
        lbFName.setFont(ft2);
        tfFName=new JTextField(15);
        tfFName.setFont(ft2);
        
        inputPanel.add(lbFName);
        inputPanel.add(tfFName);
        
        
        lbLName = new JLabel("Last Name:");
        lbLName.setFont(ft2);
        tfLName=new JTextField(15);
        tfLName.setFont(ft2);
        
        inputPanel.add(lbLName);
        inputPanel.add(tfLName);
        
        int totalWards = HC.dbMgr.countWards();
        HC.dbMgr.getWardsNo();

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
        
        
        lbSal = new JLabel("Salary:");
        lbSal.setFont(ft2);
        tfSal=new JTextField(15);
        tfSal.setFont(ft2);
        
        inputPanel.add(lbSal);
        inputPanel.add(tfSal);
        
        
        lbDOB = new JLabel("Date of Birth(YYYY-MM-DD):");
        lbDOB.setFont(ft2);
        tfDOB=new JTextField(15);
        tfDOB.setFont(ft2);
        
        inputPanel.add(lbDOB);
        inputPanel.add(tfDOB);
        
        
        lbGender = new JLabel("Gender:");
        lbGender.setFont(ft2);
        cbGender=new JComboBox<>(genderStr);
        cbGender.setFont(ft2);
        
        inputPanel.add(lbGender);
        inputPanel.add(cbGender);
        
        lbPhone = new JLabel("Phone No:");
        lbPhone.setFont(ft2);
        tfPhone=new JTextField(15);
        tfPhone.setFont(ft2);
        
        inputPanel.add(lbPhone);
        inputPanel.add(tfPhone);
        
        lbHouse = new JLabel("House No:");
        lbHouse.setFont(ft2);
        tfHouse=new JTextField(15);
        tfHouse.setFont(ft2);
        
        inputPanel.add(lbHouse);
        inputPanel.add(tfHouse);
        
        
        lbCity = new JLabel("City:");
        lbCity.setFont(ft2);
        tfCity=new JTextField(15);
        tfCity.setFont(ft2);
        
        inputPanel.add(lbCity);
        inputPanel.add(tfCity);
        
        lbZip = new JLabel("ZIP:");
        lbZip.setFont(ft2);
        tfZip=new JTextField(15);
        tfZip.setFont(ft2);
        
        inputPanel.add(lbZip);
        inputPanel.add(tfZip);
        
        lbShift = new JLabel("Shift:");
        lbShift.setFont(ft2);
        shift=new JComboBox<>(shiftTime);
        shift.setFont(ft2);
        
        inputPanel.add(lbShift);
        inputPanel.add(shift);
        
        
        nurseInputFrame.add(msgPanel, BorderLayout.NORTH);
        nurseInputFrame.add(inputPanel, BorderLayout.CENTER);
        nurseInputFrame.add(btnPanel, BorderLayout.SOUTH);
        
        nurseInputFrame.setSize(700,700);
        nurseInputFrame.setLocationRelativeTo(null);
        nurseInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nurseInputFrame.setResizable(false);
    }
}
