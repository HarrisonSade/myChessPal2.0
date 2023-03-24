module com.example.mychesspal2_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mychesspal2_0 to javafx.fxml;
    exports com.example.mychesspal2_0;
}