
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
public class BtnVisitingRecord implements ActionListener{
    ClinicController Cl;    
    
    public BtnVisitingRecord(ClinicController refC)
    {
        Cl = refC;            

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("ADD"))
        {
            String docStr = Cl.visitRecord.docId.getSelectedItem().toString();
            String wrdNoStr = Cl.visitRecord.wardNo.getSelectedItem().toString();
            String durStr = Cl.visitRecord.tDuration.getText();
            
            int docInt = Integer.parseInt(docStr);
            int wrdno = Integer.parseInt(wrdNoStr);
            int duration = Integer.parseInt(durStr);
            Cl.dbMgr.AddVisitingRecord(docInt,wrdno,duration);
            JOptionPane.showMessageDialog(null,"Visting Appointment Fixed Succesfully!!!","Visiting Record",JOptionPane.INFORMATION_MESSAGE);
            Cl.rptOptionSet.optionFrame.setVisible(true);
            Cl.visitRecord.visitInputFrame.setVisible(false);
        }
        else if(e.getActionCommand().equals("BACK"))
        {
            Cl.rptOptionSet.optionFrame.setVisible(true);
            Cl.visitRecord.visitInputFrame.setVisible(false);
        }
    }
}
