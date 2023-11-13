package org.openjfx;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;  
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.*;

/**
 * JavaFX App
 */
public class Approval extends Application {
    GridPane grid = new GridPane(640, 680);
    // Used by home page
    public GridPane getGridPane() {
        return this.grid;
    }

    @Override
    public void start(Stage stage) {

        Account freddy = Account.addAccount("Feddy Faber", "urmom@gmail.com", LocalDate.now(), 0, "USA", "None", new CriminalRecord(), 0, "None", "None", "None", new PhoneNumber(1, 123456789), "None");
        ArrayList<Account> acc = Account.getAccountList();

        // Setting column and row gap
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(10, 10, 10, 10));


        // Account Variable Headers

        // Name
        Text nameLabel = new Text("Name: ");
        Text accName = new Text(acc.get(1).getName());
        this.grid.add(nameLabel, 0, 0);
        this.grid.add(accName, 1, 0);

        // Email
        Text emailLabel = new Text("Email: ");
        Text accEmail = new Text(acc.get(1).getEmail());
        this.grid.add(emailLabel, 0, 1);
        this.grid.add(accEmail, 1, 1);

        // DOB
        Text dobLabel = new Text("Date of Birth: ");
        Text accDOB = new Text("None");
        this.grid.add(dobLabel, 0, 2);
        this.grid.add(accDOB, 1, 2);

        // Gender
        Text genderLabel = new Text("Gender: ");
        Text accGender = new Text("None");
        this.grid.add(genderLabel, 0, 3);
        this.grid.add(accGender, 1, 3);

        // Country of Origin
        Text countryLabel = new Text("Country of Origin: ");
        Text accCount = new Text("Null");
        this.grid.add(countryLabel, 0, 4);
        this.grid.add(accCount, 1, 4);

        // Medical History
        Text medicalLabel = new Text("Medical History: ");
        Text accMed = new Text("Null");
        this.grid.add(medicalLabel, 0, 5);
        this.grid.add(accMed, 1, 5);

        // Criminal Record
        Text crimLabel = new Text("Criminal Record: ");
        Text accCrim = new Text("Null");
        this.grid.add(crimLabel, 0, 6);
        this.grid.add(accCrim, 1, 6);

        // Reason for Entry
        Text reasonLabel = new Text("Reason for Entry: ");
        Text accReason = new Text("Null");
        this.grid.add(reasonLabel, 0, 7);
        this.grid.add(accReason, 1, 7);

        // Length of Stay
        Text lengthLabel = new Text("Length of Stay: ");
        Text accLength = new Text("Null");
        this.grid.add(lengthLabel, 0, 8);
        this.grid.add(accLength, 1, 8);

        // Username
        Text userLabel = new Text("Username: ");
        Text accUser = new Text("Null");
        this.grid.add(userLabel, 0, 9);
        this.grid.add(accUser, 1, 9);

        // Password
        Text passLabel = new Text("Password: ");
        Text accPass = new Text("Null");
        this.grid.add(passLabel, 0, 10);
        this.grid.add(accPass, 1, 10);

        // Alien Number
        Text aNumLabel = new Text("Alien Number: ");
        Text accANum = new Text("Null");
        this.grid.add(aNumLabel, 0, 11);
        this.grid.add(accANum, 1, 11);

        // ID in System
        Text idLabel = new Text("ID in System: ");
        Text accID = new Text("Null");
        this.grid.add(idLabel, 0, 12);
        this.grid.add(accID, 1, 12);

        // Status
        Text statusLabel = new Text("Current Status: ");
        Text accStatus = new Text(acc.get(1).getStatus().toString());
        this.grid.add(statusLabel, 0, 13);
        this.grid.add(accStatus, 1, 13);

        // Phone Number
        Text phoneLabel = new Text("Phone Number: ");
        Text accPhone = new Text("Null");
        this.grid.add(phoneLabel, 0, 14);
        this.grid.add(accPhone, 1, 14);

        // Additional Information
        Text extraLabel = new Text("Additional Information: ");
        Text accExtra = new Text("Null");
        this.grid.add(extraLabel, 0, 15);
        this.grid.add(accExtra, 1, 15);


        stage.setTitle("Account Approval Form");
        Button btnApprove = new Button("Approve");
        btnApprove.setOnAction( e -> { 
            acc.get(1).setStatus(Status.DONE);
            accStatus.setText(acc.get(1).getStatus().toString());
        });
        Button btnReject = new Button("Reject");
        btnReject.setOnAction( e -> { 
            acc.get(1).setStatus(Status.FAIL);
            accStatus.setText(acc.get(1).getStatus().toString());
        });
        ButtonBar bar = new ButtonBar();
        bar.getButtons().addAll(btnApprove, btnReject);

        this.grid.add(bar, 0, 16, 1, 1);

        

        // Column constraints
        

        

        this.grid.setAlignment(Pos.CENTER);

        // Creation of dummy Account business object here

        
        // var scene = new Scene(this.grid, 640, 480);

        // stage.setScene(scene);
        // stage.show();
    }

    // public static void main(String[] args) {
    //     launch(args);
    // }

}
