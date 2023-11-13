package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Group;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.scene.control.ButtonBar.*;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.text.*;

/**
 * JavaFX App
 */
public class DataEntry extends Application {
    /* Private variables */
    private GridPane gp = new GridPane(640, 480);
    private ArrayList accList = new ArrayList<Account>();
    private Workflow w = Workflow.getWorkflow();

    // Used by home page
    /**
     * Method used by home screen to get the screen content.
     * 
     * @return gp GridPane - GridPane with screen content.
     */
    public GridPane getGridPane() {
        return this.gp;
    }

    // // Get list of accounts if defined
    // public ArrayList<Account> getAccountsForTesting() {
    // return this.accList;
    // }

    // public void setAccountsForTesting(ArrayList<Account> accList) {
    // this.accList = accList;
    // }

    /**
     * Method to start the screen with the corresponding buttons, text, ect.
     * 
     * @param stage Stage - Window for the screen to be displayed.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Data Entry Form");
        // will always update the account list when running

        // gp setup
        this.gp.setPadding(new Insets(5, 5, 5, 5));
        this.gp.setVgap(5);
        this.gp.setHgap(10);
        this.gp.setAlignment(Pos.CENTER);

        /*
         * Fields to add: String name, String email, LocalDate dateOfBirth, int gender,
         * String countryOfOrigin,
         * String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry,
         * String lengthOfIntendedStay,
         * String accountUsername, String accountPassword,
         * PhoneNumber phoneNumber, String additionalInformation
         */

        // Name
        Text nameLabel = new Text("Name");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Your Name...");

        // Email
        Text emailLabel = new Text("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Enter Your Email...");

        // LocalDate
        Text dateLabel = new Text("Date");
        DatePicker dateField = new DatePicker();

        // Gender
        Text genderLabel = new Text("Gender");
        String genderOptions[] = { "Male", "Female", "Other" };
        // Create a combo box
        ComboBox genderField = new ComboBox(FXCollections.observableArrayList(genderOptions));

        // Country of Origin
        Text countryOfOriginLabel = new Text("Country of Origin");
        TextField countryOfOriginField = new TextField();
        countryOfOriginField.setPromptText("Enter Your Country of Origin...");

        // Medical Conditions
        Text medicalConditionsLabel = new Text(
                "Medical Conditions \n(Use Commas ',' as a separator or\nleave empty if none))");
        TextField medicalConditionsField = new TextField();
        medicalConditionsField.setPromptText("Enter Your Medical Condition(s)...");

        // Criminal Record
        Text criminalRecordLabel = new Text(
                "Criminal Record \n(Use Commas ',' as a separator or\nleave empty if none)");
        TextField criminalRecordField = new TextField();
        criminalRecordField.setPromptText("Enter Your Criminal Record(s)...");

        // Reason for Entry
        Text entryLabel = new Text("Reason For Entry");
        String entryOptions[] = { "Relocation", "Visiting", "Job Opportunity", "Other" };
        // Create a combo box
        ComboBox entryField = new ComboBox(FXCollections.observableArrayList(entryOptions));

        // Length of Intended Stay
        Text stayLabel = new Text("Length of Intended Stay");
        TextField stayField = new TextField();
        stayField.setPromptText("Enter The Length of Your Intended Stay...");

        // accountUsername
        Text usernameLabel = new Text("Username");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Your Username...");

        // accountPassword
        Text passwordLabel = new Text("Password");
        TextField passwordField = new TextField();
        passwordField.setPromptText("Enter Your Password...");

        // Phone Number
        Text pnInternationalLabel = new Text("International Code For Your Phone Number");
        TextField pnInternationalField = new TextField();
        pnInternationalField.setPromptText("Enter Your International Code For Your Phone Number...");
        Text pnLabel = new Text("Phone Number");
        TextField pnField = new TextField();
        pnField.setPromptText("Enter Your Phone Number...");

        // Additional Information
        Text addInfoLabel = new Text("Additional Information");
        TextField addInfoField = new TextField();
        addInfoField.setPromptText("Enter Any Other additional Information");

        // ButtonBar
        ButtonBar buttonBar = new ButtonBar();
        // Submit Button
        Button submit = new Button("Submit");
        // Mark as done
        ButtonBar.setButtonData(submit, ButtonData.NO);
        // Clear Button
        Button clear = new Button("Clear");
        // Mark as Clear (BACK_PREVIOUS)
        ButtonBar.setButtonData(clear, ButtonData.NO);

