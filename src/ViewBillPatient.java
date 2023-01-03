
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class ViewBillPatient {
    
    JTable billTable;
    JFrame billFrame;
    JButton btnClose, btnSignOut, btnSearch;
    JScrollPane tableScroller;
    JLabel msgText,lbPat,lbBill;
    JTextField tfBill;
    JPanel btnPanel,msgPanel, scrollTBPanel, inputPanel, billPanel, upperPanel,downPanel; 
    DefaultTableModel tableModel;
    ClinicController HC;
    JComboBox<String> patientId;
    String[] patientStr;
    
    public ViewBillPatient(ClinicController refgC)
    {
        HC =refgC;
        initGUI();
    }
    
    void tableAdd(int pat)
    {
        HC.dbMgr.getSpeceficBillRecord(pat);
        
        try {
            while(HC.dbMgr.rs.next())
            {
                    String columnValues[]
                            ={HC.dbMgr.rs.getString(1),HC.dbMgr.rs.getString(2),HC.dbMgr.rs.getString(3),
                            HC.dbMgr.rs.getString(4)};
                            
                    
                    tableModel.addRow(columnValues);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewReceptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void initGUI()
    {

        billFrame = new JFrame("View Bill");
        billFrame.setLayout(new BorderLayout());
        
        msgText = new JLabel("View Bill");
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
        Font ft3= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft3);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        //-----------------------------------------
        btnPanel=new JPanel(new FlowLayout(1,50,10));
        btnClose= new JButton("Close");
        btnClose.setFocusable(false);
        
        Font ft1= btnClose.getFont().deriveFont(Font.PLAIN,25f);
        btnClose.setFont(ft1);
        
        btnSignOut=new JButton("SIGN OUT");
        btnSignOut.setFocusable(false);
        btnSignOut.setFont(ft1);
        
        btnSearch=new JButton("SEARCH");
        btnSearch.setFocusable(false);
        btnSearch.setFont(ft1);
        
        btnPanel.add(btnClose);
        btnPanel.add(btnSignOut);
        //------------------------------------------
        
        inputPanel=new JPanel(new GridLayout(1,3));
        int totalPatient = HC.dbMgr.countPatient();
        HC.dbMgr.getPatientInfoRecord();
        Font ft2= btnClose.getFont().deriveFont(Font.PLAIN,40f);
        if(totalPatient > 0)
        {
            patientStr = new String[totalPatient];
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
        lbPat.setHorizontalAlignment(SwingConstants.RIGHT);
        lbPat.setFont(ft2);
        patientId.setFont(ft2);
        
        inputPanel.add(lbPat);
        inputPanel.add(patientId);
        inputPanel.add(btnSearch);
        
        upperPanel = new JPanel(new GridLayout(2,1));
        upperPanel.add(msgPanel);
        upperPanel.add(inputPanel);
        //------------------------------------------
        
        tableModel = new DefaultTableModel();
        billTable = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
        };
        
        
        tableModel.addColumn("Bill No");
        tableModel.addColumn("Patient Id");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Bill Date");
        
        //
        
        tableScroller = new JScrollPane(billTable);
        scrollTBPanel = new JPanel(new BorderLayout());
        scrollTBPanel.add(tableScroller);
        
        
        //-------------------------------------
        lbBill = new JLabel("Total Bill:");
        tfBill = new JTextField(15);
        tfBill.setEditable(false);
        tfBill.setFont(ft3);

        lbBill.setHorizontalAlignment(SwingConstants.CENTER);
        lbBill.setFont(ft3);

        billPanel = new JPanel(new GridLayout(1,2));
        billPanel.add(lbBill);
        billPanel.add(tfBill);
        
        downPanel = new JPanel(new GridLayout(2,1));
        downPanel.add(billPanel);
        downPanel.add(btnPanel);
        //--------------------
        billFrame.add(upperPanel, BorderLayout.NORTH);
        billFrame.add(scrollTBPanel, BorderLayout.CENTER);
        billFrame.add(downPanel, BorderLayout.SOUTH);
        
        billFrame.setSize(1000,500);
        billFrame.setLocationRelativeTo(null);
        billFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billFrame.setResizable(false);
    
    
    }
}
