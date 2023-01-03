
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AdminSignBtnHandler implements ActionListener{
    ClinicController HC;    
    
    public AdminSignBtnHandler(ClinicController refHC)
    {
        HC = refHC;            

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("OKAY"))
        {
            String admName, admPass;
            admName = HC.signObj.tfAdm.getText();
            admPass= HC.signObj.tfPswd.getText();
            if(HC.dbMgr.adminSignIn(admName, admPass))
            {
                HC.signObj.adminSignInFrame.setVisible(false);
                HC.AdminModeStartUp(admName, admPass);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"You entered wrong credentials!!!","Wrong Credentials",JOptionPane.ERROR_MESSAGE);
            }
            HC.signObj.tfAdm.setText("");
            HC.signObj.tfPswd.setText("");
        }
        else if (e.getActionCommand().equals("BACK"))
        {
            HC.signObj.adminSignInFrame.setVisible(false);
            HC.modeObj.modeFrame.setVisible(true);
        }
        else if (e.getActionCommand().equals("SIGN UP"))
        {
            HC.signObj.adminSignInFrame.setVisible(false);
            HC.signObj.adminSignUpFrame.setVisible(true);

        }
        else if (e.getActionCommand().equals("BACK "))
        {
            HC.signObj.adminSignUpFrame.setVisible(false);
            HC.signObj.adminSignInFrame.setVisible(true);
        }
        else if (e.getActionCommand().equals("DONE"))
        {
            String admName, admPass, admConfirmPass;
            admName = HC.signObj.tfAdmSU.getText();
            admPass = HC.signObj.tfPswdSU.getText();
            admConfirmPass = HC.signObj.tfPswdConfirm.getText();
            
            if(!admName.equals("") && !admPass.equals("") && !admConfirmPass.equals(""))
            {
                if(admPass.equals(admConfirmPass))
                {
                    if(admPass.length() < 8)
                    {
                        JOptionPane.showMessageDialog(null,"Password Length should be greater than 7!!","Password Length",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        if(HC.dbMgr.adminSignUp(admName, admPass))
                        {
                            JOptionPane.showMessageDialog(null, "Account Created!!!", "Hurrah!!!", JOptionPane.INFORMATION_MESSAGE);
                            HC.signObj.adminSignUpFrame.setVisible(false);
                            HC.signObj.adminSignInFrame.setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"This username is already taken!!!","Duplicate Username",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password and Confirm Password must be matched!!!","Password Confirmation",JOptionPane.ERROR_MESSAGE);

                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Field cannot be Empty!!","Empty Field",JOptionPane.ERROR_MESSAGE);

            }
            
            HC.signObj.tfAdmSU.setText("");
            HC.signObj.tfPswdSU.setText("");
            HC.signObj.tfPswdConfirm.setText("");
        }
    }
}
