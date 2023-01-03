
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.AbstractAction;
import javax.swing.Action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
public class ClinicController {
    
    Modes modeObj;   
    ModesHandler modeHnd;
    AdminSignMode signObj;
    AdminSignBtnHandler signHnd;
    ClinicDatabaseAccess dbMgr;
    ResultSet outputSet;
    AdminMode adminOptSet;
    AdminModeBtnHandler btnAdmin;
    ReceptionistSignIn rptSignIn;
    ReceptionistSignInHanlder rptSignInHnd;
    ReceptionistMode rptOptionSet;
    ReceptionistBtnHandler rptBtn;
    ViewReceptionist vwRpt;
    
    AddBed bd;
    BtnAddBed Btnbd;
    AddDoctor dc;
    BtnAddDoctor btnDC;
    AddNurse nurse;
    BtnAddNurse btnNurse;
    AddPatient patient;
    BtnAddPatient btnPatient;
    AddPatientRequirement patRequirement;
    BtnPatientRequirement BtnReq;
    AddWard ward;
    BtnAddWard BtnWard;
    AddVisitingRecord visitRecord;
    BtnVisitingRecord BtnVisit;
    AddReceptionist receptionist;
    BtnAddReceptionist btnReceptionist;
    
    ViewAppointment viewApt;
    ViewBedRecord viewbed;
    ViewBill viewBill;
    ViewBookingRecord viewBREC;
    ViewDoctorDetail viewDoc;
    ViewNurse viewNurse;
    ViewPatientInfo viewPatient;
    ViewVisitingRecord viewVREC;
    ViewWard viewWard;
    ViewReceptionist viewRecept;
    ViewBillPatient viewPat;
    BtnViewSpecificBillHandler BtnPatSpecific;
    
    ViewBtnHandler allViewsBtnManager;
    
    public ClinicController()
    {
        dbMgr = new ClinicDatabaseAccess();
        DefaultStart();
        allViewsBtnManager = new ViewBtnHandler(this);

    }
    
    public void DefaultStart()
    {
        modeObj= new Modes();
        modeHnd = new ModesHandler(this);
        modeObj.admMode.addActionListener(modeHnd);
        modeObj.rptMode.addActionListener(modeHnd);
        modeObj.exitBtn.addActionListener(modeHnd);
        
        modeObj.modeFrame.setVisible(true);
    }
    
    public void AdminSign()
    {
        signObj = new AdminSignMode();
        signHnd=new AdminSignBtnHandler(this);
        signObj.btnBACK.addActionListener(signHnd);
        signObj.btnBCK.addActionListener(signHnd);
        signObj.btnDONE.addActionListener(signHnd);
        signObj.btnOKAY.addActionListener(signHnd);
        signObj.btnSignUp.addActionListener(signHnd);
        
        signObj.adminSignInFrame.setVisible(true);
    }
    
    public void ReceptionistSign()
    {
        rptSignIn = new ReceptionistSignIn();
        rptSignInHnd=new ReceptionistSignInHanlder(this);
        rptSignIn.btnBACK.addActionListener(rptSignInHnd);
        rptSignIn.btnOKAY.addActionListener(rptSignInHnd);
        
        rptSignIn.rptSignInFrame.setVisible(true);
    }
    
    
    
    public void ReceptionistModeStartUp(String rptName, String rptPass)
    {
        rptOptionSet= new ReceptionistMode(rptName, rptPass);
        rptBtn = new ReceptionistBtnHandler(this);
        rptOptionSet.patientAdd.addActionListener(rptBtn);
        rptOptionSet.patientAptView.addActionListener(rptBtn);
        rptOptionSet.patientWardView.addActionListener(rptBtn);
        rptOptionSet.viewBedInfo.addActionListener(rptBtn);
        rptOptionSet.viewVRECDoc.addActionListener(rptBtn);
        rptOptionSet.addDocVisit.addActionListener(rptBtn);
        rptOptionSet.viewBillTransaction.addActionListener(rptBtn);
        rptOptionSet.viewBillPat.addActionListener(rptBtn);
        rptOptionSet.btnSignOut.addActionListener(rptBtn);
        rptOptionSet.dltRpt.addActionListener(rptBtn);
        rptOptionSet.docPersonalInfo.addActionListener(rptBtn);
        rptOptionSet.passChange.addActionListener(rptBtn);
        rptOptionSet.viewWard.addActionListener(rptBtn);
        rptOptionSet.nameChange.addActionListener(rptBtn);
        rptOptionSet.patientRq.addActionListener(rptBtn);
        
        
        rptOptionSet.optionFrame.setVisible(true);
    }
    
