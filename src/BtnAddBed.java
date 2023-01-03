
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
public class BtnAddBed implements ActionListener{
    ClinicController Cl;    
    
    public BtnAddBed(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("ADD"))
        {
            String Bedtype = Cl.bd.tfType.getText();
            String wrdNo = Cl.bd.wardNo.getSelectedItem().toString();
            int wrdInt = Integer.parseInt(wrdNo);
            Cl.dbMgr.AddBedRecord(wrdNo, wrdInt);
            JOptionPane.showMessageDialog(null,"Bed Added Succesfully!!!","Add Bed",JOptionPane.INFORMATION_MESSAGE);
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.bd.bedInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.adminOptSet.optionFrame.setVisible(true);
            Cl.bd.bedInputFrame.setVisible(false);
        }
    }
}
