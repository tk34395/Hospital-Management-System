
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
public class AddPatientRequirement {

    JFrame rqFrame;
    JLabel msgText2;
    JButton btnApt,btnBed,btnBack2;
    JPanel btnPanel2,endPanel,msgPanel2;
    ClinicController HC;
    
    //---------------------------------------
    
    JLabel lbDoc,lbPat,msgText3,lbFee;
    
    JFrame aptInputFrame;
    JPanel btnPanel3,inputPanelApt,msgAptPanel;
    JButton btnBack1,btnBook;
    JComboBox<String> docId,patientId;
    String[] docStr;
    String[] patientStr;
    JTextField tfFee;
    
    //---------------------------------------
    
    JLabel lbDays,msgText4, lbPat2;
    JTextField tfDays;
    JFrame bedInputFrame;
    JPanel btnPanel4,inputPanelbed,msgBedPanel;
    JButton btnBack4,btnBook1;
    JComboBox<String> patientId2;
    String[] patientStr2;
    
    public AddPatientRequirement(ClinicController refgC)
    {
        HC=refgC;
        initAddRequirementGUI();
    }
    
    public void initAddRequirementGUI()
    {
        rqFrame=new JFrame("Requirement");
        rqFrame.setLayout(new BorderLayout());
        
        
        msgText2 = new JLabel("What do you want?");
        Font ft3= msgText2.getFont().deriveFont(Font.PLAIN,50f);
        msgText2.setFont(ft3);
        msgPanel2 = new JPanel(new BorderLayout());
        msgPanel2.add(msgText2);
        
        //-----------------------------------------
        btnPanel2=new JPanel(new FlowLayout(1,50,30));
        btnApt= new JButton("Appointment");
        btnApt.setFocusable(false);
        
        Font ft1= btnApt.getFont().deriveFont(Font.PLAIN,25f);
        btnApt.setFont(ft1);
        
        btnBed=new JButton("Book  a  Bed");
        btnBed.setFocusable(false);
        btnBed.setFont(ft1);
        
        btnPanel2.add(btnApt);
        btnPanel2.add(btnBed);
        
        //-------------------------------------
        endPanel=new JPanel(new FlowLayout(1,50,10));
        btnBack2= new JButton("BACK");
        btnBack2.setFocusable(false);
        btnBack2.setFont(ft1);
        
        endPanel.add(btnBack2);
        
        //
        rqFrame.add(msgPanel2, BorderLayout.NORTH);
        rqFrame.add(btnPanel2, BorderLayout.CENTER);
        rqFrame.add(endPanel, BorderLayout.SOUTH);
        
        rqFrame.setSize(700,250);
        rqFrame.setLocationRelativeTo(null);
        rqFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rqFrame.setResizable(false);
        
        //------------------------------------------------
        
        
        //Appointment:
        aptInputFrame=new JFrame("Requirement");
        aptInputFrame.setLayout(new BorderLayout());
        
        
        msgText3 = new JLabel("APPOINTMENT");
        msgText3.setHorizontalAlignment(SwingConstants.CENTER);
        msgText3.setFont(ft3);
        msgAptPanel = new JPanel(new BorderLayout());
        msgAptPanel.add(msgText3);
        
        
        //-----------------------------------------
        btnPanel3=new JPanel(new FlowLayout(1,50,10));
        btnBook= new JButton("BOOK APPOINTMENT");
        btnBook.setFocusable(false);
        
        btnBook.setFont(ft1);
        
        btnBack1=new JButton(" BACK ");
        btnBack1.setFocusable(false);
        btnBack1.setFont(ft1);
        
        btnPanel3.add(btnBack1);
        btnPanel3.add(btnBook);
        
        //-------------------------------------
        
        inputPanelApt=new JPanel(new GridLayout(3,2));
        
        Font ft2= btnBook.getFont().deriveFont(Font.PLAIN,20f);
        
        
        
        int totalDoc = HC.dbMgr.countDoctors();
        HC.dbMgr.getDocInfoRecord();

        if(totalDoc > 0)
        {
            docStr = new String[totalDoc];
            try {
                int count =0;
                while(HC.dbMgr.rs.next())
                {
                    docStr[count]= HC.dbMgr.rs.getString("DR_ID");
                    count++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddNurse.class.getName()).log(Level.SEVERE, null, ex);
            }
            docId = new JComboBox<>(docStr);
        }
        else
        {
            docStr = new String[1];
            docStr[0]="null";
            docId = new JComboBox<>(docStr);
        }
        
        lbDoc = new JLabel("Select Doctor:");
        lbDoc.setFont(ft2);
        docId.setFont(ft2);
        
        inputPanelApt.add(lbDoc);
        inputPanelApt.add(docId);
        
        //--\\\\\\\\\\\\\\\\\\\\\\\\
        
         int totalPatient1 = HC.dbMgr.countPatient();
        HC.dbMgr.getPatientInfoRecord();

        if(totalPatient1 > 0)
        {
            patientStr = new String[totalPatient1];
            try {
                int count =0;
                while(HC.dbMgr.rs.next())
                {
                    patientStr[count]= HC.dbMgr.rs.getString("P_ID");
                    count++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddNurse.class.getName()).log(Level.SEVERE, null, ex);
            }
            patientId = new JComboBox<>(patientStr);
        }
        else
        {
            patientStr = new String[1];
            patientStr[0]="null";
            patientId = new JComboBox<>(patientStr);
        }
        
        
        lbPat = new JLabel("Select Patient:");
        lbPat.setFont(ft2);
        patientId.setFont(ft2);
        
        inputPanelApt.add(lbPat);
        inputPanelApt.add(patientId);
        
        //--\\\\\\\\\\\\\\\\\\\\\\\\
        
        lbFee = new JLabel("Appointment Fee:");
        lbFee.setFont(ft2);
        tfFee=new JTextField(15);
        tfFee.setFont(ft2);
        
        inputPanelApt.add(lbFee);
        inputPanelApt.add(tfFee);
        
        
        aptInputFrame.add(msgAptPanel, BorderLayout.NORTH);
        aptInputFrame.add(inputPanelApt, BorderLayout.CENTER);
        aptInputFrame.add(btnPanel3, BorderLayout.SOUTH);
        
        aptInputFrame.setSize(700,300);
        aptInputFrame.setLocationRelativeTo(null);
        aptInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aptInputFrame.setResizable(false);
        
        
        //-------------------------
        
        //Booking Record:

        bedInputFrame=new JFrame("Requirement");
        bedInputFrame.setLayout(new BorderLayout());
        
        
        msgText4 = new JLabel("BED");
        msgText4.setHorizontalAlignment(SwingConstants.CENTER);
        msgText4.setFont(ft3);
        msgBedPanel = new JPanel(new BorderLayout());
        msgBedPanel.add(msgText4);
        
        
        //-----------------------------------------
        btnPanel4=new JPanel(new FlowLayout(1,50,10));
        btnBook1= new JButton("BOOK BED");
        btnBook1.setFocusable(false);
        
        btnBook1.setFont(ft1);
        
        btnBack4=new JButton("BACK ");
        btnBack4.setFocusable(false);
        btnBack4.setFont(ft1);
        
        btnPanel4.add(btnBack4);
        btnPanel4.add(btnBook1);
        
        //-------------------------------------
        
        inputPanelbed=new JPanel(new GridLayout(2,2));
                
        lbDays = new JLabel("BED books for Days:");
        lbDays.setFont(ft2);
        tfDays=new JTextField(15);
        tfDays.setFont(ft2);
        
        inputPanelbed.add(lbDays);
        inputPanelbed.add(tfDays);
        
        //--\\\\\\\\\\\\\\\\\\\\\\\\
        
         int totalPatient2 = HC.dbMgr.countPatient();
        HC.dbMgr.getPatientInfoRecord();

        if(totalPatient2 > 0)
        {
            patientStr2 = new String[totalPatient2];
            try {
                int count =0;
                while(HC.dbMgr.rs.next())
                {
                    patientStr2[count]= HC.dbMgr.rs.getString("P_ID");
                    count++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddNurse.class.getName()).log(Level.SEVERE, null, ex);
            }
            patientId2 = new JComboBox<>(patientStr2);
        }
        else
        {
            patientStr2 = new String[1];
            patientStr2[0]="null";
            patientId2 = new JComboBox<>(patientStr2);
        }
        
        lbPat2 = new JLabel("Select Patient:");
        lbPat2.setFont(ft2);
        patientId2.setFont(ft2);
        
        inputPanelbed.add(lbPat2);
        inputPanelbed.add(patientId2);
        
        //--\\\\\\\\\\\\\\\\\\\\\\\\
     
        //----------------------------------------
        
        bedInputFrame.add(msgBedPanel, BorderLayout.NORTH);
        bedInputFrame.add(inputPanelbed, BorderLayout.CENTER);
        bedInputFrame.add(btnPanel4, BorderLayout.SOUTH);
        
        bedInputFrame.setSize(700,300);
        bedInputFrame.setLocationRelativeTo(null);
        bedInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bedInputFrame.setResizable(false);
    }
}
