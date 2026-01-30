package alonso.daniel.personas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable{
    @FXML
    private TextField NombreTF;
    @FXML
    private TextField ApellidosTF;
    @FXML
    private TextField EdadTF;
    @FXML
    private Button AgregarBT;
    @FXML
    private Button ModificarBT;
    @FXML
    private Button EliminacionBT;
    @FXML
    private TableColumn NombreTC;
    @FXML
    private TableColumn ApellidosTC;
    @FXML
    private TableColumn EdadTC;
    @FXML
    private TableView TablaTV;
    
    private ObservableList<Persona> personas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personas = FXCollections.observableArrayList();
        
        NombreTC.setCellValueFactory(new PropertyValueFactory("nombre"));
        ApellidosTC.setCellValueFactory(new PropertyValueFactory("apellidos"));
        EdadTC.setCellValueFactory(new PropertyValueFactory("edad"));
    }
    
    @FXML
    private void agregarPersonas(){
        if(comprobaciónCampos()){
            personaTabla();
            settearFieldsNulos();
        } else{
            Alert alerts = new Alert(Alert.AlertType.ERROR);
            alerts.setHeaderText("Valores insuficientes");
            alerts.setTitle("Error :p");
            alerts.setContentText("No hay valores suficientes en los campos requeridos");
            alerts.showAndWait();
            settearFieldsNulos();
        }
    }
    
    private boolean comprobaciónCampos(){
        if(NombreTF.getText().length()>0&&ApellidosTF.getText().length()>0&&EdadTF.getText().length()>0){
            return true;
        }
        return false;
    }
    
    private void personaTabla(){
        Persona aux = new Persona(NombreTF.getText(), ApellidosTF.getText(), Integer.parseInt(EdadTF.getText()));
        personas.add(aux);
        TablaTV.setItems(personas);
    }
    private void settearFieldsNulos(){
            NombreTF.setText("");
            ApellidosTF.setText("");
            EdadTF.setText("");
    }
}
