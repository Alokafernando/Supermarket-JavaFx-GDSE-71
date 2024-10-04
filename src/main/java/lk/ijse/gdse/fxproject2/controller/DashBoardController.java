package lk.ijse.gdse.fxproject2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @FXML
    private AnchorPane DashBoardPanel;

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnItem;

    @FXML
    private Button btnOrders;

    @FXML
    private AnchorPane contentPanel;

    @FXML
    void openCustomerPanel(ActionEvent event) {
        navigation("view/CustomerPanel.fxml");
    }

    @FXML
    void openItemPanel(ActionEvent event) {
        navigation("/view/ItemPanel.fxml");
    }

    @FXML
    void openOrdersPanel(ActionEvent event) {
        navigation("/view/orders.fxml");
    }

    private void navigation(String filePath){
        try{
            contentPanel.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(getClass().getResource(filePath));
            contentPanel.getChildren().add(pane);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "coundn't load page");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Loading customer panel");
        navigation("/view/CustomerPanel.fxml");
    }

}
