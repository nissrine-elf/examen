package com.example.testexamen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ICabinetMetierImp implements ICabinetMetier{
    public List<Patient> afficheAllPat(){
        List<Patient> p=new ArrayList<>();
        Connection con=SignletonConnexionDB.getCon();
        try {
            Statement stm=con.createStatement();//int id_patient, String nom, String prenom, String cin, String telephone, String email, Date date_naissance)
            ResultSet rs=stm.executeQuery("select * from patient");
            while(rs.next()){
                Patient pp=new Patient(rs.getInt("id_pat"),rs.getString("nom"),rs.getString("prenom"),rs.getString("cin"),rs.getString("tele"),rs.getString("email"),rs.getDate("dat_nais"));
                p.add(pp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }
    public void addPat(Patient p){
        Connection con=SignletonConnexionDB.getCon();
        try{
            PreparedStatement pstm=con.prepareStatement("INSERT INTO patient (nom,prenom,cin,tele,email,date_nais) VALUES (?,?,?,?,?,?)");
            pstm.setString(1, p.getNom());
            pstm.setString(2, p.getPrenom());
            pstm.setString(3, p.getCin());
            pstm.setString(4, p.getTelephone());
            pstm.setString(5, p.getEmail());
            pstm.setDate(6, new java.sql.Date(p.getDate_naissance().getTime()));
            pstm.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }

    public void suPat(int p){
        Connection con=SignletonConnexionDB.getCon();
        try{
            PreparedStatement pstm1=con.prepareStatement("select * from consultation where id_pat=?");
            pstm1.setInt(1,p);
            ResultSet rs1=pstm1.executeQuery();
            while(rs1.next()){
                PreparedStatement pstm2=con.prepareStatement("update consultation set  id_pat =  NULL WHERE id_pat = ?");
                pstm2.setInt(1, p);
                pstm2.executeUpdate();
            }
            PreparedStatement pstm=con.prepareStatement(" delete from patient WHERE id_pat = ?");
            pstm.setInt(1, p);
            pstm.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}


    }
    public List<Consultation> listeConPat(int c){
        Connection con=SignletonConnexionDB.getCon();
        List<Consultation> cons=new ArrayList<>();
        try{
            PreparedStatement pstm=con.prepareStatement("select * from consultation where  id_pat= ?");
            pstm.setInt(1,c);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                PreparedStatement pstm1=con.prepareStatement("select * from patient where id_pat=?");
                pstm1.setInt(1,rs.getInt("id_pat"));
                ResultSet rs1=pstm1.executeQuery();
                Patient p=null;
                if(rs1.next()){p=new Patient(rs1.getInt("id_pat"),rs1.getString("nom"),rs1.getString("prenom"),rs1.getString("cin"),rs1.getString("tele"),rs1.getString("email"),rs1.getDate("dat_nais"));}
PreparedStatement pst4=con.prepareStatement("select * from medecin where id_med=?");
                pst4.setInt(1,rs.getInt("id_med"));
                ResultSet rs4=pst4.executeQuery();
                Medecin m=null;
                if(rs4.next()){
                    m=new Medecin(rs4.getInt("id_med"),rs4.getString("nom"),rs4.getString("prenom"),rs4.getString("email"),rs4.getString("tele"));
                }
               Consultation cc=new Consultation(rs.getInt("id_con"),rs.getDate("date"),p,m);
                cons.add(cc);
            }

        }catch (SQLException e){e.printStackTrace();}
        return cons;

    }
    public void addMed(Medecin m){
        Connection con=SignletonConnexionDB.getCon();
        try{
            PreparedStatement pstm=con.prepareStatement("INSERT INTO medecin (nom,prenom,email,tele) VALUES (?,?,?,?)");
            pstm.setString(1, m.getNom());
            pstm.setString(2, m.getPrenom());
            pstm.setString(3, m.getEmail());
            pstm.setString(4, m.getTel());

            pstm.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}


    }
    public List<Medecin> afficheallMed(){
        List<Medecin> m=new ArrayList<>();
        Connection con=SignletonConnexionDB.getCon();
        try {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from medecin");
            while(rs.next()){
                Medecin mm=new Medecin(rs.getInt("id_med"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("tele"));
                m.add(mm);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return m;


    }
    public void sumed(int m){
        Connection con=SignletonConnexionDB.getCon();
        try{
            PreparedStatement pstm1=con.prepareStatement("select * from consultation where id_med=?");
            pstm1.setInt(1,m);
            ResultSet rs1=pstm1.executeQuery();
            while(rs1.next()){
                PreparedStatement pstm2=con.prepareStatement("update consultation set  id_med =  NULL WHERE id_med = ?");
                pstm2.setInt(1, m);
                pstm2.executeUpdate();
            }
            PreparedStatement pstm=con.prepareStatement(" delete from medecin WHERE id_med = ?");
            pstm.setInt(1, m);
            pstm.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}

    }
    public List<Consultation> listeConMed(int m){
        Connection con=SignletonConnexionDB.getCon();
        List<Consultation> cons=new ArrayList<>();
        try{
            PreparedStatement pstm=con.prepareStatement("select * from consultation where  id_med= ?");
            pstm.setInt(1,m);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                PreparedStatement pstm1=con.prepareStatement("select * from patient where id_pat=?");
                pstm1.setInt(1,rs.getInt("id_pat"));
                ResultSet rs1=pstm1.executeQuery();
                Patient p=null;
                if(rs1.next()){p=new Patient(rs1.getInt("id_pat"),rs1.getString("nom"),rs1.getString("prenom"),rs1.getString("cin"),rs1.getString("tele"),rs1.getString("email"),rs1.getDate("dat_nais"));}
                PreparedStatement pst4=con.prepareStatement("select * from medecin where id_med=?");
                pst4.setInt(1,rs.getInt("id_med"));
                ResultSet rs4=pst4.executeQuery();
                Medecin mm=null;
                if(rs4.next()){
                    mm=new Medecin(rs4.getInt("id_med"),rs4.getString("nom"),rs4.getString("prenom"),rs4.getString("email"),rs4.getString("tele"));
                }
                Consultation cc=new Consultation(rs.getInt("id_con"),rs.getDate("date"),p,mm);
                cons.add(cc);
            }

        }catch (SQLException e){e.printStackTrace();}
        return cons;
    }
    public void addCon(Consultation c){
        Connection con=SignletonConnexionDB.getCon();
        try{
            PreparedStatement pstm=con.prepareStatement("INSERT INTO consultation ( date_con, id_pat,id_med) " +
                    "VALUES (?, ?, ?)");
            pstm.setDate(1,new java.sql.Date(c.getDate_consultation().getTime()) );
            pstm.setInt(2, c.getP().getId_patient());
            pstm.setInt(3, c.getM().getId_medecin());
            pstm.executeUpdate();

        }catch (SQLException e){e.printStackTrace();}


    }
    public List<Consultation> listallCon(){
        Connection con=SignletonConnexionDB.getCon();
        List<Consultation> cons=new ArrayList<>();
        try{
            PreparedStatement pstm=con.prepareStatement("select * from consultation ");
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                PreparedStatement pstm1=con.prepareStatement("select * from patient where id_pat=?");
                pstm1.setInt(1,rs.getInt("id_pat"));
                ResultSet rs1=pstm1.executeQuery();
                Patient p=null;
                if(rs1.next()){p=new Patient(rs1.getInt("id_pat"),rs1.getString("nom"),rs1.getString("prenom"),rs1.getString("cin"),rs1.getString("tele"),rs1.getString("email"),rs1.getDate("dat_nais"));}
                PreparedStatement pst4=con.prepareStatement("select * from medecin where id_med=?");
                pst4.setInt(1,rs.getInt("id_med"));
                ResultSet rs4=pst4.executeQuery();
                Medecin mm=null;
                if(rs4.next()){
                    mm=new Medecin(rs4.getInt("id_med"),rs4.getString("nom"),rs4.getString("prenom"),rs4.getString("email"),rs4.getString("tele"));
                }
                Consultation cc=new Consultation(rs.getInt("id_con"),rs.getDate("date"),p,mm);
                cons.add(cc);
            }

        }catch (SQLException e){e.printStackTrace();}
        return cons;
    }
    public void supCon(int c){
        Connection con=SignletonConnexionDB.getCon();
        try{
            PreparedStatement pstm=con.prepareStatement(" delete from consultation WHERE id_con = ?");
            pstm.setInt(1, c);
            pstm.executeUpdate();
        }catch (SQLException e){e.printStackTrace();}
    }
    public Patient recherchPat(int i){
        Patient p=null;
        Connection con=SignletonConnexionDB.getCon();
        try {
            PreparedStatement pts=con.prepareStatement("select * from patient where id_pat=?");
            pts.setInt(1,i);
            ResultSet rs=pts.executeQuery();
            while(rs.next()){
               p=new Patient(rs.getInt("id_pat"),rs.getString("nom"),rs.getString("prenom"),rs.getString("cin"),rs.getString("tele"),rs.getString("email"),rs.getDate("dat_nais"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;


    }
}
