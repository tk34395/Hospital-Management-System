
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
public class AdminMode {
    
    JFrame optionFrame;
    JMenuBar optionSet;
    JMenu doctorOpt, receptionistOpt, viewPatient, nurseOpt,wardOpt,changeCredentials;
    JMenuItem docPersonalInfo, viewVRECDoc, addDoc,viewRec,addRec,addNurse,viewNurse,viewWard,addWard,
            addBedOpt,viewBedOpt,patientWardView, patientAptView,patientBill,patientInfo, 
            nameChange,passChange;
    JButton btnSignOut, dltAdmin;
    JPanel btnPanel, msgPanel;
    JLabel msgText,space;
    String admName,admPassword;
    
    public AdminMode(String admN, String admP)
    {
        admName=admN;
        admPassword=admP;
        
        initAdminMode();
    }
    
    public void initAdminMode()
    {
        optionFrame= new JFrame("Administrator Mode");
        optionFrame.setLayout(new BorderLayout());
        
        btnSignOut = new JButton("SIGN OUT");
        btnSignOut.setFocusable(false);
        btnSignOut.setBorderPainted(false);
        btnSignOut.setBackground(Color.LIGHT_GRAY);
        dltAdmin = new JButton("Deactiviate Me");
        dltAdmin.setFocusable(false);
        dltAdmin.setBorderPainted(false);
        dltAdmin.setBackground(Color.LIGHT_GRAY);

        space = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        space.setHorizontalAlignment(SwingConstants.CENTER);
 
        Font ft2= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        btnSignOut.setFont(ft2);
        dltAdmin.setFont(ft2);
        btnPanel = new JPanel(new FlowLayout(1,50,10));
        btnPanel.add(dltAdmin);
        btnPanel.add(btnSignOut);
        
        msgText = new JLabel("Administrator Mode");
        Font ft1= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft1);
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
        msgPanel = new JPanel(new GridLayout(2,1));
        msgPanel.add(msgText);
        msgPanel.add(space);
        msgPanel.setBackground(Color.WHITE);
        
        Font ft3= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        Font ft4= btnSignOut.getFont().deriveFont(Font.PLAIN,20f);

        optionSet = new JMenuBar();
        optionSet.setLayout(new GridLayout(2,3));
        optionSet.setBackground(Color.lightGray);
        
        doctorOpt= new JMenu("Doctor");
        doctorOpt.setFont(ft3);
        
        ImageIcon icon;
        Image img, newimg;
 
