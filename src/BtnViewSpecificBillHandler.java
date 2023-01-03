
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class BtnViewSpecificBillHandler implements ActionListener{

    ClinicController cl;
    public BtnViewSpecificBillHandler(ClinicController refgC) {
        cl=refgC;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Close"))
        {
            cl.viewPat.billFrame.setVisible(false);
            cl.rptOptionSet.optionFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("SIGN OUT"))
        {
            cl.viewPat.billFrame.setVisible(false);
            cl.rptSignIn.rptSignInFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("SEARCH"))
        {
            String optPat = cl.viewPat.patientId.getSelectedItem().toString();
            int patId= Integer.parseInt(optPat);
            
            cl.viewPat.billFrame.setVisible(false);
            cl.ViewSpecificBillPatient();
            cl.viewPat.patientId.setSelectedItem(optPat);
            int bill = cl.dbMgr.totalBill(patId);
            cl.viewPat.tfBill.setText(Integer.toString(bill));
            cl.viewPat.tableAdd(patId);
        }
        
    }
        
    
}

