
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class ClinicDatabaseAccess {
    
    Connection conn;
    Statement st;
    ResultSet rs; 

    public ClinicDatabaseAccess() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic","root","");
            st = conn.createStatement();

            
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    
//    public String dateCurr()
//    {
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-d");
//            LocalDateTime now = LocalDateTime.now();
//            return dtf.format(now);
//    }
//    
//    public String dateConverter(String dateDob)
//    {
//        return dateDob;
//    }
//    
    
    public boolean adminSignUp(String usernameAdm,String passwordAdm)
    {
        try {
            rs = st.executeQuery("select username from administrator where username = '"+usernameAdm+"';" );
            if (!rs.next()) {
                st.executeUpdate("INSERT INTO administrator VALUES ('"+usernameAdm+"','"+passwordAdm+"')" );
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean AddReceptionistRecord(String username, String pass,String fname, 
            String Lname, int Sal, String dateStr, String gndr,
            String phn, String hsN, String city, String zip, String shift)
    {
        try {
             rs = st.executeQuery("select username from receptionist where username = '"+username+"';" );
            if (!rs.next()) {
                st.executeUpdate("Insert Into receptionist values(NULL, '"+username+"', '"+pass+"','"+fname+"','"+Lname+"',"+Sal+",'"+gndr+"','"+dateStr+"', '"+phn+"', '"+hsN+"', '"+city+"', '"+zip+"', '"+shift+"') ");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean adminSignIn(String usernameAdm,String passwordAdm)
    {
        try {
            rs = st.executeQuery("select * from administrator where username = '"+usernameAdm+"' and password = '"+passwordAdm+"';" );
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean receptionSI(String usernameRpt,String passwordRpt)
    {
        try {
            rs = st.executeQuery("select * from receptionist where username = '"+usernameRpt+"' and password = '"+passwordRpt+"';" );
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ResultSet getWardsNo()
    {
        try {
            rs = st.executeQuery("Select * from ward;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    
    public int countWards()
    {
        try {
            rs = st.executeQuery("select count(*) from ward");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public int totalBill(int pat)
    {
        try {
            rs = st.executeQuery("select sum(BILL_AMOUNT) from bill where P_ID = "+pat+"");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public int countDoctors()
    {
        try {
            rs = st.executeQuery("select count(*) from doctor");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public int countPatient()
    {
        try {
            rs = st.executeQuery("select count(*) from patient");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public void getReceptionistRecord()
    {
        try {
            rs = st.executeQuery("Select * from receptionist;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getNurseRecord()
    {
        try {
            rs = st.executeQuery("Select * from nurse;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getWardRecord()
    {
        try {
            rs = st.executeQuery("Select * from ward;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getDocInfoRecord()
    {
        try {
            rs = st.executeQuery("Select * from doctor;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getPatientInfoRecord()
    {
        try {
            rs = st.executeQuery("Select * from patient;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getBillRecord()
    {
        try {
            rs = st.executeQuery("Select * from bill;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
     public void getSpeceficBillRecord(int pat)
    {
        try {
            rs = st.executeQuery("Select * from bill where p_id = "+pat+"");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    public void getAppointmentRecord()
    {
        try {
            rs = st.executeQuery("Select * from appointment;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getVisitingRecord()
    {
        try {
            rs = st.executeQuery("Select * from visiting_record;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getBookingRecord()
    {
        try {
            rs = st.executeQuery("Select * from booking_record;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void getBedRecord()
    {
        try {
            rs = st.executeQuery("Select * from bed;");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void AddBedRecord(String tp, int wrdNumber)
    {
        try {
            st.executeUpdate("Insert Into Bed values(NULL,"+wrdNumber+",'"+tp+"',1) ");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AddDoctorRecord(String fname, String Lname, int Sal, String spec,String dateStr, String gndr,
            String phn, String hsN, String city, String zip, String shift)
    {
        try {
            st.executeUpdate("Insert Into Doctor values(Null,'"+fname+"','"+Lname+"',"+Sal+", '"+spec+"','"+gndr+"','"+dateStr+"', '"+phn+"', '"+shift+"', '"+hsN+"', '"+city+"', '"+zip+"') ");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public void AddNurseRecord(String fname, String Lname,int wrdNo, int Sal,String dateStr, String gndr,
            String phn, String hsN, String city, String zip, String shift)
    {
        try {
            st.executeUpdate("Insert Into Nurse values(NULL,'"+fname+"','"+Lname+"', "+wrdNo+",'"+gndr+"','"+dateStr+"', '"+phn+"',"+Sal+", '"+shift+"', '"+hsN+"', '"+city+"', '"+zip+"') ");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AddPatientRecord(String fname, String Lname,String disease, String dateStr, String gndr,
            String phn, String hsN, String city, String zip)
    {
        try {
            st.executeUpdate("Insert Into Patient values(Null,'"+fname+"','"+Lname+"', '"+disease+"', '"+phn+"','"+gndr+"','"+dateStr+"',  '"+hsN+"', '"+city+"', '"+zip+"') ");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AddAppointment(int doc, int pat,int fee)
    {
        try {
            rs = st.executeQuery("select apt_no from appointment where dr_id = "+doc+" and apt_date >= CURRENT_DATE();");
            String curr;
            int currnt =0, prev=0;
            boolean breakLoop = false;
            while(rs.next() && !breakLoop)
            {
                curr =rs.getString("1");
                currnt = Integer.parseInt(curr);
                if(currnt - prev >= 1)
                {
                    breakLoop = true;
                }
                else
                {
                    prev = currnt;
                }
            }
            if(currnt == prev && currnt == 12)
            {
                JOptionPane.showMessageDialog(null,"No appointment Available!!!","Appointment",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               prev=prev+1;
               st.executeUpdate("Insert Into appointment values(CURRENT_TIMESTAMP(),"+doc+", "+pat+","+prev+","+fee+") ");
               st.executeUpdate("Insert into bill values(NULL, "+pat+", "+fee+",CURRENT_TIMESTAMP() )");              
               JOptionPane.showMessageDialog(null,"Appointment # "+(prev)+" Booked sucessfully!!!","Bed",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bookBed(int days, int pat)
    {
        try {
            rs = st.executeQuery("select bed_no from bed where available=1;");
            String bedNo;
            if(rs.next())
            {
                bedNo= rs.getString("BED_NO");
                int bed_no= Integer.parseInt(bedNo);
                st.executeUpdate("Insert Into booking_record values("+bed_no+",CURRENT_TIMESTAMP() ,"+pat+", "+days+") ");
                rs = st.executeQuery("select w.WRD_CHAREGS from ward w, bed b where b.WRD_NO = w.WRD_NO and b.bed_no = "+bed_no+"");
                String chargesWrStr = "0";
                if(rs.next())
                {
                   chargesWrStr= rs.getString("WRD_CHAREGS");
                }
                int chargesWr = Integer.parseInt(chargesWrStr);
                st.executeUpdate("Insert into bill values(NULL, "+pat+", "+chargesWr * days+",CURRENT_TIMESTAMP() )");
                st.executeUpdate("Update bed set available =0 where bed_no = "+bed_no+"" );
                JOptionPane.showMessageDialog(null,"Bed # "+bed_no+" Booked sucessfully!!!","Bed",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"All beds are reserved!!!","No Bed",JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void AddWardRecord(int charges, int cap)
    {
        try {
            st.executeUpdate("insert into ward values(NULL, "+charges+", "+cap+");");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     public void AddVisitingRecord(int doc, int wrdno, int duration)
    {
        try {
            st.executeUpdate("insert into visiting_record values(CURRENT_TIMESTAMP(), "+doc+", "+wrdno+", "+duration+");");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void deActiviateAdmin(String username)
     {
        try {
            st.executeUpdate("delete from  administrator where username = '"+username+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void deActiviateRpt(String username)
     {
        try {
            st.executeUpdate("delete from  receptionist where username = '"+username+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public boolean adminUsername(String usernameAdm, String OldUsername)
    {
        try {
            rs = st.executeQuery("select username from administrator where username = '"+usernameAdm+"';" );
            if (!rs.next()) {
                st.executeUpdate("update administrator set username ='"+usernameAdm+"' where username = '"+OldUsername+"'" );
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public void adminPassword(String password, String username)
    {
        try {
            st.executeUpdate("update administrator set password ='"+password+"' where username = '"+username+"'" );

        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
     public boolean rptUsername(String usernameRpt, String OldUsername)
    {
        try {
            rs = st.executeQuery("select username from receptionist where username = '"+usernameRpt+"';" );
            if (!rs.next()) {
                st.executeUpdate("update receptionist set username ='"+usernameRpt+"' where username = '"+OldUsername+"'" );
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public void rptPassword(String password, String username)
    {
        try {
            st.executeUpdate("update receptionist set password ='"+password+"' where username = '"+username+"'" );

        } catch (SQLException ex) {
            Logger.getLogger(ClinicDatabaseAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
