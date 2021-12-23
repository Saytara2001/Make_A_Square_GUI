module com.example.make_a_square_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.make_a_square_gui to javafx.fxml;
    exports com.example.make_a_square_gui;
}