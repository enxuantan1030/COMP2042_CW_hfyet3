module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.sm2048 to javafx.fxml;
    exports com.example.sm2048;
    exports com.example.sm2048.Scenes;
    opens com.example.sm2048.Scenes to javafx.fxml;
    exports com.example.sm2048.Others;
    opens com.example.sm2048.Others to javafx.fxml;
}