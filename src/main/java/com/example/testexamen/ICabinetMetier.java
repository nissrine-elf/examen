package com.example.testexamen;

import java.util.List;

public interface ICabinetMetier {
public List<Patient> afficheAllPat();
public Patient recherchPat(int i);

public void addPat(Patient p);
public void suPat(int p);
public List<Consultation> listeConPat(int p);
public void addMed(Medecin m);
public List<Medecin> afficheallMed();
public void sumed(int m);
public List<Consultation> listeConMed(int m);
public void addCon(Consultation c);
public List<Consultation> listallCon();
public void supCon(int c);



}
