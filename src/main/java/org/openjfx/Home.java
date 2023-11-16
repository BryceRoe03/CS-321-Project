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

import org.openjfx.Account;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
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
public class Home extends Application {
    private ArrayList accList = new ArrayList<Account>();

    private GridPane gp = null;
    @Override
    public void start(Stage stage) {
        stage.setTitle("Home Screen");
        gp = new GridPane(640, 480); 

        // Grid setup
        gp.setPadding(new Insets(5, 5, 5, 5));
        gp.setVgap(5); 
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        // ButtonBar
        ButtonBar buttonBar = new ButtonBar();
        // Data Entry Button
        Button entry = new Button("Data Entry");
        ButtonBar.setButtonData(entry, ButtonData.NO);

        // Review Button
        Button review = new Button("Review");
        ButtonBar.setButtonData(review, ButtonData.NO);

        // Approval Button
        Button approve = new Button("Approval");
        ButtonBar.setButtonData(approve, ButtonData.NO);

        // Event to change screen to Data Entry
        entry.setOnAction( e -> {
            DataEntry d = new DataEntry();
            this.gp = d.dataEntryScreen();
            // d.setAccountsForTesting(this.accList);
            Scene scene = new Scene(this.gp, 700, 700);
            d.start(stage);
            stage.setScene(scene);
            stage.show();
        });

        // Event to change screen to Review
        review.setOnAction( e -> {
            Review rev = new Review();
            BorderPane gotBase = rev.reviewScreen();
            Scene scene = new Scene(gotBase, 700, 700);
            rev.start(stage);
            stage.setScene(scene);
            stage.show();
        });

        // Event to change screen to Approval
        approve.setOnAction( e -> {
            Approval ap = new Approval();
            this.gp = ap.approvalScreen();
            Scene scene = new Scene(this.gp, 700, 700);
            ap.start(stage);
            stage.setScene(scene);
            stage.show();
        });

        // Add button to the ButtonBar
        buttonBar.getButtons().addAll(entry, review, approve);
        gp.add(buttonBar, 0, 14);

        //Creating a Group object
        // Group allForm = new Group(nameGroup, emailGroup, dateGroup);
        Scene scene = new Scene(gp);
        stage.setScene(scene);
        stage.show();
    }

    // public static void main(String[] args) {
        // launch();
    // }

}
