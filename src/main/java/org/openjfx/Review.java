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

        // Grid stuff
        // Name
        Text nameLabel = new Text("Name: ");
        Text accName = new Text("[]");
        this.gridPane.add(nameLabel, 0, 0);
        this.gridPane.add(accName, 1, 0);

        // Email
        Text emailLabel = new Text("Email: ");
        Text accEmail = new Text("[]");
        this.gridPane.add(emailLabel, 0, 1);
        this.gridPane.add(accEmail, 1, 1);

        // DOB
        Text dobLabel = new Text("Date of Birth: ");
        Text accDOB = new Text("[]");
        this.gridPane.add(dobLabel, 0, 2);
        this.gridPane.add(accDOB, 1, 2);

        // Gender
        Text genderLabel = new Text("Gender: ");
        Text accGender = new Text("[]");
        this.gridPane.add(genderLabel, 0, 3);
        this.gridPane.add(accGender, 1, 3);

        // Country of Origin
        Text countryLabel = new Text("Country of Origin: ");
        Text accCountry = new Text("[]");
        this.gridPane.add(countryLabel, 0, 4);
        this.gridPane.add(accCountry, 1, 4);

        // Medical History
        Text medicalLabel = new Text("Medical History: ");
        Text accMed = new Text("[]");
        this.gridPane.add(medicalLabel, 0, 5);
        this.gridPane.add(accMed, 1, 5);

        // Criminal Record
        Text crimLabel = new Text("Criminal Record: ");
        Text accCrim = new Text("[]");
        this.gridPane.add(crimLabel, 0, 6);
        this.gridPane.add(accCrim, 1, 6);

        // Reason for Entry
        Text reasonLabel = new Text("Reason for Entry: ");
        Text accReason = new Text("[]");
        this.gridPane.add(reasonLabel, 0, 7);
        this.gridPane.add(accReason, 1, 7);

        // Length of Stay
        Text lengthLabel = new Text("Length of Stay: ");
        Text accLength = new Text("[]");
        this.gridPane.add(lengthLabel, 0, 8);
        this.gridPane.add(accLength, 1, 8);

        // Username
        Text userLabel = new Text("Username: ");
        Text accUser = new Text("[]");
        this.gridPane.add(userLabel, 0, 9);
        this.gridPane.add(accUser, 1, 9);

        // Password
        Text passLabel = new Text("Password: ");
        Text accPass = new Text("[]");
        this.gridPane.add(passLabel, 0, 10);
        this.gridPane.add(accPass, 1, 10);

        // Alien Number
        Text aNumLabel = new Text("Alien Number: ");
        Text accANum = new Text("[]");
        this.gridPane.add(aNumLabel, 0, 11);
        this.gridPane.add(accANum, 1, 11);

        // ID in System
        Text idLabel = new Text("ID in System: ");
        Text accID = new Text("[]");
        this.gridPane.add(idLabel, 0, 12);
        this.gridPane.add(accID, 1, 12);

        // Status
        Text statusLabel = new Text("Current Status: ");
        Text accStatus = new Text("[]");
        this.gridPane.add(statusLabel, 0, 13);
        this.gridPane.add(accStatus, 1, 13);

        // Phone Number
        Text phoneLabel = new Text("Phone Number: ");
        Text accPhone = new Text("[]");
        this.gridPane.add(phoneLabel, 0, 14);
        this.gridPane.add(accPhone, 1, 14);

        // Additional Information
        Text extraLabel = new Text("Additional Information: ");
        Text accExtra = new Text("[]");
        this.gridPane.add(extraLabel, 0, 15);
        this.gridPane.add(accExtra, 1, 15);

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
            accDOB.setText("");
            accGender.setText("");
            accCountry.setText("");
            accMed.setText("");
            accCrim.setText("");
            accReason.setText("");
            accLength.setText("");
            accUser.setText("");
            accPass.setText("");
            accANum.setText("");
            accID.setText("");
            accStatus.setText("");
            accPhone.setText("");
            accExtra.setText("");
        });

        runTestButton.setOnAction(e -> {

            long currId = Long.parseLong(accID.getText());

            if (Account.dataReview(currId) == 0) {
                Workflow.updateWorkflowStatus(Status.APPROVAL, currId);
            }
        });

        nextApplicationButton.setOnAction(e -> {

            // Account.testPopulateList();
            Workflow.updateWorkflowStatus(Status.REVIEW, 0);
            Workflow.updateWorkflowStatus(Status.REVIEW, 1);

            Account ac = null;
            long id = Workflow.getItemWithStatus(Status.REVIEW);
            ac = Account.getAccount(id);

            accName.setText(ac.getName());
            accEmail.setText(ac.getEmail());
            accDOB.setText(ac.getDOB().toString());
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
            accCountry.setText(ac.getCountryOfOrigin());
            accMed.setText(ac.getMedicalConditions());
            accCrim.setText(ac.getCriminalRecord().toString());
            switch (ac.getReasonForEntry()) {
                case 0:
                    accReason.setText("Relocation");
                    break;
                case 1:
                    accReason.setText("Visiting");
                    break;
                case 2:
                    accReason.setText("Job Opportunity");
                    break;
                case 3:
                    accReason.setText("Other");
                    break;
            }
            accLength.setText(ac.getLengthOfIntendedStay());
            accUser.setText(ac.getAccountUsername());
            accPass.setText(ac.getAccountPassword());
            accANum.setText(Long.toString(ac.getAlienNumber()));
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
            accPhone.setText(ac.getPhoneNumber().toString());
            accExtra.setText(ac.getAdditionalInformation());
        });

    }


}
