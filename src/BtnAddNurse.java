
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
public class BtnAddNurse implements ActionListener{
     ClinicController Cl;    
    
    public BtnAddNurse(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("CREATE"))
        {
            String FName = Cl.nurse.tfFName.getText();
            String LName = Cl.nurse.tfLName.getText();
            String sal = Cl.nurse.tfSal.getText();
            String dob = Cl.nurse.tfDOB.getText();
            String gender = Cl.nurse.cbGender.getSelectedItem().toString();
            String phn = Cl.nurse.tfPhone.getText();
            String hs = Cl.nurse.tfHouse.getText();
            String ct = Cl.nurse.tfCity.getText();
            String zip = Cl.nurse.tfZip.getText();
            String shft = Cl.nurse.shift.getSelectedItem().toString();
            String wrdNo = Cl.nurse.wardNo.getSelectedItem().toString();
            
            int salInt = Integer.parseInt(sal);
            int wrdNoInt = Integer.parseInt(wrdNo);

            Cl.dbMgr.AddNurseRecord(FName, LName,wrdNoInt, salInt,dob, gender, phn, hs, ct, zip, shft);
            JOptionPane.showMessageDialog(null,"Nurse Added Succesfully!!!","Nurse",JOptionPane.INFORMATION_MESSAGE);
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.nurse.nurseInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.nurse.nurseInputFrame.setVisible(false);
        }
    }
}
