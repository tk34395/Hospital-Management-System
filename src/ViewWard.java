
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
public class ViewWard {
    
    JTable wardTable;
    JFrame wardFrame;
    JButton btnClose, btnSignOut;
    JScrollPane tableScroller;
    JLabel msgText;
    JPanel btnPanel,msgPanel, scrollTBPanel; 
    DefaultTableModel tableModel;
    ClinicController HC;
    boolean isAdminMode;
    public ViewWard(ClinicController refgHC, boolean admMode)
    {
        HC= refgHC;
        initGUI();
        isAdminMode= admMode;
    }
    
    public void initGUI()
    {
        wardFrame = new JFrame("View Ward");
        wardFrame.setLayout(new BorderLayout());
        
        msgText = new JLabel("View Ward");
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
        Font ft3= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft3);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        //-----------------------------------------
        btnPanel=new JPanel(new FlowLayout(1,50,10));
        btnClose= new JButton("Close");
        btnClose.setActionCommand("1");
        btnClose.setFocusable(false);
        
        Font ft1= btnClose.getFont().deriveFont(Font.PLAIN,25f);
        btnClose.setFont(ft1);
        
        btnSignOut=new JButton("SIGN OUT");
        btnSignOut.setActionCommand("11");
        btnSignOut.setFocusable(false);
        btnSignOut.setFont(ft1);
        
        btnPanel.add(btnClose);
        btnPanel.add(btnSignOut);
        //------------------------------------------
        
        tableModel = new DefaultTableModel();
        wardTable = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
        };
        
        
        tableModel.addColumn("WR_NO");
        tableModel.addColumn("WARD CAPACITY");
        tableModel.addColumn("WARD CHARGES");
        
        HC.dbMgr.getWardRecord();
        
        try {
            while(HC.dbMgr.rs.next())
            {
                    String columnValues[]
                            ={HC.dbMgr.rs.getString(1),HC.dbMgr.rs.getString(2),HC.dbMgr.rs.getString(3)};

                    tableModel.addRow(columnValues);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewReceptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableScroller = new JScrollPane(wardTable);
        scrollTBPanel = new JPanel(new BorderLayout());
        scrollTBPanel.add(tableScroller);
        
        //-------------------------------------
        
        wardFrame.add(msgPanel, BorderLayout.NORTH);
        wardFrame.add(scrollTBPanel, BorderLayout.CENTER);
        wardFrame.add(btnPanel, BorderLayout.SOUTH);
        
        wardFrame.setVisible(true);
        wardFrame.setSize(1000,500);
        wardFrame.setLocationRelativeTo(null);
        wardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wardFrame.setResizable(false);
    }
}