    public void AdminModeStartUp(String admName, String admPass)
    {
        adminOptSet= new AdminMode(admName, admPass);
        btnAdmin = new AdminModeBtnHandler(this);
        
        adminOptSet.addRec.addActionListener(btnAdmin);
        adminOptSet.viewRec.addActionListener(btnAdmin);
        
        adminOptSet.viewVRECDoc.addActionListener(btnAdmin);
        adminOptSet.docPersonalInfo.addActionListener(btnAdmin);
        adminOptSet.addDoc.addActionListener(btnAdmin);
        
        adminOptSet.viewNurse.addActionListener(btnAdmin);
        adminOptSet.addNurse.addActionListener(btnAdmin);
        
        adminOptSet.viewBedOpt.addActionListener(btnAdmin);
        adminOptSet.viewWard.addActionListener(btnAdmin);
        adminOptSet.addWard.addActionListener(btnAdmin);
        adminOptSet.addBedOpt.addActionListener(btnAdmin);
        
        adminOptSet.patientAptView.addActionListener(btnAdmin);
        adminOptSet.patientBill.addActionListener(btnAdmin);
        adminOptSet.patientInfo.addActionListener(btnAdmin);
        adminOptSet.patientWardView.addActionListener(btnAdmin);
        
        adminOptSet.passChange.addActionListener(btnAdmin);
        adminOptSet.nameChange.addActionListener(btnAdmin);
        
        adminOptSet.dltAdmin.addActionListener(btnAdmin);
        adminOptSet.btnSignOut.addActionListener(btnAdmin);
        
        //
        adminOptSet.optionFrame.setVisible(true);
    }
    
    public void addReceptionistRecord()
    {
        receptionist=new AddReceptionist();
        btnReceptionist=new BtnAddReceptionist(this);
        receptionist.btnBack.addActionListener(btnReceptionist);
        receptionist.btnCreate.addActionListener(btnReceptionist);
        receptionist.rptInputFrame.setVisible(true);
    }
    
    public void ViewReceptionRecord(boolean isAdminMode)
    {
        viewRecept = new ViewReceptionist(this,isAdminMode);
        viewRecept.btnClose.addActionListener(allViewsBtnManager);
        viewRecept.btnSignOut.addActionListener(allViewsBtnManager);
        viewRecept.rptFrame.setVisible(true);
    }
    
    public void ViewDoctorRecordInfo(boolean isAdminMode)
    {
        viewDoc = new ViewDoctorDetail(this,isAdminMode);
        viewDoc.btnClose.addActionListener(allViewsBtnManager);
        viewDoc.btnSignOut.addActionListener(allViewsBtnManager);
        viewDoc.docFrame.setVisible(true);
    }
    
    public void ViewVisitingRecordInfo(boolean isAdminMode)
    {
        viewVREC = new ViewVisitingRecord(this,isAdminMode);
        viewVREC.btnClose.addActionListener(allViewsBtnManager);
        viewVREC.btnSignOut.addActionListener(allViewsBtnManager);
        viewVREC.visitRecFrame.setVisible(true);
    }
    
    public void ViewAppointmentRecordInfo(boolean isAdminMode)
    {
        viewApt = new ViewAppointment(this, isAdminMode);
        viewApt.btnClose.addActionListener(allViewsBtnManager);
        viewApt.btnSignOut.addActionListener(allViewsBtnManager);
        viewApt.aptFrame.setVisible(true);
    }
    
    public void AddDoctorRecordInfo()
    {
        dc = new AddDoctor();
        btnDC = new BtnAddDoctor(this);
        dc.btnAdd.addActionListener(btnDC);
        dc.btnBack.addActionListener(btnDC);
        dc.docInputFrame.setVisible(true);
    }
    
    public void ViewNurseRecord(boolean isAdminMode)
    {
        viewNurse = new ViewNurse(this,isAdminMode);
        viewNurse.btnClose.addActionListener(allViewsBtnManager);
        viewNurse.btnSignOut.addActionListener(allViewsBtnManager);
        viewNurse.nurseFrame.setVisible(true);
    }
    
    public void AddNurseInfo()
    {
        nurse = new AddNurse(this);
        btnNurse = new BtnAddNurse(this);
        nurse.btnCreate.addActionListener(btnNurse);
        nurse.btnBack.addActionListener(btnNurse);
        nurse.nurseInputFrame.setVisible(true);
    }
    
