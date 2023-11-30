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
    public void start(Stage mainStage) {    

        // Account freddy = Account.addAccount("Feddy Faber", "urmom@gmail.com",
        // LocalDate.now(), 0, "USA", "None", new CriminalRecord(), 0, "None", "None",
        // "None", new PhoneNumber(1, 123456789), "None");
        // ArrayList<Account> acc = Account.getAccountList();
        Workflow w = Workflow.getWorkflow();

        Workflow.updateWorkflowStatus(Status.APPROVAL, 0);
        Workflow.updateWorkflowStatus(Status.APPROVAL, 1);
        long imm = w.getItemWithStatus(Status.APPROVAL);
        Account immView = null;
        immView = Account.getAccount(imm);

        // Setting column and row gap
        this.grid.setHgap(10);
        this.grid.setVgap(10);
        this.grid.setPadding(new Insets(10, 10, 10, 10));


        // Account Variable Headers

        // Display and Set Name
        Text tagName = new Text("Full Name: ");
        Text immName = new Text(immView.getName());
        this.grid.add(tagName, 0, 0);
        this.grid.add(immName, 1, 0);

        // Display and Set Email
        Text tagE = new Text("Email Address: ");
        Text immEM = new Text(immView.getEmail());
        this.grid.add(tagE, 0, 1);
        this.grid.add(immEM, 1, 1);

        // Display and Set DOB
        Text tagBirth = new Text("Birthday: ");
        LocalDate date = immView.getDOB();
        Text immDate = new Text("" + date.getMonth() + "/" + date.getDayOfMonth() + "/" + date.getYear());
        this.grid.add(tagBirth, 0, 2);
        this.grid.add(immDate, 1, 2);

        // Display and Set Gender
        Text tagGender = new Text("Gender: ");
        Text immGender = new Text();
        if (immView.getGender() == 0) {
            immGender.setText("Male");
        } else if (immView.getGender() == 1) {
            immGender.setText("Female");
        } else if (immView.getGender() == 2) {
            immGender.setText("Other");
        }
        this.grid.add(tagGender, 0, 3);
        this.grid.add(immGender, 1, 3);

        // Display and Set Country of Origin
        Text tagCNT = new Text("Country of Origin: ");
        Text immCNT = new Text(immView.getCountryOfOrigin());
        this.grid.add(tagCNT, 0, 4);
        this.grid.add(immCNT, 1, 4);

        // Display and Set Medical History
        Text tagMD = new Text("Medical History: ");
        Text immMD = new Text(immView.getMedicalConditions());
        this.grid.add(tagMD, 0, 5);
        this.grid.add(immMD, 1, 5);

        // Display and Set Criminal Record
        Text tagCR = new Text("Criminal Record: ");
        Text immCR = new Text(immView.getCriminalRecord().toString());
        this.grid.add(tagCR, 0, 6);
        this.grid.add(immCR, 1, 6);

        // Display and Set Reason for Entry
        Text tagEntry = new Text("Reason for Entry: ");
        Text immEntry = new Text();
        if (immView.getReasonForEntry() == 0) {
            immEntry.setText("Relocation");
        } else if (immView.getReasonForEntry() == 1) {
            immEntry.setText("Visiting");
        } else if (immView.getReasonForEntry() == 2) {
            immEntry.setText("Job Opportunity");
        } else if (immView.getReasonForEntry() == 3) {
            immEntry.setText("Other");
        }

        this.grid.add(tagEntry, 0, 7);
        this.grid.add(immEntry, 1, 7);

        // Display and Set Length of Stay
        Text tagDuration = new Text("Length of Stay: ");
        Text immDuration = new Text(immView.getLengthOfIntendedStay());
        this.grid.add(tagDuration, 0, 8);
        this.grid.add(immDuration, 1, 8);

        // Display and Set Username
        Text tagUN = new Text("Username: ");
        Text immUN = new Text(immView.getAccountUsername());
        this.grid.add(tagUN, 0, 9);
        this.grid.add(immUN, 1, 9);

        // Display and Set Password
        Text tagPW = new Text("Password: ");
        Text immPW = new Text(immView.getAccountPassword());
        this.grid.add(tagPW, 0, 10);
        this.grid.add(immPW, 1, 10);

        // Display and Set Alien Number
        Text tagAlien = new Text("Alien Number: ");
        Text immAlien = new Text(String.valueOf(immView.getAlienNumber()));
        this.grid.add(tagAlien, 0, 11);
        this.grid.add(immAlien, 1, 11);

        // Display and Set ID in System
        Text tagID = new Text("ID in System: ");
        Text immID = new Text(String.valueOf(immView.getIdInSystem()));
        this.grid.add(tagID, 0, 12);
        this.grid.add(immID, 1, 12);

        // Display and Set Status
        Text tagST = new Text("Current Status: ");
        Text immST = new Text();
        if (immView.getStatus().getStatus() == 3) {
            immST.setText("Approval");
        }
        else if (immView.getStatus().getStatus() == 4) {
            immST.setText("Done");
        }
        else if (immView.getStatus().getStatus() == 5) {
            immST.setText("Fail");
        }
        this.grid.add(tagST, 0, 13);
        this.grid.add(immST, 1, 13);

        // Display and Set Phone Number
        Text tagPnum = new Text("Phone Number: ");
        Text immPnum = new Text(immView.getPhoneNumber().toString());
        this.grid.add(tagPnum, 0, 14);
        this.grid.add(immPnum, 1, 14);

        // Display and Set Additional Information
        Text tagEX = new Text("Additional Information: ");
        Text immEX = new Text(immView.getAdditionalInformation().toString());
        this.grid.add(tagEX, 0, 15);
        this.grid.add(immEX, 1, 15);


        mainStage.setTitle("Account Approval Form");

        // Approve button
        Button btnApprove = new Button("Approve");
        btnApprove.setOnAction(
                // Make this update the workflow status
                e -> {
                    long AcID = Workflow.getItemWithStatus(Status.APPROVAL);
                    if (Account.dataApprove(AcID) >= 0L) {
                        immST.setText("Done");
                        Workflow.updateWorkflowStatus(Status.DONE, AcID);
                    }
                    else {
                        immST.setText("Fail");
                        Workflow.updateWorkflowStatus(Status.FAIL, AcID);
                    }
        });

        // Reject Button
        Button btnReject = new Button("Reject");
        btnReject.setOnAction(
                // Make this update the workflow status
                e -> {
                    long AcID = Workflow.getItemWithStatus(Status.APPROVAL);
                    boolean success = Workflow.updateWorkflowStatus(Status.FAIL, AcID);
                    if (success) {
                        immST.setText("Fail");
                    }
                });

        // Clear button
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(
                // Clear everything
                e -> {
                    immEM.setText("Null");
                    immDate.setText("Null");
                    immMD.setText("Null");
                    immGender.setText("Null");
                    immCNT.setText("Null");
                    immCR.setText("Null");
                    immEX.setText("Null");
                    immID.setText("Null");
                    immEntry.setText("Null");
                    immDuration.setText("Null");
                    immUN.setText("Null");
                    immPW.setText("Null");
                    immAlien.setText("Null");
                    immST.setText("Null");
                    immPnum.setText("Null");
                    immName.setText("Null");
                });

        // Next button
        Button btnNext = new Button("Next");
        btnNext.setOnAction(
                // Make this update the workflow status
                e -> {
                    //Workflow newW = Workflow.getWorkflow();


                    //Workflow.updateWorkflowStatus(Status.APPROVAL, 1);
                    long AcID = Workflow.getItemWithStatus(Status.APPROVAL);
                    Account immCurrent = null;
                    immCurrent = Account.getAccount(AcID);

                    if (immCurrent == null) {
                        immEM.setText("Null");
                        immDate.setText("Null");
                        immMD.setText("Null");
                        immGender.setText("Null");
                        immCNT.setText("Null");
                        immCR.setText("Null");
                        immEX.setText("Null");
                        immID.setText("Null");
                        immEntry.setText("Null");
                        immDuration.setText("Null");
                        immUN.setText("Null");
                        immPW.setText("Null");
                        immAlien.setText("Null");
                        immST.setText("Null");
                        immPnum.setText("Null");
                        immName.setText("Null");
                    }
                    else {
                        immName.setText(immCurrent.getName());
                        immEM.setText(immCurrent.getEmail());

                        LocalDate birth = immCurrent.getDOB();
                        immDate.setText("" + birth.getMonth() + "/" + birth.getDayOfMonth() + "/" + birth.getYear());
                        if (immCurrent.getGender() == 0) {
                            immGender.setText("Male");
                        } else if (immCurrent.getGender() == 1) {
                            immGender.setText("Female");
                        } else if (immCurrent.getGender() == 2) {
                            immGender.setText("Other");
                        }
                        immCNT.setText(immCurrent.getCountryOfOrigin());
                        immDuration.setText(immCurrent.getLengthOfIntendedStay());
                        immUN.setText(immCurrent.getAccountUsername());
                        immPW.setText(immCurrent.getAccountPassword());
                        immAlien.setText(Long.toString(immCurrent.getAlienNumber()));
                        immID.setText(Long.toString(immCurrent.getIdInSystem()));
                        if (immCurrent.getReasonForEntry() == 0) {
                            immEntry.setText("Relocation");
                        } else if (immCurrent.getReasonForEntry() == 1) {
                            immEntry.setText("Visiting");
                        } else if (immCurrent.getReasonForEntry() == 2) {
                            immEntry.setText("Job Opportunity");
                        } else if (immCurrent.getReasonForEntry() == 3) {
                            immEntry.setText("Other");
                        }
                        if (immCurrent.getStatus().getStatus() == 3) {
                            immST.setText("Approval");
                        }
                        else if (immCurrent.getStatus().getStatus() == 4) {
                            immST.setText("Done");
                        }
                        else if (immCurrent.getStatus().getStatus() == 5) {
                            immST.setText("Fail");
                        }
                        immPnum.setText(immCurrent.getPhoneNumber().toString());
                        immEX.setText(immCurrent.getAdditionalInformation().toString());
                        immMD.setText(immCurrent.getMedicalConditions());
                        immCR.setText(immCurrent.getCriminalRecord().toString());
                    }
                });

        // Assemble the button bar
        ButtonBar bar = new ButtonBar();
        bar.getButtons().addAll(btnApprove, btnReject, btnClear, btnNext);

        this.grid.add(bar, 0, 16, 1, 1);

        

        // Column constraints
        

        

        this.grid.setAlignment(Pos.CENTER);

    }

}
