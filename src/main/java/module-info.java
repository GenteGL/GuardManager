module com.beginsecure.guardmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.beginsecure.guardmanager to javafx.fxml;
    exports com.beginsecure.guardmanager;
}