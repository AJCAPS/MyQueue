module com.example.myqueue {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myqueue to javafx.fxml;
    exports com.example.myqueue;
}