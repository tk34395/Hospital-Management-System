
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
public class ReceptionistBtnHandler implements ActionListener{

        ClinicController cl;
        
    public ReceptionistBtnHandler(ClinicController refgC)
    {
        cl=refgC;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("SIGN OUT"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.rptSignIn.rptSignInFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("Deactiviate Me"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.dbMgr.deActiviateRpt(cl.rptOptionSet.rptName);
            JOptionPane.showMessageDialog(null,"You have deactiviated yourself!!","Receptionist",JOptionPane.ERROR_MESSAGE);
            cl.rptSignIn.rptSignInFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("Add Patient"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.AddPatientInfo();
        }
        else if(e.getActionCommand().equals("Patient Requirement"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.addRequirementInfo();
        }
        else if(e.getActionCommand().equals("View Appointment"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.ViewAppointmentRecordInfo(false);
        }
        else if(e.getActionCommand().equals("View Booking Records"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.ViewBookingRecord(false);
        }
        else if(e.getActionCommand().equals("View Doctors Details"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.ViewDoctorRecordInfo(false);
        }
        else if(e.getActionCommand().equals("View Visiting Record"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.ViewVisitingRecord(false);
        }
        else if(e.getActionCommand().equals("Add Visiting Record"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.AddVisitingInfo();
        }
        else if(e.getActionCommand().equals("View Ward"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.viewWardInfo(false);
        }
        else if(e.getActionCommand().equals("View Bed Info"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.viewBedInfo(false);
        }
        else if(e.getActionCommand().equals("View Bill Transaction"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.ViewBill(false);
        }
        else if(e.getActionCommand().equals("View Bill"))
        {
            cl.rptOptionSet.optionFrame.setVisible(false);
            cl.ViewSpecificBillPatient();
        }
        else if(e.getActionCommand().equals("Change Username"))
        {
            String userRpt = JOptionPane.showInputDialog("Enter Username:");
            if(userRpt == null)
                return;
            while (userRpt.equals("")) 
                {
                    userRpt = JOptionPane.showInputDialog("Enter Valid Username:");
                    if (userRpt == null) {
                        return;
                    }
                }
                
                if(cl.dbMgr.rptUsername(userRpt, cl.rptOptionSet.rptName))
                {
                    JOptionPane.showMessageDialog(null,"Username sucessfully Changed!!","Username",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Username already taken!!","Username",JOptionPane.ERROR_MESSAGE);

                }
        }
        else if(e.getActionCommand().equals("Change Password"))
        {
            String passRpt = JOptionPane.showInputDialog("Enter Password:");
            if(passRpt == null)
                return;
            while (passRpt.length() <= 8) 
                {
                    passRpt = JOptionPane.showInputDialog("Enter Valid Password:");
                    if (passRpt == null) {
                        return;
                    }
                }
                cl.dbMgr.adminPassword(passRpt, cl.rptOptionSet.rptName);
                JOptionPane.showMessageDialog(null,"Password is not changed!!","Password",JOptionPane.ERROR_MESSAGE);

        }
        
        
    }
    
}
