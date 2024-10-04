package lk.ijse.gdse.fxproject2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;

public class SignUpController {

    @FXML
    private AnchorPane SignupPage;

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUseName;

    @FXML
    void SignUpToDashBoardPage(ActionEvent event) throws Exception {


           SignupPage.getChildren().clear();
           AnchorPane load = FXMLLoader.load(getClass().getResource("/view/DashBoardController.fxml"));
           SignupPage.getChildren().add(load);



    }

}
