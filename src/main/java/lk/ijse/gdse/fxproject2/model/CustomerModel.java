package lk.ijse.gdse.fxproject2.model;

import lk.ijse.gdse.fxproject2.db.DBConnection;
import lk.ijse.gdse.fxproject2.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerModel {

    public String getNextCustomerId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String lastID = resultSet.getString(1); //C002
            String subString = lastID.substring(1); //002
            int i = Integer.parseInt(subString);
            int newIndex = i+1;
            return String.format("C%03d", newIndex);

        }
        return "C001";
    }

    public  boolean saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,customerDto.getCustomerId());
        preparedStatement.setObject(2,customerDto.getName());
        preparedStatement.setObject(3, customerDto.getNic());
        preparedStatement.setObject(4, customerDto.getEmail());
        preparedStatement.setObject(5, customerDto.getPhone());

        int i = preparedStatement.executeUpdate();
        boolean isSaved = i > 0;
        return  isSaved;








    }
}
