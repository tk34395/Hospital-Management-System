
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class BtnPatientRequirement implements ActionListener{
     ClinicController Cl;    
    
    public BtnPatientRequirement(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Appointment"))
        {
            Cl.patRequirement.rqFrame.setVisible(false);
            Cl.patRequirement.aptInputFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("Book  a  Bed"))
        {
            Cl.patRequirement.rqFrame.setVisible(false);
            Cl.patRequirement.bedInputFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.rptOptionSet.optionFrame.setVisible(true);
            Cl.patRequirement.rqFrame.setVisible(false);

        }
        else if(e.getActionCommand().equals("BOOK APPOINTMENT"))
        {
            String docStr = Cl.patRequirement.docId.getSelectedItem().toString();
            String patIdStr = Cl.patRequirement.patientId.getSelectedItem().toString();
            String feeStr = Cl.patRequirement.tfFee.getText();
            
            int docId = Integer.parseInt(docStr);
            int patId = Integer.parseInt(patIdStr);
            int fee = Integer.parseInt(feeStr);
            
            Cl.dbMgr.AddAppointment(docId, patId, fee);
            //JOptionPane.showMessageDialog(null,"Appointment granted!!!","Appointment",JOptionPane.INFORMATION_MESSAGE);
            Cl.patRequirement.rqFrame.setVisible(true);
            Cl.patRequirement.aptInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals(" BACK "))
        {
            Cl.patRequirement.rqFrame.setVisible(true);
            Cl.patRequirement.aptInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BOOK BED"))
        {
            String dayStr = Cl.patRequirement.tfDays.getText();
            String strPat = Cl.patRequirement.patientId2.getSelectedItem().toString();
            
            int dayInt = Integer.parseInt(dayStr);
            int patint =Integer.parseInt(strPat);
            
            Cl.dbMgr.bookBed(dayInt, patint);
            Cl.patRequirement.rqFrame.setVisible(true);
            Cl.patRequirement.bedInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BACK "))
        {
            Cl.patRequirement.rqFrame.setVisible(true);
            Cl.patRequirement.bedInputFrame.setVisible(false);
        }
    }
}