    public void AddBedInfo()
    {
        bd = new AddBed(this);
        Btnbd = new BtnAddBed(this);
        bd.btnAdd.addActionListener(Btnbd);
        bd.btnBack.addActionListener(Btnbd);
        bd.bedInputFrame.setVisible(true);
    }
    
    public void addWardInfo()
    {
        ward = new AddWard();
        BtnWard = new BtnAddWard(this);
        ward.btnAdd.addActionListener(BtnWard);
        ward.btnBack.addActionListener(BtnWard);
        ward.wardInputFrame.setVisible(true);
    }
    
    public void viewWardInfo(boolean isAdminMode)
    {
        viewWard = new ViewWard(this,isAdminMode);
        viewWard.btnClose.addActionListener(allViewsBtnManager);
        viewWard.btnSignOut.addActionListener(allViewsBtnManager);
        viewWard.wardFrame.setVisible(true);
    }
    
    public void viewBedInfo(boolean isAdminMode)
    {
        viewbed = new ViewBedRecord(this,isAdminMode);
        viewbed.btnClose.addActionListener(allViewsBtnManager);
        viewbed.btnSignOut.addActionListener(allViewsBtnManager);
        viewbed.bedFrame.setVisible(true);
    }
    
    public void ViewPatientInfo(boolean isAdminMode)
    {
        viewPatient = new ViewPatientInfo(this,isAdminMode);
        viewPatient.btnClose.addActionListener(allViewsBtnManager);
        viewPatient.btnSignOut.addActionListener(allViewsBtnManager);
        viewPatient.pntFrame.setVisible(true);
    }
    
    public void ViewBill(boolean isAdminMode) //
    {
        viewBill = new ViewBill(this,isAdminMode);
        viewBill.btnClose.addActionListener(allViewsBtnManager);
        viewBill.btnSignOut.addActionListener(allViewsBtnManager);
        viewBill.billFrame.setVisible(true);
    
    }
    
    public void ViewBookingRecord(boolean isAdminMode)
    {
        viewBREC = new ViewBookingRecord(this,isAdminMode);
        viewBREC.btnClose.addActionListener(allViewsBtnManager);
        viewBREC.btnSignOut.addActionListener(allViewsBtnManager);
        viewBREC.bookingFrame.setVisible(true);
    }
    
    public void ViewVisitingRecord(boolean isAdminMode)
    {
        viewVREC = new ViewVisitingRecord(this,isAdminMode);
        viewVREC.btnClose.addActionListener(allViewsBtnManager);
        viewVREC.btnSignOut.addActionListener(allViewsBtnManager);
        viewVREC.visitRecFrame.setVisible(true);
    }
    
    public void AddPatientInfo()
    {
        patient = new AddPatient();
        btnPatient = new BtnAddPatient(this);
        patient.btnAdd.addActionListener(btnPatient);
        patient.btnBack.addActionListener(btnPatient);
        patient.patientInputFrame.setVisible(true);
    }
    
    public void addRequirementInfo()
    {
        patRequirement = new AddPatientRequirement(this);
        BtnReq = new BtnPatientRequirement(this);
        patRequirement.btnApt.addActionListener(BtnReq);
        patRequirement.btnBack1.addActionListener(BtnReq);
        patRequirement.btnBack2.addActionListener(BtnReq);
        patRequirement.btnBack4.addActionListener(BtnReq);
        patRequirement.btnBed.addActionListener(BtnReq);
        patRequirement.btnBook.addActionListener(BtnReq);
        patRequirement.btnBook1.addActionListener(BtnReq);
        patRequirement.rqFrame.setVisible(true);
    }
    
    public void AddVisitingInfo()
    {
        visitRecord = new AddVisitingRecord(this);
        BtnVisit = new BtnVisitingRecord(this);
        visitRecord.btnAdd.addActionListener(BtnVisit);
        visitRecord.btnBack.addActionListener(BtnVisit);
        visitRecord.visitInputFrame.setVisible(true);
    }
    
    public void ViewSpecificBillPatient()
    {
        viewPat = new ViewBillPatient(this);
        BtnPatSpecific = new BtnViewSpecificBillHandler(this);
        viewPat.btnClose.addActionListener(BtnPatSpecific);
        viewPat.btnSearch.addActionListener(BtnPatSpecific);
        viewPat.btnSignOut.addActionListener(BtnPatSpecific);
        viewPat.billFrame.setVisible(true);
    }
    
}


