/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package atividadedouglas.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jaderson
 */
public class TelaAtividade2Controller implements Initializable {

    @FXML
    private TextField resultado;
    @FXML
    private Pane pane;
    @FXML
    private ToggleGroup planetas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCalcularPeso() {
        
       double valor = 0; 
       Toggle selectedToggle = planetas.getSelectedToggle();
       
        if (selectedToggle instanceof RadioButton) {
        RadioButton selectedRadioButton = (RadioButton) selectedToggle;
        String planeta = (String) selectedRadioButton.getText();
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Escolhas:");
        alerta.setHeaderText(null);
            switch(planeta){
                case "Mercúrio":
                    valor = Double.parseDouble(resultado.getText()) * 0.37;
                    break;
                case "Marte":
                    valor = Double.parseDouble(resultado.getText()) * 0.38;
                    break;
                case "Saturno":
                    valor = Double.parseDouble(resultado.getText()) * 1.15;
                    break;
                case "Vênus":
                    valor = Double.parseDouble(resultado.getText()) * 0.88;
                    break;
                case "Júpiter":
                    valor = Double.parseDouble(resultado.getText()) * 2.64;
                    break;
                case "Urano":
                    valor = Double.parseDouble(resultado.getText()) * 1.17;
                    break;
                default:
                    break;

            }
        alerta.setContentText("Peso: " + valor);
        alerta.showAndWait();
        }
        
        
    }
    
    @FXML
    private void clickVoltar() throws IOException {
        Stage stage = (Stage) this.pane.getScene().getWindow();
        Pane p = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaInicial.fxml")).load();
        Scene cena = new Scene(p);
        stage.setScene(cena);
        stage.show();
    }
    
   
}
