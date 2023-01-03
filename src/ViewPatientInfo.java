
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
public class ViewPatientInfo {
     JTable pntTable;
    JFrame pntFrame;
    JButton btnClose, btnSignOut;
    JScrollPane tableScroller;
    JLabel msgText;
    JPanel btnPanel,msgPanel, scrollTBPanel; 
    DefaultTableModel tableModel;
    ClinicController HC;
    boolean isAdminMode;
    public ViewPatientInfo(ClinicController refgHC, boolean admMode)
    {
        HC= refgHC;
        initGUI();
        isAdminMode=admMode;
    }
    
    public void initGUI()
    {
        pntFrame = new JFrame("View Patient Info");
        pntFrame.setLayout(new BorderLayout());
        
        msgText = new JLabel("View Patient Info");
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
        Font ft3= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft3);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        //-----------------------------------------
        btnPanel=new JPanel(new FlowLayout(1,50,10));
        btnClose= new JButton("Close");
        btnClose.setActionCommand("4");
        btnClose.setFocusable(false);
        
        Font ft1= btnClose.getFont().deriveFont(Font.PLAIN,25f);
        btnClose.setFont(ft1);
        
        btnSignOut=new JButton("SIGN OUT");
        btnSignOut.setActionCommand("41");
        btnSignOut.setFocusable(false);
        btnSignOut.setFont(ft1);
        
        btnPanel.add(btnClose);
        btnPanel.add(btnSignOut);
        //------------------------------------------
        
        tableModel = new DefaultTableModel();
        pntTable = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
        };
        
        
        tableModel.addColumn("ID");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Disease");
        tableModel.addColumn("Phone");
        tableModel.addColumn("Gender");
        tableModel.addColumn("DOB");
        tableModel.addColumn("HouseNo");
        tableModel.addColumn("City");
        tableModel.addColumn("ZIP");
        
        HC.dbMgr.getPatientInfoRecord();
        
        try {
            while(HC.dbMgr.rs.next())
            {
                    String columnValues[]
                            ={HC.dbMgr.rs.getString(1),HC.dbMgr.rs.getString(2),HC.dbMgr.rs.getString(3),
                            HC.dbMgr.rs.getString(4),HC.dbMgr.rs.getString(5),HC.dbMgr.rs.getString(6),
                            HC.dbMgr.rs.getString(7),HC.dbMgr.rs.getString(8),HC.dbMgr.rs.getString(9)
                            ,HC.dbMgr.rs.getString(10)};
                            
                    
                    tableModel.addRow(columnValues);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewReceptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableScroller = new JScrollPane(pntTable);
        scrollTBPanel = new JPanel(new BorderLayout());
        scrollTBPanel.add(tableScroller);
        
        //-------------------------------------
        
        pntFrame.add(msgPanel, BorderLayout.NORTH);
        pntFrame.add(scrollTBPanel, BorderLayout.CENTER);
        pntFrame.add(btnPanel, BorderLayout.SOUTH);
        
        
        pntFrame.setSize(1000,500);
        pntFrame.setLocationRelativeTo(null);
        pntFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pntFrame.setResizable(false);
    }
}
