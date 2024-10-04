
package lk.ijse.gdse.fxproject2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.gdse.fxproject2.dto.CustomerDto;
import lk.ijse.gdse.fxproject2.dto.tm.CustomerTM;
import lk.ijse.gdse.fxproject2.model.CustomerModel;

import java.net.URL;
import java.sql.SQLException;
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
    private Label lblcustomerid;

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

    CustomerModel customerModel = new CustomerModel();

   @FXML
   void saveCustomer(ActionEvent event) throws SQLException, ClassNotFoundException {

       String customerId = lblcustomerid.getText();
       String name = txtName.getText();
       String nic = txtNIC.getText();
       String email = txtEmail.getText();
       String phone = txtPhone.getText();

       CustomerDto customerDto =  new CustomerDto(
               customerId,
               name,
               nic,
               email,
               phone);

       boolean isSaved = customerModel.saveCustomer(customerDto);
       if (isSaved) {
           loadNextCustomer();
           txtName.setText("");
           txtNIC.setText("");
           txtEmail.setText("");
           txtPhone.setText("");
           new Alert(Alert.AlertType.INFORMATION, "Customer Saved", ButtonType.OK).show();
       }else{
           new Alert(Alert.AlertType.ERROR, "Fail", ButtonType.OK).show();
       }

   }

    private void loadNextCustomer() throws SQLException, ClassNotFoundException {
        String nextCustomerId = customerModel.getNextCustomerId();
        lblcustomerid.setText(nextCustomerId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        custId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        try{
            loadNextCustomer();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Customer Not Saved").show();
        }
    }

}

