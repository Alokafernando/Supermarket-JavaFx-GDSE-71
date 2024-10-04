package lk.ijse.gdse.fxproject2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.fxproject2.dto.tm.CustomerTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {


    @FXML
    private Button btnDelete;

    @FXML
    private Button btnGenerateReport;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<CustomerTM, String> custId;

    @FXML
    private TableView<CustomerTM> custTabel;

    @FXML
    private TableColumn<CustomerTM, String> email;

    @FXML
    private TableColumn<CustomerTM, String> name;

    @FXML
    private TableColumn<CustomerTM, String> nic;

    @FXML
    private TableColumn<CustomerTM, String> phone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        custId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        phone.setCellValueFactory(new PropertyValueFactory<>("email"));
        email.setCellValueFactory(new PropertyValueFactory<>("phone"));

       // CustomerTM customerTM1 = new CustomerTM("1001", txtName.getText(), txtNIC.getText(), txtPhone.getText(), txtEmail.getText());
        //CustomerTM customerTM2 = new CustomerTM("1002", txtName.getText(), txtNIC.getText(), txtPhone.getText(), txtEmail.getText());

        CustomerTM customerTM1 = new CustomerTM("1001", "hghdg", "dhgf", "fdbdf", "fdds");
        CustomerTM customerTM2 = new CustomerTM("1002", "hghdg", "dhgf", "fdbdf", "fdds");


        ArrayList<CustomerTM> customerTMs = new ArrayList<>();
        customerTMs.add(customerTM1);
        customerTMs.add(customerTM2);

        ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();

        for (CustomerTM customer : customerTMs) {
            customerTMS.add(customer);
        }

        custTabel.setItems(customerTMS);
    }

}
