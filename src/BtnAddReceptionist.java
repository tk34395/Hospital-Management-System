
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
public class BtnAddReceptionist implements ActionListener{
     ClinicController Cl;    
    
    public BtnAddReceptionist(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("CREATE"))
        {
            String username = Cl.receptionist.tfUserName.getText();
            String pass = Cl.receptionist.tfPassword.getText();
            String confirmPass = Cl.receptionist.tfCfmPassword.getText();
            String FName = Cl.receptionist.tfFName.getText();
            String LName = Cl.receptionist.tfLName.getText();
            String sal = Cl.receptionist.tfSal.getText();
            String dob = Cl.receptionist.tfDOB.getText();
            String gender = Cl.receptionist.cbGender.getSelectedItem().toString();
            String phn = Cl.receptionist.tfPhone.getText();
            String hs = Cl.receptionist.tfHouse.getText();
            String ct = Cl.receptionist.tfCity.getText();
            String zip = Cl.receptionist.tfZip.getText();
            String shft = Cl.receptionist.shift.getSelectedItem().toString();

            int salInt = Integer.parseInt(sal);
            
             if(!username.equals("") && !pass.equals("") && !confirmPass.equals(""))
            {
                if(pass.equals(confirmPass))
                {
                    if(Cl.dbMgr.AddReceptionistRecord(username,pass,FName, LName, salInt,dob, gender, phn, hs, ct, zip, shft))
                    {
                                    
                        JOptionPane.showMessageDialog(null,"Receptionist account created Succesfully!!!","Receptionist",JOptionPane.INFORMATION_MESSAGE);
                        Cl.adminOptSet.optionFrame.setVisible(true);
                        Cl.receptionist.rptInputFrame.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"This username is already taken!!!","Duplicate Username",JOptionPane.ERROR_MESSAGE);
                        Cl.receptionist.tfUserName.setText("");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password and Confirm Password must be matched!!!","Password Confirmation",JOptionPane.ERROR_MESSAGE);
                    Cl.receptionist.tfCfmPassword.setText("");
                    Cl.receptionist.tfPassword.setText("");

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Field cannot be Empty!!","Empty Field",JOptionPane.ERROR_MESSAGE);
                Cl.receptionist.tfUserName.setText("");
                Cl.receptionist.tfCfmPassword.setText("");
                Cl.receptionist.tfPassword.setText("");
            }
           
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.receptionist.rptInputFrame.setVisible(false);
        }
    }
}
