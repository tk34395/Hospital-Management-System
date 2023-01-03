
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
public class ViewAppointment {
    JTable aptTable;
    JFrame aptFrame;
    JButton btnClose, btnSignOut;
    JScrollPane tableScroller;
    JLabel msgText;
    JPanel btnPanel,msgPanel, scrollTBPanel; 
    DefaultTableModel tableModel;
    ClinicController HC;
    boolean isAdminMode;
    public ViewAppointment(ClinicController refgHC, boolean admCall)
    {
        HC= refgHC;
        initGUI();
        isAdminMode = admCall;
    }
    
    public void initGUI()
    {
        aptFrame = new JFrame("View Appointment");
        aptFrame.setLayout(new BorderLayout());
        
        msgText = new JLabel("View Appointment");
        msgText.setHorizontalAlignment(SwingConstants.CENTER);
        Font ft3= msgText.getFont().deriveFont(Font.PLAIN,50f);
        msgText.setFont(ft3);
        msgPanel = new JPanel(new BorderLayout());
        msgPanel.add(msgText);
        
        //-----------------------------------------
        btnPanel=new JPanel(new FlowLayout(1,50,10));
        btnClose= new JButton("Close");
        btnClose.setActionCommand("10");
        btnClose.setFocusable(false);
        
        Font ft1= btnClose.getFont().deriveFont(Font.PLAIN,25f);
        btnClose.setFont(ft1);
        
        btnSignOut=new JButton("SIGN OUT");
        btnSignOut.setActionCommand("101");
        btnSignOut.setFocusable(false);
        btnSignOut.setFont(ft1);
        
        btnPanel.add(btnClose);
        btnPanel.add(btnSignOut);
        //------------------------------------------
        
        tableModel = new DefaultTableModel();
        aptTable = new JTable(tableModel){
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
        };
        
        
        tableModel.addColumn("Appointment Date");
        tableModel.addColumn("Doctor ID");
        tableModel.addColumn("Patient ID");
        tableModel.addColumn("Appointment No");
        tableModel.addColumn("Appointment Fee");
        
        HC.dbMgr.getAppointmentRecord();
        
        try {
            while(HC.dbMgr.rs.next())
            {
                    String columnValues[]
                            ={HC.dbMgr.rs.getString(1),HC.dbMgr.rs.getString(2),HC.dbMgr.rs.getString(3),
                            HC.dbMgr.rs.getString(4),HC.dbMgr.rs.getString(5)};
                    
                    tableModel.addRow(columnValues);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewReceptionist.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableScroller = new JScrollPane(aptTable);
        scrollTBPanel = new JPanel(new BorderLayout());
        scrollTBPanel.add(tableScroller);
        
        //-------------------------------------
        
        aptFrame.add(msgPanel, BorderLayout.NORTH);
        aptFrame.add(scrollTBPanel, BorderLayout.CENTER);
        aptFrame.add(btnPanel, BorderLayout.SOUTH);
        
        aptFrame.setSize(1000,500);
        aptFrame.setLocationRelativeTo(null);
        aptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aptFrame.setResizable(false);
    }    
}
