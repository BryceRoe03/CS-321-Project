package org.openjfx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.text.*;

/**
 * JavaFX App
 */
public class Review extends Application {
    private BorderPane base = new BorderPane();
    private GridPane gridPane = new GridPane();
    private boolean accountShowing = false;

    // Used by home page
    public BorderPane reviewScreen() {
        return this.base;
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Review");
        this.base.setPadding(new Insets(10, 20, 10, 20));

        // GRID SET IN CENTER OF BORDER
        this.gridPane.setPadding(new Insets(5, 5, 5, 5));
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPane.setHgap(100);
        this.gridPane.setVgap(10);

        // Setting Grid stuff
        // Full Name
        Text fullNameText = new Text("Name: ");
        Text accName = new Text("[]");
        this.gridPane.add(fullNameText, 0, 0);
        this.gridPane.add(accName, 1, 0);

        // Email
        Text emailText = new Text("Email: ");
        Text accEmail = new Text("[]");
        this.gridPane.add(emailText, 0, 1);
        this.gridPane.add(accEmail, 1, 1);

        // Date of Birth
        Text dateOfBirthText = new Text("Date of Birth: ");
        Text accDateOfBirth = new Text("[]");
        this.gridPane.add(dateOfBirthText, 0, 2);
        this.gridPane.add(accDateOfBirth, 1, 2);

        // Gender
        Text genderText = new Text("Gender: ");
        Text accGender = new Text("[]");
        this.gridPane.add(genderText, 0, 3);
        this.gridPane.add(accGender, 1, 3);

        // Country of Origin
        Text countryOfOriginText = new Text("Country of Origin: ");
        Text accCountryOfOrigin = new Text("[]");
        this.gridPane.add(countryOfOriginText, 0, 4);
        this.gridPane.add(accCountryOfOrigin, 1, 4);

        // Medical History
        Text medicalHistoryText = new Text("Medical History: ");
        Text accMedicalHistory = new Text("[]");
        this.gridPane.add(medicalHistoryText, 0, 5);
        this.gridPane.add(accMedicalHistory, 1, 5);

        // Criminal Record
        Text criminalRecordText = new Text("Criminal Record: ");
        Text accCriminalRecord = new Text("[]");
        this.gridPane.add(criminalRecordText, 0, 6);
        this.gridPane.add(accCriminalRecord, 1, 6);

        // Reason for Entry
        Text reasonForEntryText = new Text("Reason for Entry: ");
        Text accReasonForEntry = new Text("[]");
        this.gridPane.add(reasonForEntryText, 0, 7);
        this.gridPane.add(accReasonForEntry, 1, 7);

        // Length of Stay
        Text lengthOfStayText = new Text("Length of Stay: ");
        Text acclengthOfStay = new Text("[]");
        this.gridPane.add(lengthOfStayText, 0, 8);
        this.gridPane.add(acclengthOfStay, 1, 8);

        // Username
        Text usernameText = new Text("Username: ");
        Text accUsername = new Text("[]");
        this.gridPane.add(usernameText, 0, 9);
        this.gridPane.add(accUsername, 1, 9);

        // Password
        Text passwordText = new Text("Password: ");
        Text accPassword = new Text("[]");
        this.gridPane.add(passwordText, 0, 10);
        this.gridPane.add(accPassword, 1, 10);

        // Alien Number
        Text alienNumberText = new Text("Alien Number: ");
        Text accAlienNumber = new Text("[]");
        this.gridPane.add(alienNumberText, 0, 11);
        this.gridPane.add(accAlienNumber, 1, 11);

        // ID in System
        Text idText = new Text("ID in System: ");
        Text accID = new Text("[]");
        this.gridPane.add(idText, 0, 12);
        this.gridPane.add(accID, 1, 12);

        // Status
        Text statusText = new Text("Current Status: ");
        Text accStatus = new Text("[]");
        this.gridPane.add(statusText, 0, 13);
        this.gridPane.add(accStatus, 1, 13);

        // Phone Number
        Text phoneNumText = new Text("Phone Number: ");
        Text accPhoneNum = new Text("[]");
        this.gridPane.add(phoneNumText, 0, 14);
        this.gridPane.add(accPhoneNum, 1, 14);

        // Additional Information
        Text extraText = new Text("Additional Information: ");
        Text accExtraInfo = new Text("[]");
        this.gridPane.add(extraText, 0, 15);
        this.gridPane.add(accExtraInfo, 1, 15);

        BorderPane.setAlignment(this.gridPane, Pos.CENTER);
        this.base.setCenter(this.gridPane);

        // BORDER BOTTOM
        HBox bar = new HBox(10);
        bar.setPrefWidth(100);
        bar.setAlignment(Pos.CENTER);
        Button nextApplicationButton = new Button("Next Application");
        Button clearButton = new Button("Clear");
        Button runTestButton = new Button("Run Tests");

        clearButton.setMinWidth(bar.getPrefWidth());
        runTestButton.setMinWidth(bar.getPrefWidth());
        nextApplicationButton.setMinWidth(bar.getPrefWidth());
        bar.getChildren().addAll(runTestButton, nextApplicationButton, clearButton);
        BorderPane.setAlignment(bar, Pos.CENTER);
        this.base.setBottom(bar);


        clearButton.setOnAction(e -> {
            accName.setText("");
            accEmail.setText("");
            accDateOfBirth.setText("");
            accGender.setText("");
            accCountryOfOrigin.setText("");
            accMedicalHistory.setText("");
            accCriminalRecord.setText("");
            accReasonForEntry.setText("");
            acclengthOfStay.setText("");
            accUsername.setText("");
            accPassword.setText("");
            accAlienNumber.setText("");
            accID.setText("");
            accStatus.setText("");
            accPhoneNum.setText("");
            accExtraInfo.setText("");
        });

        runTestButton.setOnAction(e -> {

            long currId = Long.parseLong(accID.getText());

            if (Account.dataReview(currId) == 0) {
                Workflow.updateWorkflowStatus(Status.APPROVAL, currId);
            }
            else {
                Workflow.updateWorkflowStatus(Status.FAIL, currId);
            }
        });

        nextApplicationButton.setOnAction(e -> {

            // Will delete after testing
            Workflow.updateWorkflowStatus(Status.REVIEW, 0);
            Workflow.updateWorkflowStatus(Status.REVIEW, 1);

            Account ac = null;
            long id = Workflow.getItemWithStatus(Status.REVIEW);
            ac = Account.getAccount(id);

            accName.setText(ac.getName());
            accEmail.setText(ac.getEmail());
            accDateOfBirth.setText(ac.getDOB().toString());
            switch (ac.getGender()) {
                case 0:
                    accGender.setText("Male");
                    break;
                case 1:
                    accGender.setText("Female");
                    break;
                case 2:
                    accGender.setText("Other");
                    break;
            }
            accCountryOfOrigin.setText(ac.getCountryOfOrigin());
            accMedicalHistory.setText(ac.getMedicalConditions());
            accCriminalRecord.setText(ac.getCriminalRecord().toString());
            switch (ac.getReasonForEntry()) {
                case 0:
                    accReasonForEntry.setText("Relocation");
                    break;
                case 1:
                    accReasonForEntry.setText("Visiting");
                    break;
                case 2:
                    accReasonForEntry.setText("Job Opportunity");
                    break;
                case 3:
                    accReasonForEntry.setText("Other");
                    break;
            }
            acclengthOfStay.setText(ac.getLengthOfIntendedStay());
            accUsername.setText(ac.getAccountUsername());
            accPassword.setText(ac.getAccountPassword());
            accAlienNumber.setText(Long.toString(ac.getAlienNumber()));
            accID.setText(Long.toString(ac.getIdInSystem()));
            switch (ac.getStatus().getStatus()) {
                case 1:
                    accStatus.setText("CREATED");
                    break;
                case 2:
                    accStatus.setText("REVIEW");
                    break;
                case 3:
                    accStatus.setText("APPROVAL");
                    break;
                case 4:
                    accStatus.setText("DONE");
                    break;
                case 5:
                    accStatus.setText("FAIL");
                    break;
            }
            accPhoneNum.setText(ac.getPhoneNumber().toString());
            accExtraInfo.setText(ac.getAdditionalInformation());
        });

    }


}
