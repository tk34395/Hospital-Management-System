
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
public class AdminModeBtnHandler implements ActionListener{
    ClinicController cl;    
    
    public AdminModeBtnHandler(ClinicController refHC)
    {
        cl = refHC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Add Receptionist"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.addReceptionistRecord();
        }
        else if(e.getActionCommand().equals("View Receptionist"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewReceptionRecord(true);
        }
        else if(e.getActionCommand().equals("View Doctors Details"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewDoctorRecordInfo(true);
        }
        else if(e.getActionCommand().equals("View Visiting Record"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewVisitingRecordInfo(true);
        }
        else if(e.getActionCommand().equals("Add Doctor"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.AddDoctorRecordInfo();
        }
        else if(e.getActionCommand().equals("View Nurse"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewNurseRecord(true);
        }
        else if(e.getActionCommand().equals("Add Nurse"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.AddNurseInfo();
        }
        else if(e.getActionCommand().equals("Add Ward"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.addWardInfo();
        }
        else if(e.getActionCommand().equals("Add Bed"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.AddBedInfo();
        }
        else if(e.getActionCommand().equals("View Ward"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.viewWardInfo(true);
        }
        else if(e.getActionCommand().equals("View Bed Info"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.viewBedInfo(true);
        }
        else if(e.getActionCommand().equals("View Appointment"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewAppointmentRecordInfo(true);
        }
        else if(e.getActionCommand().equals("View Booking Records"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewBookingRecord(true);
        }
        else if(e.getActionCommand().equals("View Bill Transaction"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewBill(true);
        }
        else if(e.getActionCommand().equals("View Patient Info"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.ViewPatientInfo(true);
        }
        else if(e.getActionCommand().equals("Deactiviate Me"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.dbMgr.deActiviateAdmin(cl.adminOptSet.admName);
            JOptionPane.showMessageDialog(null,"You have deactiviated yourself!!","Administrator",JOptionPane.ERROR_MESSAGE);
            cl.signObj.adminSignInFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("SIGN OUT"))
        {
            cl.adminOptSet.optionFrame.setVisible(false);
            cl.signObj.adminSignInFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("Change Username"))
        {
            String userAdm = JOptionPane.showInputDialog("Enter Username:");
            if(userAdm == null)
                return;
            while (userAdm.equals("")) 
                {
                    userAdm = JOptionPane.showInputDialog("Enter Valid Username:");
                    if (userAdm == null) {
                        return;
                    }
                }
                
                if(cl.dbMgr.adminUsername(userAdm, cl.adminOptSet.admName))
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
            String passAdm = JOptionPane.showInputDialog("Enter Password:");
            if(passAdm == null)
                return;
            while (passAdm.length() <= 8) 
                {
                    passAdm = JOptionPane.showInputDialog("Enter Valid Password:");
                    if (passAdm == null) {
                        return;
                    }
                }
                cl.dbMgr.adminPassword(passAdm, cl.adminOptSet.admName);
                JOptionPane.showMessageDialog(null,"Password is not changed!!","Password",JOptionPane.ERROR_MESSAGE);

        }
    }
    
}
