
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Date;
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
public class AddReceptionist {
    String stUserName,stPassword, stCfmPassword,stFName, stLName,stGender,stPhone,stHouseNo,stCity,stSal,stZip,stDOB;
    int numSal,numZip;
    Boolean boolShift;
    Date dtDOB;
    //
    JLabel lbUserName, lbPassword,lbCfmPassword, lbFName,lbLName,lbSal,lbDOB,lbGender,lbPhone,lbHouse,
            lbCity,lbZip,lbShift,msgText;
    JTextField tfUserName, tfFName,tfLName,tfSal,tfDOB,tfPhone,tfHouse
            ,tfCity,tfZip;
    JPasswordField tfPassword,tfCfmPassword;
    
    JFrame rptInputFrame;
    JPanel btnPanel,inputPanel,msgPanel;
    JButton btnBack,btnCreate;
    JComboBox<String> shift,cbGender;
    String shiftTime[] = {"DAY","NIGHT"}, genderStr[] = {"MALE","FEMALE"};
    public AddReceptionist()
    {
        initAddReceptGUI();
    }
    
    public void initAddReceptGUI()
    {
        rptInputFrame=new JFrame("Add Receptionist");
        rptInputFrame.setLayout(new BorderLayout());
        
        
        msgText = new JLabel("Add Receptionist");
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
        
        inputPanel=new JPanel(new GridLayout(13,2));
        
        lbUserName = new JLabel("Username:");
        Font ft2= btnCreate.getFont().deriveFont(Font.PLAIN,20f);
        lbUserName.setFont(ft2);
        tfUserName= new JTextField(15);
        tfUserName.setFont(ft2);
        
        inputPanel.add(lbUserName);
        inputPanel.add(tfUserName);
        
        
        lbPassword = new JLabel("Password:");
        lbPassword.setFont(ft2);
        tfPassword=new JPasswordField(15);
        tfPassword.setFont(ft2);
        
        inputPanel.add(lbPassword);
        inputPanel.add(tfPassword);
        
        
        lbCfmPassword = new JLabel("Confirm Password:");
        lbCfmPassword.setFont(ft2);
        tfCfmPassword=new JPasswordField(15);
        tfCfmPassword.setFont(ft2);
        
        inputPanel.add(lbCfmPassword);
        inputPanel.add(tfCfmPassword);
        
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
        
        
        rptInputFrame.add(msgPanel, BorderLayout.NORTH);
        rptInputFrame.add(inputPanel, BorderLayout.CENTER);
        rptInputFrame.add(btnPanel, BorderLayout.SOUTH);
        
        rptInputFrame.setSize(700,700);
        rptInputFrame.setLocationRelativeTo(null);
        rptInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rptInputFrame.setResizable(false);
    }
}
