
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
public class BtnAddWard implements ActionListener{
    ClinicController Cl;    
    
    public BtnAddWard(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("ADD"))
        {
            String capStr = Cl.ward.tfCapacity.getText();
            String charStr =  Cl.ward.tfCharges.getText();
            int capInt = Integer.parseInt(capStr);
            int chargesInt = Integer.parseInt(charStr);
            Cl.dbMgr.AddWardRecord(chargesInt, capInt);
            JOptionPane.showMessageDialog(null,"Ward Added Succesfully!!!","Ward",JOptionPane.INFORMATION_MESSAGE);
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.ward.wardInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.ward.wardInputFrame.setVisible(false);
        }
    }
}
