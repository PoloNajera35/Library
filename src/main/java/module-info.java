module com.example.libraryupa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.libraryupa to javafx.fxml;
    exports com.example.libraryupa;
}