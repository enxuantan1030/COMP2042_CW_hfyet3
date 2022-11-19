module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.sm2048 to javafx.fxml;
    exports com.example.sm2048;

}