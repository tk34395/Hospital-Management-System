
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
public class BtnAddDoctor implements ActionListener{
     ClinicController Cl;    
    
    public BtnAddDoctor(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("ADD"))
        {
            String FName = Cl.dc.tfFName.getText();
            String LName = Cl.dc.tfLName.getText();
            String sal = Cl.dc.tfSal.getText();
            String Sp = Cl.dc.tfSpecialization.getText();
            String dob = Cl.dc.tfDOB.getText();
            String gender = Cl.dc.cbGender.getSelectedItem().toString();
            String phn = Cl.dc.tfPhone.getText();
            String hs = Cl.dc.tfHouse.getText();
            String ct = Cl.dc.tfCity.getText();
            String zip = Cl.dc.tfZip.getText();
            String shft = Cl.dc.shift.getSelectedItem().toString();

            int salInt = Integer.parseInt(sal);
            Cl.dbMgr.AddDoctorRecord(FName, LName, salInt, Sp,dob, gender, phn, hs, ct, zip, shft);
            JOptionPane.showMessageDialog(null,"Doctor Added Succesfully!!!","Add Doctor",JOptionPane.INFORMATION_MESSAGE);
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.dc.docInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.dc.docInputFrame.setVisible(false);
        }
    }
}
