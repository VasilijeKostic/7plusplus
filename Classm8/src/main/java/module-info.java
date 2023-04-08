module com.example.classm8 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.classm8 to javafx.fxml;
    exports com.example.classm8;
}