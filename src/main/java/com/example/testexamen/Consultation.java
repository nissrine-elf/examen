package com.example.testexamen;

import java.util.Date;

public class Consultation {
    //: int
    //− :date
    private int  id_consultation;
    private Date date_consultation;
    private  Patient p;
    private Medecin m;

    public Consultation(int id_consultation, Date date_consultation, Patient p, Medecin m) {
        this.id_consultation = id_consultation;
        this.date_consultation = date_consultation;
        this.p = p;
        this.m = m;
    }

    public int getId_consultation() {
        return id_consultation;
    }

    public void setId_consultation(int id_consultation) {
        this.id_consultation = id_consultation;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Medecin getM() {
        return m;
    }

    public void setM(Medecin m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id_consultation=" + id_consultation +
                ", date_consultation=" + date_consultation +
                ", p=" + p +
                ", m=" + m +
                '}';
    }
}
