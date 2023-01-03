
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
public class ReceptionistMode {
    
    JFrame optionFrame;
    JMenuBar optionSet,optionSet1,optionSet2;
    JMenu patientOpt, doctorView, wardOpt,billView,changeCredentials;
    JMenuItem docPersonalInfo,viewVRECDoc,addDocVisit, nameChange,passChange
            ,patientAdd,patientAptView,patientWardView, viewWard,viewBedInfo, viewBillPat, viewBillTransaction
            ,patientRq;
    JButton btnSignOut, dltRpt;
    JPanel btnPanel, msgPanel;
    JLabel msgText,space,space1,space2;
    String rptName,rptPassword;
    
    public ReceptionistMode(String rptN, String rptP)
    {
        rptName=rptN;
        rptPassword=rptP;
        
        initReceptionistMode();
    }
    
    public void initReceptionistMode()
    {
        optionFrame= new JFrame("Receptionist Mode");
        optionFrame.setLayout(new BorderLayout());
        
        btnSignOut = new JButton("SIGN OUT");
        btnSignOut.setFocusable(false);
        btnSignOut.setBorderPainted(false);
        btnSignOut.setBackground(Color.LIGHT_GRAY);


        dltRpt = new JButton("Deactiviate Me");
        dltRpt.setFocusable(false);
        dltRpt.setBorderPainted(false);
        dltRpt.setBackground(Color.LIGHT_GRAY);
        
        Font ft2= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        btnSignOut.setFont(ft2);
        dltRpt.setFont(ft2);
        btnPanel = new JPanel(new FlowLayout(1,5,30));
        btnPanel.add(dltRpt);
        btnPanel.add(btnSignOut);
        
        space = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        space.setHorizontalAlignment(SwingConstants.CENTER);
        space1 = new JLabel("");
        space2 = new JLabel("");
        msgText = new JLabel("Receptionist Mode");
        Font ft1= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
        msgText.setFont(ft1);
        msgPanel = new JPanel(new GridLayout(2,1));
        msgPanel.add(msgText);
        msgPanel.add(space);
        msgPanel.setBackground(Color.WHITE);
        
        ImageIcon icon;
        Image img, newimg;
        
        Font ft3= btnSignOut.getFont().deriveFont(Font.PLAIN,30f);
        Font ft4= btnSignOut.getFont().deriveFont(Font.PLAIN,20f);

        optionSet = new JMenuBar();
        optionSet.setLayout(new GridLayout(2,1));
        optionSet1 = new JMenuBar();
        optionSet1.setLayout(new GridLayout(1,3));
        optionSet2 = new JMenuBar();
        optionSet2.setLayout(new GridLayout(1,4));
        patientOpt = new JMenu("Patient");
        patientOpt.setFont(ft3);
        //,patientAdd,patientAptView,patientWardView;
        icon = new ImageIcon("patient.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        patientOpt.setIcon(icon);
        patientOpt.setFocusable(false);
        patientOpt.setBackground(Color.white);
        patientOpt.setVerticalTextPosition(patientOpt.TOP);
        patientOpt.setHorizontalTextPosition(SwingConstants.CENTER);      
        patientOpt.setPreferredSize(new Dimension(285, 240));
        patientOpt.setBorderPainted(false);
        

        
        patientAdd= new JMenuItem("Add Patient");
        patientAdd.setFont(ft4);
        //
        patientRq = new JMenuItem("Patient Requirement");
        patientRq.setFont(ft4);
        //
        patientAptView = new JMenuItem("View Appointment");
        patientAptView.setFont(ft4);
        //
        patientWardView= new JMenuItem("View Booking Records");
        patientWardView.setFont(ft4);
        //
        patientOpt.add(patientAdd);
        patientOpt.add(patientRq);
        patientOpt.add(patientAptView);
        patientOpt.add(patientWardView);
        
        
        doctorView= new JMenu("Doctor");
        doctorView.setFont(ft3);
        
        icon = new ImageIcon("doctor.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        doctorView.setIcon(icon);
        doctorView.setFocusable(false);
        doctorView.setBackground(Color.white);
        doctorView.setVerticalTextPosition(doctorView.TOP);
        doctorView.setHorizontalTextPosition(SwingConstants.CENTER);      
        doctorView.setPreferredSize(new Dimension(285, 240));
        doctorView.setBorderPainted(false);

        
        docPersonalInfo = new JMenuItem("View Doctors Details");
        docPersonalInfo.setFont(ft4);
        //
        viewVRECDoc = new JMenuItem("View Visiting Record");
        viewVRECDoc.setFont(ft4);
        //
        addDocVisit = new JMenuItem("Add Visiting Record");
        addDocVisit.setFont(ft4);
        //
        doctorView.add(docPersonalInfo);
        doctorView.add(viewVRECDoc);
        doctorView.add(addDocVisit);
        
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
        
        viewWard = new JMenuItem("View Ward");
        viewWard.setFont(ft4);
        //
        viewBedInfo = new JMenuItem("View Bed Info");
        viewBedInfo.setFont(ft4);
        //
        wardOpt.add(viewWard);
        wardOpt.add(viewBedInfo);
        
        billView = new JMenu("BILL");
        billView.setFont(ft3);
        
        icon = new ImageIcon("bill.jpg");
        img = icon.getImage();
        newimg = img.getScaledInstance(270, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        billView.setIcon(icon);
        billView.setFocusable(false);
        billView.setBackground(Color.white);
        billView.setVerticalTextPosition(doctorView.TOP);
        billView.setHorizontalTextPosition(SwingConstants.CENTER);      
        billView.setPreferredSize(new Dimension(285, 240));
        billView.setBorderPainted(false);
        
        viewBillPat = new JMenuItem("View Bill");
        viewBillPat.setFont(ft4);
        //
        viewBillTransaction= new JMenuItem("View Bill Transaction");
        viewBillTransaction.setFont(ft4);
        //
        billView.add(viewBillPat);
        billView.add(viewBillTransaction);
        
        changeCredentials= new JMenu("Change Credentials");
        changeCredentials.setFont(ft3);
        
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
        
        //-------------------------------------
        
        optionSet1.add(doctorView);
        optionSet1.add(wardOpt);
        optionSet1.add(patientOpt);
        optionSet2.add(space1);
        optionSet2.add(billView);
        optionSet2.add(changeCredentials);
        optionSet2.add(space2);
        optionSet1.setBackground(Color.LIGHT_GRAY);
        optionSet1.setBorderPainted(false);
        optionSet2.setBorderPainted(false);
        optionSet.setBorderPainted(false);
        optionSet2.setBackground(Color.LIGHT_GRAY);
        optionSet.setBackground(Color.LIGHT_GRAY);
        btnPanel.setBackground(Color.WHITE);
        optionSet.add(optionSet1);
        optionSet.add(optionSet2);
        //---------------------------------------
        
        optionFrame.add(msgPanel, BorderLayout.NORTH);
        optionFrame.add(optionSet, BorderLayout.CENTER);
        optionFrame.add(btnPanel, BorderLayout.SOUTH);
        
        //----------------------------------------------
        
        optionFrame.setSize(1200,780);
        optionFrame.setLocationRelativeTo(null);
        optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionFrame.setResizable(false);
      //  optionFrame.setVisible(true);
    }
    
}
