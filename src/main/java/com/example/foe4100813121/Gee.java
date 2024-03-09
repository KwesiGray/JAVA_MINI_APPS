package com.example.foe4100813121;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Gee implements Initializable {

    FileChooser Dav = new FileChooser();

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSaveUpdates;

    @FXML
    private Button btnView;

    @FXML
    private ToggleGroup gender;

    @FXML
    private MenuItem mExit;

    @FXML
    private MenuItem mLogout;

    @FXML
    private MenuItem mViewExisting;

    @FXML
    private Menu menuBar;

    @FXML
    private RadioButton rdnFemale;

    @FXML
    private RadioButton rdnMale;

    @FXML
    private TextField txtAmout;

    @FXML
    private TextArea txtEditorArea;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    void onEdit(ActionEvent event) {
        txtEditorArea.isEditable();

    }

    @FXML
    void onFemale(ActionEvent event) {

    }

    @FXML
    void onMale(ActionEvent event) {

    }

    @FXML
    void onSave(ActionEvent event) throws FileNotFoundException {
        String NAME = txtName.getText();
        String PHONE = txtPhone.getText();
        String AMOUNT = txtAmout.getText();
        String Male = rdnMale.getText();
        String Female = rdnFemale.getText();

        if (txtName.getText().equals("") || txtPhone.getText().equals("") || txtAmout.getText().equals("")){

        }else {
            Dav.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files","*.txt"));

            File selectedFile = Dav.showSaveDialog(new Stage());

            if (selectedFile == null){

            }else {
                PrintWriter output = new PrintWriter(selectedFile);
                String txtN = txtName.getText();
                String txtPhon = txtPhone.getText();
                String txtAm = txtAmout.getText();
                RadioButton selectG = (RadioButton)gender.getSelectedToggle();
               // String radioF = rdnFemale.getText();

                output.println("Name: "+txtN);
                output.println("Phone: "+txtPhon);
                output.println("Amount: "+txtAm);
               output.println("Gender: "+selectG.getText());
               // output.println("Gender: "+radioF);


                output.close();


            }

        }














    }

    @FXML
    void onSaveUpdates(ActionEvent event) {


    }

    @FXML
    void onView(ActionEvent event) throws FileNotFoundException {

        Dav.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File selectedFile = Dav.showOpenDialog(new Stage());

        if (selectedFile == null) {

        } else {
            Scanner input = new Scanner(selectedFile);
            while (input.hasNextLine()) {
                txtEditorArea.appendText(input.nextLine() + "\n");

            }

        }

    }







    @FXML
    void onLogout(ActionEvent event) throws IOException {

        Stage logoutstage = (Stage) btnView.getScene().getWindow();
        logoutstage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginG.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 340);
        Stage stage = new Stage();
        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void menuOnExit(ActionEvent event) {
        Platform.exit();

    }

    @FXML
    void menuOnView(ActionEvent event) throws FileNotFoundException {

        String NAME = txtName.getText();
        String PHONE = txtPhone.getText();
        String AMOUNT = txtAmout.getText();
        String Male = rdnMale.getText();
        String Female = rdnFemale.getText();

        if (txtName.getText().equals("") || txtPhone.getText().equals("") || txtAmout.getText().equals("")){

        }else {
            Dav.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            File selectedFile = Dav.showSaveDialog(new Stage());

            if (selectedFile == null) {

            } else {
                PrintWriter output = new PrintWriter(selectedFile);
                String txtN = txtName.getText();
                String txtPhon = txtPhone.getText();
                String txtAm = txtAmout.getText();
                RadioButton selectG = (RadioButton) gender.getSelectedToggle();
                // String radioF = rdnFemale.getText();

                output.println("Name: " + txtN);
                output.println("Phone: " + txtPhon);
                output.println("Amount: " + txtAm);
                output.println("Gender: " + selectG.getText());
                // output.println("Gender: "+radioF);


                output.close();


            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Dav.setInitialDirectory(new File("c:\\Users"));

    }
}
