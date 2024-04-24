module com.example.klader {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.klader to javafx.fxml;
    exports com.example.klader;
    exports com.example.klader.Command;
    opens com.example.klader.Command to javafx.fxml;
    exports com.example.klader.Builder;
    opens com.example.klader.Builder to javafx.fxml;
    exports com.example.klader.Clothing;
    opens com.example.klader.Clothing to javafx.fxml;
    exports com.example.klader.Business;
    opens com.example.klader.Business to javafx.fxml;
}
