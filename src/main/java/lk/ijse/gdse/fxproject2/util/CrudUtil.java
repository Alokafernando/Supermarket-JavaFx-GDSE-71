package lk.ijse.gdse.fxproject2.util;

import lk.ijse.gdse.fxproject2.db.DBConnection;
import lombok.val;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
    public static <T>T execute(String sql, Object... obj ) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < obj.length; i++) {
            preparedStatement.setObject((i + 1), obj[i]);
        }

        if(sql.startsWith("SELECT") || sql.startsWith("select")){
            ResultSet rst = preparedStatement.executeQuery();
            return (T)rst;
        }else{
            int i = preparedStatement.executeUpdate();
            boolean isSaved = i > 0;
            return (T)(Boolean) isSaved;
        }
    }
}
