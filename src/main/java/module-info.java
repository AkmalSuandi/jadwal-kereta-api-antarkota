module com.mycompany.jadwalkeretaapi {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.jadwalkeretaapi to javafx.fxml;
    exports com.mycompany.jadwalkeretaapi;
}
