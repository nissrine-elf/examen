package com.example.testexamen;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class HelloController {
    @FXML
    private TextField nomP, prenom, email, cin, tele;
    @FXML
    private DatePicker date_nais;

    @FXML
    private TableView<?> tablpr;
    @FXML private TableColumn<Patient, String> clNm;
    @FXML private TableColumn<Patient, String> clPnm;
    @FXML private TableColumn<Patient, String> clEm;
    @FXML private TableColumn<Patient, String> clcin;
    @FXML private TableColumn<Patient, Date> clDt;
    @FXML private TableColumn<Patient, String> cltel;
    private ICabinetMetierImp mp;
    public void initialize(){
        mp= new ICabinetMetierImp();
        clNm.setCellValueFactory(new PropertyValueFactory<>("nom"));
        clEm.setCellValueFactory(new PropertyValueFactory<>("email"));
        clDt.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
        clPnm.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        clcin.setCellValueFactory(new PropertyValueFactory<>("cin"));
cltel.setCellValueFactory(new PropertyValueFactory<>("telephone"));





    }




}