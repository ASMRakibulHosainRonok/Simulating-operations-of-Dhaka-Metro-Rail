module csc305.metrorailabdullah {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens csc305.metrorailabdullah to javafx.fxml;
    opens csc305.metrorailabdullah.Passenger to javafx.fxml, java.base;
    opens csc305.metrorailabdullah.TicketingStaff to javafx.fxml, java.base;

    exports csc305.metrorailabdullah;
}