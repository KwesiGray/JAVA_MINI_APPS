package com.example.foe4100813121;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void onCancel(ActionEvent event) {
        Platform.exit();

    }

    @FXML
    void onlogin(ActionEvent event) throws IOException {
        String username = txtUsername.getText();
        String Password = txtUsername.getText();


        if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("12345")){

            lblLogin.setText("correct");

            Stage loginstage = (Stage) btnLogin.getScene().getWindow();
            loginstage.close();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPageG.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 440);
            Stage stage = new Stage();
            stage.setTitle("Debtor App");
            stage.setScene(scene);
            stage.show();
        }else {

            lblLogin.setText("INVALID LOGINS");
            lblLogin.setTextFill(Color.RED);

            txtUsername.setText("");
            txtPassword.setText("");

        }

    }

}
