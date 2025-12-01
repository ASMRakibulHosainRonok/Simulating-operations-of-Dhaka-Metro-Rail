module csc305.metrorailproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.metrorailproject to javafx.fxml;
    exports csc305.metrorailproject;
}