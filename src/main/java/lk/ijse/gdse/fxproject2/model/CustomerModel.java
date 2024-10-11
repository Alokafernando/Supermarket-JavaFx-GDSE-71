package lk.ijse.gdse.fxproject2.model;

import lk.ijse.gdse.fxproject2.db.DBConnection;
import lk.ijse.gdse.fxproject2.dto.CustomerDto;
import lk.ijse.gdse.fxproject2.dto.tm.CustomerTM;
import lk.ijse.gdse.fxproject2.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();*/
        ResultSet resultSet = CrudUtil.execute("SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1");
        if (resultSet.next()) {
            String lastID = resultSet.getString(1); //C002
            String subString = lastID.substring(1); //002
            int i = Integer.parseInt(subString);
            int newIndex = i+1;
            //int newIndex = i;
            return String.format("C%03d", newIndex);



        }
        return "C001";
    }

    public  boolean saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,customerDto.getCustomerId());
        preparedStatement.setObject(2,customerDto.getName());
        preparedStatement.setObject(3, customerDto.getNic());
        preparedStatement.setObject(4, customerDto.getEmail());
        preparedStatement.setObject(5, customerDto.getPhone());

        int i = preparedStatement.executeUpdate();
        boolean isSaved = i > 0;
        return  isSaved;*/

        boolean isSaved = CrudUtil.execute("INSERT INTO customer VALUES (?, ?, ?, ?, ?)",
                customerDto.getCustomerId(),
                customerDto.getName(),
                customerDto.getNic(),
                customerDto.getEmail(),
                customerDto.getPhone()
        );


        return isSaved;
    }

    public static List<CustomerTM> getAllCustomers() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<CustomerTM> customerList = new ArrayList<>();

        while (resultSet.next()) {
            CustomerTM customerTM = new CustomerTM();
            customerTM.setCustomerId(resultSet.getString(1));
            customerTM.setName(resultSet.getString(2));
            customerTM.setNic(resultSet.getString(3));
            customerTM.setEmail(resultSet.getString(4));
            customerTM.setPhone(resultSet.getString(5));
            customerList.add(customerTM);
        }
        return customerList;
    }

   /* public static CustomerDto searchCustomer(String   id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCustomerId(resultSet.getString(1));
            customerDto.setName(resultSet.getString(2));
            customerDto.setNic(resultSet.getString(3));
            customerDto.setEmail(resultSet.getString(4));
            customerDto.setPhone(resultSet.getString(5));

            return customerDto;
        }
        return null;

    }*/
}
