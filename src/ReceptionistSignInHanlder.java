
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
public class ReceptionistSignInHanlder implements ActionListener{

    ClinicController HC;    
    
    public ReceptionistSignInHanlder(ClinicController refHC)
    {
        HC = refHC;            

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("OKAY"))
        {
            String rptName, rptPass;
            rptName = HC.rptSignIn.tfRpt.getText();
            rptPass= HC.rptSignIn.tfPswd.getText();
            if(HC.dbMgr.receptionSI(rptName, rptPass))
            {
                HC.rptSignIn.rptSignInFrame.setVisible(false);
                HC.ReceptionistModeStartUp(rptName, rptPass);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"You entered wrong credentials!!!","Wrong Credentials",JOptionPane.ERROR_MESSAGE);
            }
            HC.rptSignIn.tfRpt.setText("");
            HC.rptSignIn.tfPswd.setText("");
        }
        else if (e.getActionCommand().equals("BACK"))
        {
            HC.rptSignIn.rptSignInFrame.setVisible(false);
            HC.modeObj.modeFrame.setVisible(true);
        }
        
    }
    
}
