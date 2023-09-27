/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadedouglas.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05247690109
 */
public class TelaAtividade1Controller implements Initializable {
    @FXML
    private SplitPane splitPane;
    @FXML
    private TextField lado1;
    @FXML
    private TextField lado3;
    @FXML
    private TextField lado2;
    @FXML
    private Text resultado;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void clickVerificarTipo() {
        Double valor1 = Double.valueOf(lado1.getText());
        Double valor2 = Double.valueOf(lado2.getText());
        Double valor3 = Double.valueOf(lado3.getText());
        
        if(Objects.equals(valor1, valor2) && Objects.equals(valor2, valor3)){
        resultado.setText("Triangulo Equilatero");
        
        }else if(!Objects.equals(valor1, valor2) && !Objects.equals(valor2, valor3) && !Objects.equals(valor1, valor3)){
        resultado.setText("Triangulo Escaleno");
        
        }else if(Objects.equals(valor1, valor2) && !Objects.equals(valor1, valor3)){
        resultado.setText("Triangulo Isosceles");
       
        }else if(Objects.equals(valor1, valor3) && !Objects.equals(valor1, valor2)){
        resultado.setText("Triangulo Isosceles");
        
        }else{
            resultado.setText("Triangulo Isosceles");
        }
    }
    
    @FXML
    private void clickVoltar() throws IOException {
        Stage stage = (Stage) this.splitPane.getScene().getWindow();
        Pane p = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaInicial.fxml")).load();
        Scene cena = new Scene(p);
        stage.setScene(cena);
        stage.show();
    }
    
}
    
