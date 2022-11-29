/**
*declares the dependencies within the module system and allows the compiler and the runtime 
*to police the boundaries/access violations between the modules in the application.
*/
module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports com.sm2048;
    opens com.sm2048 to javafx.fxml;

    exports com.sm2048.Others;
    opens com.sm2048.Others to javafx.fxml;

    exports com.sm2048.Scenes.InGame;
    opens com.sm2048.Scenes.InGame to javafx.fxml;

    exports com.sm2048.Scenes.MenuGame;
    opens com.sm2048.Scenes.MenuGame to javafx.fxml;

    exports com.sm2048.Scenes.EndGame;
    opens com.sm2048.Scenes.EndGame to javafx.fxml;

}
