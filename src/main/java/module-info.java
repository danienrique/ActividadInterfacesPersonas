module alonso.daniel.personas {
    requires javafx.controls;
    requires javafx.fxml;

    opens alonso.daniel.personas to javafx.fxml;
    exports alonso.daniel.personas;
}
