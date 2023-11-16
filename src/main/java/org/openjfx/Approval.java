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
    public GridPane approvalScreen() {
        return this.grid;
    }

    @Override
    public void start(Stage stage) {

        // Account freddy = Account.addAccount("Feddy Faber", "urmom@gmail.com",
        // LocalDate.now(), 0, "USA", "None", new CriminalRecord(), 0, "None", "None",
        // "None", new PhoneNumber(1, 123456789), "None");
        // ArrayList<Account> acc = Account.getAccountList();
        Workflow w = Workflow.getWorkflow();
        long acc = w.getItemWithStatus(Status.APPROVAL);
        Account accView = null;
        Account.testPopulateList();
        accView = Account.getAccount(acc);

        // Setting column and row gap
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(10, 10, 10, 10));


        // Account Variable Headers

        // Name
        Text nameLabel = new Text("Name: ");
        Text accName = new Text(accView.getName());
        this.grid.add(nameLabel, 0, 0);
        this.grid.add(accName, 1, 0);

        // Email
        Text emailLabel = new Text("Email: ");
        Text accEmail = new Text(accView.getEmail());
        this.grid.add(emailLabel, 0, 1);
        this.grid.add(accEmail, 1, 1);

        // DOB
        Text dobLabel = new Text("Date of Birth: ");
        LocalDate date = accView.getDOB();
        Text accDOB = new Text("" + date.getMonth() + "/" + date.getDayOfMonth() + "/" + date.getYear());
        this.grid.add(dobLabel, 0, 2);
        this.grid.add(accDOB, 1, 2);

        // Gender
        Text genderLabel = new Text("Gender: ");
        Text accGender = new Text();
        if (accView.getGender() == 0) {
            accGender.setText("Male");
        } else if (accView.getGender() == 1) {
            accGender.setText("Female");
        } else if (accView.getGender() == 2) {
            accGender.setText("Other");
        }
        this.grid.add(genderLabel, 0, 3);
        this.grid.add(accGender, 1, 3);

        // Country of Origin
        Text countryLabel = new Text("Country of Origin: ");
        Text accCNT = new Text(accView.getCountryOfOrigin());
        this.grid.add(countryLabel, 0, 4);
        this.grid.add(accCNT, 1, 4);

        // Medical History
        Text medicalLabel = new Text("Medical History: ");
        Text accMD = new Text(accView.getMedicalConditions());
        this.grid.add(medicalLabel, 0, 5);
        this.grid.add(accMD, 1, 5);

        // Criminal Record
        Text crimLabel = new Text("Criminal Record: ");
        Text accCR = new Text(accView.getCriminalRecord().toString());
        this.grid.add(crimLabel, 0, 6);
        this.grid.add(accCR, 1, 6);

        // Reason for Entry
        Text reasonLabel = new Text("Reason for Entry: ");
        Text accEntry = new Text();
        if (accView.getReasonForEntry() == 0) {
            accEntry.setText("Relocation");
        } else if (accView.getGender() == 1) {
            accEntry.setText("Visiting");
        } else if (accView.getGender() == 2) {
            accEntry.setText("Job Opportunity");
        } else if (accView.getGender() == 3) {
            accEntry.setText("Other");
        }
        this.grid.add(reasonLabel, 0, 7);
        this.grid.add(accEntry, 1, 7);

        // Length of Stay
        Text lengthLabel = new Text("Length of Stay: ");
        Text accDuration = new Text(accView.getLengthOfIntendedStay());
        this.grid.add(lengthLabel, 0, 8);
        this.grid.add(accDuration, 1, 8);

        // Username
        Text userLabel = new Text("Username: ");
        Text accUN = new Text(accView.getAccountUsername());
        this.grid.add(userLabel, 0, 9);
        this.grid.add(accUN, 1, 9);

        // Password
        Text passLabel = new Text("Password: ");
        Text accPW = new Text(accView.getAccountPassword());
        this.grid.add(passLabel, 0, 10);
        this.grid.add(accPW, 1, 10);

        // Alien Number
        Text aNumLabel = new Text("Alien Number: ");
        Text accAlien = new Text(String.valueOf(accView.getAlienNumber()));
        this.grid.add(aNumLabel, 0, 11);
        this.grid.add(accAlien, 1, 11);

        // ID in System
        Text idLabel = new Text("ID in System: ");
        Text accID = new Text(String.valueOf(accView.getIdInSystem()));
        this.grid.add(idLabel, 0, 12);
        this.grid.add(accID, 1, 12);

        // Status
        Text statusLabel = new Text("Current Status: ");
        Text accStatus = new Text();
        // if ()
        this.grid.add(statusLabel, 0, 13);
        this.grid.add(accStatus, 1, 13);

        // Phone Number
        Text phoneLabel = new Text("Phone Number: ");
        Text accPnum = new Text("Null");
        this.grid.add(phoneLabel, 0, 14);
        this.grid.add(accPnum, 1, 14);

        // Additional Information
        Text extraLabel = new Text("Additional Information: ");
        Text accEX = new Text("Null");
        this.grid.add(extraLabel, 0, 15);
        this.grid.add(accEX, 1, 15);


        stage.setTitle("Account Approval Form");

        // Approve button
        Button btnApprove = new Button("Approve");
        btnApprove.setOnAction(
                // Make this update the workflow status
                e -> {
                    if (w.updateWorkflowStatus(Status.DONE, acc)) {
                        // accStatus.setText(Status.DONE.toString());
                    }
        });

        // Reject Button
        Button btnReject = new Button("Reject");
        btnReject.setOnAction(
                // Make this update the workflow status
                e -> {
                    if (w.updateWorkflowStatus(Status.FAIL, acc)) {
                        // accStatus.setText(accView.getStatus().toString());
                    }
                });

        // Clear button
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(
                // Clear everything
                e -> {
                    accName.setText("Null");
                    accEmail.setText("Null");
                    accDOB.setText("Null");
                    accGender.setText("Null");
                    accCNT.setText("Null");
                    accMD.setText("Null");
                    accCR.setText("Null");
                    accEntry.setText("Null");
                    accDuration.setText("Null");
                    accUN.setText("Null");
                    accPW.setText("Null");
                    accAlien.setText("Null");
                    accID.setText("Null");
                    accStatus.setText("Null");
                    accPnum.setText("Null");
                    accEX.setText("Null");
                });

        // Next button
        Button btnNext = new Button("Next");
        btnNext.setOnAction(
                // Make this update the workflow status
                e -> {
                    long AcID = w.getItemWithStatus(Status.APPROVAL);
                    Account accCurrent = null;
                    Account.testPopulateList();
                    accCurrent = Account.getAccount(AcID);

                    accName.setText(accCurrent.getName());
                    accEmail.setText(accCurrent.getEmail());
                    accDOB.setText(accCurrent.getDOB().toString());
                    if (accCurrent.getGender() == 0) {
                        accGender.setText("Male");
                    } else if (accCurrent.getGender() == 1) {
                        accGender.setText("Female");
                    } else if (accCurrent.getGender() == 2) {
                        accGender.setText("Other");
                    }
                    accLength.setText(accCurrent.getLengthOfIntendedStay());
                    accUser.setText(accCurrent.getAccountUsername());
                    accPass.setText(accCurrent.getAccountPassword());
                    accANum.setText(Long.toString(accCurrent.getAlienNumber()));
                    accID.setText(Long.toString(accCurrent.getIdInSystem()));
                });

        // Assemble the button bar
        ButtonBar bar = new ButtonBar();
        bar.getButtons().addAll(btnApprove, btnReject, btnClear, btnNext);

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
