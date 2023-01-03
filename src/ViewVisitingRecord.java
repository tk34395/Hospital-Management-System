
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
public class ViewVisitingRecord {
    JTable visitRecTable;
    JFrame visitRecFrame;
    JButton btnClose, btnSignOut;
    JScrollPane tableScroller;
    JLabel msgText;
    JPanel btnPanel,msgPanel, scrollTBPanel; 
    DefaultTableModel tableModel;
    ClinicController HC;
    boolean isAdminMode;
    public ViewVisitingRecord(ClinicController refgHC, boolean admMode)
    {
        HC= refgHC;
        initGUI();
        isAdminMode=admMode;
    }
    
    public void initGUI()
    {
        visitRecFrame = new JFrame("View Visiting Record");
        visitRecFrame.setLayout(new BorderLayout());
        
        msgText = new JLabel("View Visiting Record");
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
        Font ft3= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft3);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        //-----------------------------------------
        btnPanel=new JPanel(new FlowLayout(1,50,10));
        btnClose= new JButton("Close");
        btnClose.setActionCommand("2");
        btnClose.setFocusable(false);
        
        Font ft1= btnClose.getFont().deriveFont(Font.PLAIN,25f);
        btnClose.setFont(ft1);
        
        btnSignOut=new JButton("SIGN OUT");
        btnSignOut.setActionCommand("21");
        btnSignOut.setFocusable(false);
        btnSignOut.setFont(ft1);
        
        btnPanel.add(btnClose);
        btnPanel.add(btnSignOut);
        //------------------------------------------
        
        tableModel = new DefaultTableModel();
        visitRecTable = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
        };
        
        
        tableModel.addColumn("VR Date");
        tableModel.addColumn("Doctor ID");
        tableModel.addColumn("Ward No");
        tableModel.addColumn("VR Duration");
        
        HC.dbMgr.getVisitingRecord();
        
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
        
        tableScroller = new JScrollPane(visitRecTable);
        scrollTBPanel = new JPanel(new BorderLayout());
        scrollTBPanel.add(tableScroller);
        
        //-------------------------------------
        
        visitRecFrame.add(msgPanel, BorderLayout.NORTH);
        visitRecFrame.add(scrollTBPanel, BorderLayout.CENTER);
        visitRecFrame.add(btnPanel, BorderLayout.SOUTH);
        
        visitRecFrame.setSize(1000,500);
        visitRecFrame.setLocationRelativeTo(null);
        visitRecFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visitRecFrame.setResizable(false);
    }    
}
