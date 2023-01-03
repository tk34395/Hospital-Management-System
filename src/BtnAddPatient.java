
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
public class BtnAddPatient implements ActionListener{
     ClinicController Cl;    
    
    public BtnAddPatient(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("ADD"))
        {
            String FName = Cl.patient.tfFName.getText();
            String LName = Cl.patient.tfLName.getText();
            String dob = Cl.patient.tfDOB.getText();
            String Dis = Cl.patient.tfDisease.getText();
            String gender = Cl.patient.cbGender.getSelectedItem().toString();
            String phn = Cl.patient.tfPhone.getText();
            String hs = Cl.patient.tfHouse.getText();
            String ct = Cl.patient.tfCity.getText();
            String zip = Cl.patient.tfZip.getText();

            Cl.dbMgr.AddPatientRecord(FName, LName,Dis,dob, gender, phn, hs, ct, zip);
            JOptionPane.showMessageDialog(null,"Patient Added Succesfully!!!","Patient",JOptionPane.INFORMATION_MESSAGE);
            Cl.rptOptionSet.optionFrame.setVisible(true);
            Cl.patient.patientInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.rptOptionSet.optionFrame.setVisible(true);
            Cl.patient.patientInputFrame.setVisible(false);
        }
    }
}
