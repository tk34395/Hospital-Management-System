
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
public class ViewBtnHandler implements ActionListener{

    ClinicController cl;
    boolean isAdminMode;
    public ViewBtnHandler(ClinicController refgC) {
        cl=refgC;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("1") || e.getActionCommand().equals("11"))
        {
            cl.viewWard.wardFrame.setVisible(false);
            isAdminMode= cl.viewWard.isAdminMode;
        }
        else if(e.getActionCommand().equals("2") || e.getActionCommand().equals("21"))
        {
            cl.viewVREC.visitRecFrame.setVisible(false);
            isAdminMode= cl.viewVREC.isAdminMode;
        }
        else if(e.getActionCommand().equals("3") || e.getActionCommand().equals("31"))
        {
            cl.viewRecept.rptFrame.setVisible(false);
            isAdminMode= cl.viewRecept.isAdminMode;
        }
        else if(e.getActionCommand().equals("4")|| e.getActionCommand().equals("41"))
        {
            cl.viewPatient.pntFrame.setVisible(false);
            isAdminMode= cl.viewPatient.isAdminMode;
        }
        else if(e.getActionCommand().equals("5") || e.getActionCommand().equals("51"))
        {
            cl.viewNurse.nurseFrame.setVisible(false);
            isAdminMode= cl.viewNurse.isAdminMode;
        }
        else if(e.getActionCommand().equals("6")|| e.getActionCommand().equals("61"))
        {
            cl.viewDoc.docFrame.setVisible(false);
            isAdminMode= cl.viewDoc.isAdminMode;
        }
        else if(e.getActionCommand().equals("7")|| e.getActionCommand().equals("71"))
        {
            cl.viewBREC.bookingFrame.setVisible(false);
            isAdminMode= cl.viewBREC.isAdminMode;
        }
        else if(e.getActionCommand().equals("8")|| e.getActionCommand().equals("81"))
        {
            cl.viewBill.billFrame.setVisible(false);
            isAdminMode= cl.viewBill.isAdminMode;
        }
        else if(e.getActionCommand().equals("9")|| e.getActionCommand().equals("91"))
        {
            cl.viewbed.bedFrame.setVisible(false);
            isAdminMode= cl.viewbed.isAdminMode;
        }
        else if(e.getActionCommand().equals("10")|| e.getActionCommand().equals("101"))
        {
            cl.viewApt.aptFrame.setVisible(false);
            isAdminMode= cl.viewApt.isAdminMode;
        }
        int cmd = Integer.parseInt(e.getActionCommand());
        if(cmd > 10)
        {
            if(isAdminMode)
                cl.signObj.adminSignInFrame.setVisible(true);
            else
                cl.rptSignIn.rptSignInFrame.setVisible(true);
            
        }
        else if(cmd <= 10)
        {
            if(isAdminMode)
                cl.adminOptSet.optionFrame.setVisible(true);
            else
                cl.rptOptionSet.optionFrame.setVisible(true);
        }
    }
    
}
