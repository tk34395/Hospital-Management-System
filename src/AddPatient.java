
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
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
public class AddPatient {
    JLabel lbFName,lbLName,lbDisease,lbDOB,lbGender,lbPhone,lbHouse,
            lbCity,lbZip,lbShift,msgText;
    JTextField tfFName,tfDisease,tfLName,tfDOB,tfPhone,tfHouse,tfCity,tfZip;
    
    JFrame patientInputFrame;
    JPanel btnPanel,inputPanel,msgPanel;
    JButton btnBack,btnAdd;
    JComboBox<String> cbGender;
    String  genderStr[] = {"MALE","FEMALE"};
    public AddPatient()
    {
        initAddPatientGUI();
    }
    
    public void initAddPatientGUI()
    {
        patientInputFrame=new JFrame("Add Patient");
        patientInputFrame.setLayout(new BorderLayout());
        
        
        msgText = new JLabel("Add Patient");
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
        
        inputPanel=new JPanel(new GridLayout(10,2));
        
        Font ft2= btnAdd.getFont().deriveFont(Font.PLAIN,20f);
        
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
        
        
        lbDisease = new JLabel("Disease:");
        lbDisease.setFont(ft2);
        tfDisease=new JTextField(15);
        tfDisease.setFont(ft2);
        
        inputPanel.add(lbDisease);
        inputPanel.add(tfDisease);
        
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
        
        
        patientInputFrame.add(msgPanel, BorderLayout.NORTH);
        patientInputFrame.add(inputPanel, BorderLayout.CENTER);
        patientInputFrame.add(btnPanel, BorderLayout.SOUTH);
        
        patientInputFrame.setVisible(true);
        patientInputFrame.setSize(700,600);
        patientInputFrame.setLocationRelativeTo(null);
        patientInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        patientInputFrame.setResizable(false);
    }    
}
