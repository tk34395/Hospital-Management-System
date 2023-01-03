
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class ModesHandler implements ActionListener{
    ClinicController HC;
    
    public ModesHandler(ClinicController refHC)
    {
        HC = refHC;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Administrator Mode"))
        {
            HC.AdminSign();
            HC.modeObj.modeFrame.setVisible(false);
        }
        else if (e.getActionCommand().equals("Receptionist Mode"))
        {
            HC.ReceptionistSign();
            HC.modeObj.modeFrame.setVisible(false);
        }
        else if (e.getActionCommand().equals("EXIT"))
        {
            System.exit(0);
        }
    }
}
