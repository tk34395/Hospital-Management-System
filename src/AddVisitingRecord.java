
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
public class AddVisitingRecord {
    JLabel lbWard,msgText,lbDuration,lbDoc;
    JTextField tDuration;

    JFrame visitInputFrame;
    JPanel btnPanel,inputPanelVisit,msgPanel;
    JButton btnBack,btnAdd;
    JComboBox<String> wardNo;
    JComboBox<String> docId;
    String[] docStr;
    String[] wardStr;
    ClinicController HC;

    public AddVisitingRecord(ClinicController refgC)
    {
        HC=refgC;
        initAddRequirementGUI();
    }
    
    public void initAddRequirementGUI()
    {
        
        
        //Visiting record:
        visitInputFrame=new JFrame("Requirement");
        visitInputFrame.setLayout(new BorderLayout());
        
        
        msgText = new JLabel("Visiting Record");
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
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
        
        inputPanelVisit=new JPanel(new GridLayout(3,2));
        
        Font ft2= btnAdd.getFont().deriveFont(Font.PLAIN,20f);
        
        
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
        
        inputPanelVisit.add(lbDoc);
        inputPanelVisit.add(docId);
        
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
        
        inputPanelVisit.add(lbWard);
        inputPanelVisit.add(wardNo);
        
                
        lbDuration = new JLabel("Visit Duration(in minutes):");
        lbDuration.setFont(ft2);
        tDuration=new JTextField(15);
        tDuration.setFont(ft2);
        
        inputPanelVisit.add(lbDuration);
        inputPanelVisit.add(tDuration);
        
        //----------------------------------------
        
        visitInputFrame.add(msgPanel, BorderLayout.NORTH);
        visitInputFrame.add(inputPanelVisit, BorderLayout.CENTER);
        visitInputFrame.add(btnPanel, BorderLayout.SOUTH);
        
        visitInputFrame.setVisible(true);
        visitInputFrame.setSize(700,300);
        visitInputFrame.setLocationRelativeTo(null);
        visitInputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visitInputFrame.setResizable(false);
    }
}
