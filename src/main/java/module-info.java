module lk.ijse.gdse.fxproject2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires lombok;
    requires java.sql;

    opens lk.ijse.gdse.fxproject2.dto.tm to javafx.base;
    opens lk.ijse.gdse.fxproject2.controller to javafx.fxml;
    exports lk.ijse.gdse.fxproject2;
}