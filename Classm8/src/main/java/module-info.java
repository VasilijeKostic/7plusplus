module com.example.classm8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http; // FOR Communication.java
            
                            
    opens com.example.classm8 to javafx.fxml;
    exports com.example.classm8;
}