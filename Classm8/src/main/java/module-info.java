module com.example.classm8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires socket.io.client;
    requires engine.io.client;
                            
    opens com.example.classm8 to javafx.fxml;
    exports com.example.classm8;
}