        // Event that Saves Info in Form
        submit.setOnAction(e -> {
            // make gender
            int genderElement = 0;
            int i = 0;
            for (String gender : genderOptions) {
                if (gender.equals(genderOptions[i])) {
                    genderElement = i;
                    break;
                }
                i++;
            }
            i = 0;

            // make criminal record
            CriminalRecord crimRecord;
            if (criminalRecordField.getText().equals("")) {
                crimRecord = new CriminalRecord();
            } else {
                ArrayList<String> elements = new ArrayList<>(
                        Arrays.asList(criminalRecordField.getText().split(",[ ]*")));
                String[] violations = elements.toArray(new String[elements.size()]);
                crimRecord = new CriminalRecord(true, violations);
            }

            // make entry
            int entryElement = 0;
            for (String gender : entryOptions) {
                if (gender.equals(entryOptions[i])) {
                    entryElement = i;
                    break;
                }
                i++;
            }
            i = 0;

            // make Phone Number
            Integer international = Integer.parseInt(pnInternationalField.getText());
            Long pn = Long.parseLong(pnField.getText());
            PhoneNumber combinedpn = new PhoneNumber(international, pn);

            // call error checking on the info before trying to create an account : onscreenvalidate
            Account accountToAdd = Account.addAccount(nameField.getText(), emailField.getText(), dateField.getValue(),
                    genderElement, countryOfOriginField.getText(), medicalConditionsField.getText(), crimRecord,
                    entryElement, stayField.getText(), usernameField.getText(), passwordField.getText(), combinedpn,
                    addInfoField.getText());
            // On successful add
            if (accountToAdd != null) {
                // Add account to workflow called in Account.java
                // Set button data
                ButtonBar.setButtonData(submit, ButtonData.YES);
                ButtonBar.setButtonData(clear, ButtonData.NO);
                // List all accounts in system
                System.out.println("Accounts:");
                for (int a = 0; a < accList.size(); a++) {
                    System.out.println(accList.get(a).toString());
                }
                System.out.println();
            } else { // On failed add
                // Set button data
                ButtonBar.setButtonData(submit, ButtonData.NO);
                ButtonBar.setButtonData(clear, ButtonData.NO);
                System.out.println("Add failed.");
            }

        });

        // On clear button press
        clear.setOnAction(e -> {
            ButtonBar.setButtonData(clear, ButtonData.YES);
            ButtonBar.setButtonData(submit, ButtonData.NO);
            nameField.setText("");
            emailField.setText("");
            dateField.setValue(null);
            genderField.setValue(null);
            countryOfOriginField.setText("");
            medicalConditionsField.setText("");
            criminalRecordField.setText("");
            entryField.setValue(null);
            stayField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            pnInternationalField.setText("");
            pnField.setText("");
            addInfoField.setText("");
        });

        // Add button to the ButtonBar
        buttonBar.getButtons().addAll(submit, clear);

        // Add elements to gp
        this.gp.add(nameLabel, 0, 0);
        this.gp.add(nameField, 1, 0);
        this.gp.add(emailLabel, 0, 1);
        this.gp.add(emailField, 1, 1);
        this.gp.add(dateLabel, 0, 2);
        this.gp.add(dateField, 1, 2);
        this.gp.add(genderLabel, 0, 3);
        this.gp.add(genderField, 1, 3);
        this.gp.add(countryOfOriginLabel, 0, 4);
        this.gp.add(countryOfOriginField, 1, 4);
        this.gp.add(medicalConditionsLabel, 0, 5);
        this.gp.add(medicalConditionsField, 1, 5);
        this.gp.add(criminalRecordLabel, 0, 6);
        this.gp.add(criminalRecordField, 1, 6);
        this.gp.add(entryLabel, 0, 7);
        this.gp.add(entryField, 1, 7);
        this.gp.add(stayLabel, 0, 8);
        this.gp.add(stayField, 1, 8);
        this.gp.add(usernameLabel, 0, 9);
        this.gp.add(usernameField, 1, 9);
        this.gp.add(passwordLabel, 0, 10);
        this.gp.add(passwordField, 1, 10);
        this.gp.add(pnInternationalLabel, 0, 11);
        this.gp.add(pnInternationalField, 1, 11);
        this.gp.add(pnLabel, 0, 12);
        this.gp.add(pnField, 1, 12);
        this.gp.add(addInfoLabel, 0, 13);
        this.gp.add(addInfoField, 1, 13);
        this.gp.add(buttonBar, 0, 14);

        /*
         * Removed because of home screen
         */
        // Create Scene
        // var scene = new Scene(this.gp);
        // stage.setScene(scene);
        // stage.show();
    }

    // public static void main(String[] args) {
        // launch();
    // }
}
