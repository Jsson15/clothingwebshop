module com.example.klader {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.klader to javafx.fxml;
    exports com.example.klader;
    exports com.example.klader.Command;
    opens com.example.klader.Command to javafx.fxml;
}