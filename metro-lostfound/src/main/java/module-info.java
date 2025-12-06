module com.example.metrolostfound {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.metrolostfound to javafx.fxml;
    exports com.example.metrolostfound;
}