        icon = new ImageIcon("doctor.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        doctorOpt.setIcon(icon);
        doctorOpt.setFocusable(false);
        doctorOpt.setBackground(Color.white);
        doctorOpt.setVerticalTextPosition(doctorOpt.TOP);
        doctorOpt.setHorizontalTextPosition(SwingConstants.CENTER);      
        doctorOpt.setPreferredSize(new Dimension(285, 240));
        doctorOpt.setBorderPainted(false);

        
        docPersonalInfo = new JMenuItem("View Doctors Details");
        docPersonalInfo.setFont(ft4);
        //
        viewVRECDoc = new JMenuItem("View Visiting Record");
        viewVRECDoc.setFont(ft4);
        //
        addDoc = new JMenuItem("Add Doctor");
        addDoc.setFont(ft4);
       
        //
        doctorOpt.add(docPersonalInfo);
        doctorOpt.add(viewVRECDoc);
        doctorOpt.add(addDoc);
        
        
        nurseOpt = new JMenu("Nurse");
        nurseOpt.setFont(ft3);
        
        viewNurse = new JMenuItem("View Nurse");
        viewNurse.setFont(ft4);
        //
        addNurse = new JMenuItem("Add Nurse");
        addNurse.setFont(ft4);
        //
        nurseOpt.add(viewNurse);
        nurseOpt.add(addNurse);
         icon = new ImageIcon("nurse.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        nurseOpt.setIcon(icon);
        nurseOpt.setFocusable(false);
        nurseOpt.setBackground(Color.white);
        nurseOpt.setVerticalTextPosition(nurseOpt.TOP);
        nurseOpt.setHorizontalTextPosition(SwingConstants.CENTER);      
        nurseOpt.setPreferredSize(new Dimension(285, 240));
        nurseOpt.setBorderPainted(false);
      
        
        wardOpt= new JMenu("Ward");
        wardOpt.setFont(ft3);
        
        icon = new ImageIcon("ward.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        wardOpt.setIcon(icon);
        wardOpt.setFocusable(false);
        wardOpt.setBackground(Color.white);
        wardOpt.setVerticalTextPosition(wardOpt.TOP);
        wardOpt.setHorizontalTextPosition(SwingConstants.CENTER);      
        wardOpt.setPreferredSize(new Dimension(285, 240));
        wardOpt.setBorderPainted(false);
 
        addWard = new JMenuItem("Add Ward");
        addWard.setFont(ft4);
        //
        addBedOpt=new JMenuItem("Add Bed");
        addBedOpt.setFont(ft4);
        //
        viewWard = new JMenuItem("View Ward");
        viewWard.setFont(ft4);
        //
        viewBedOpt = new JMenuItem("View Bed Info");
        viewBedOpt.setFont(ft4);
        //
        wardOpt.add(viewWard);
        wardOpt.add(viewBedOpt);
        wardOpt.add(addWard);
        wardOpt.add(addBedOpt);
        
        receptionistOpt= new JMenu("Receptionist");
        receptionistOpt.setFont(ft3);
          icon = new ImageIcon("recept.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        receptionistOpt.setIcon(icon);
        receptionistOpt.setFocusable(false);
        receptionistOpt.setBackground(Color.white);
        receptionistOpt.setVerticalTextPosition(receptionistOpt.TOP);
        receptionistOpt.setHorizontalTextPosition(SwingConstants.CENTER);      
        receptionistOpt.setPreferredSize(new Dimension(285, 240));
        receptionistOpt.setBorderPainted(false);

        addRec=new JMenuItem("Add Receptionist");
        addRec.setFont(ft4);
        //
        viewRec = new JMenuItem("View Receptionist");
        viewRec.setFont(ft4);
        //
        receptionistOpt.add(viewRec);
        receptionistOpt.add(addRec);
        
        
        changeCredentials= new JMenu("Change Credentials");
        changeCredentials.setFont(ft3);
        icon = new ImageIcon("change.png");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        changeCredentials.setIcon(icon);
        changeCredentials.setFocusable(false);
        changeCredentials.setBackground(Color.white);
        changeCredentials.setVerticalTextPosition(changeCredentials.TOP);
        changeCredentials.setHorizontalTextPosition(SwingConstants.CENTER);      
        changeCredentials.setPreferredSize(new Dimension(285, 240));
        changeCredentials.setBorderPainted(false);
        
        nameChange = new JMenuItem("Change Username");
        nameChange.setFont(ft4);
        //
        passChange= new JMenuItem("Change Password");
        passChange.setFont(ft4);
        //
        changeCredentials.add(nameChange);
        changeCredentials.add(passChange);
        
        
        viewPatient = new JMenu("Patient");
        viewPatient.setFont(ft3);
        icon = new ImageIcon("patient.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        viewPatient.setIcon(icon);
        viewPatient.setFocusable(false);
        viewPatient.setBackground(Color.white);
        viewPatient.setVerticalTextPosition(viewPatient.TOP);
        viewPatient.setHorizontalTextPosition(SwingConstants.CENTER);      
        viewPatient.setPreferredSize(new Dimension(285, 240));
        viewPatient.setBorderPainted(false);
        
        patientAptView = new JMenuItem("View Appointment");
        patientAptView.setFont(ft4);
        //
        patientWardView= new JMenuItem("View Booking Records");
        patientWardView.setFont(ft4);
        //
        patientBill= new JMenuItem("View Bill Transaction");
        patientBill.setFont(ft4);
        //
        patientInfo= new JMenuItem("View Patient Info");
        patientInfo.setFont(ft4);
        //
        viewPatient.add(patientInfo);
        viewPatient.add(patientAptView);
        viewPatient.add(patientWardView);
        viewPatient.add(patientBill);
        
        //-------------------------------------
        
        optionSet.add(receptionistOpt);
        optionSet.add(doctorOpt);
        optionSet.add(nurseOpt);
        optionSet.add(wardOpt);
        optionSet.add(viewPatient);
        optionSet.add(changeCredentials);
        
        //---------------------------------------
        btnPanel.setBackground(Color.WHITE);
        optionFrame.add(msgPanel, BorderLayout.NORTH);
        optionFrame.add(optionSet, BorderLayout.CENTER);
        optionFrame.add(btnPanel, BorderLayout.SOUTH);
        
        //----------------------------------------------
        
        optionFrame.setSize(850,750);
        optionFrame.setLocationRelativeTo(null);
        optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionFrame.setResizable(false);
//        optionFrame.setVisible(true);
    }
    
}
