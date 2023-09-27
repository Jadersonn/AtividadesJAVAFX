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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static javax.management.Query.value;

/**
 * FXML Controller class
 *
 * @author Jaderson
 */
public class TelaAtividade3Controller implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private ToggleGroup escolhas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void clickVoltar() throws IOException {
        Stage stage = (Stage) this.pane.getScene().getWindow();
        Pane p = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaInicial.fxml")).load();
        Scene cena = new Scene(p);
        stage.setScene(cena);
        stage.show();
    }
    
    @FXML
    private void clickExecutar() throws IOException {
        
        
        int x = randInt(1,3);//gerando o valor aleatorio
        String escolhaUsuario= null;//criando a variavel onde sera salvo o valor do usario
        String escolhaMaquina= null;//criando a variavel onde será salvo o valor  da maquina
        switch (x) {
            case 1:
                escolhaMaquina = "Pedra";
                break;
            case 2:
                escolhaMaquina = "Papel";
                break;
            case 3:
                escolhaMaquina = "Tesoura";
                break;
            default:
                System.out.println("Erro!");
                break;
        }
        
        //captando o item selecionado
        Toggle selectedToggle = escolhas.getSelectedToggle();
        if (selectedToggle instanceof RadioButton) {
        RadioButton selectedRadioButton = (RadioButton) selectedToggle;
        escolhaUsuario = (String) selectedRadioButton.getText();
        }
        
       
       
        
        //criando o alerta para mostrar os resultados
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Escolhas:");
        alerta.setHeaderText(null);
        alerta.setContentText("Escolha do Usuário: \t" + escolhaUsuario + "\nEscolha da Máquina:\t" + escolhaMaquina + "\nResultado: \t"+ ganhador(escolhaUsuario,escolhaMaquina));
        alerta.showAndWait();
        
    }
    
     public static int randInt (int min , int max ) {
    java.util.Random rand = new java . util . Random () ;
    int randomNum = rand . nextInt (( max - min ) + 1) + min ;
    return randomNum ;
     }

    private String ganhador(String escolhaUsuario, String escolhaMaquina) {
       
        if(escolhaUsuario.equals(escolhaMaquina)){
            return "Empate";
        }
        
        String vencedor = null;
        switch(escolhaUsuario){
        case "Papel":
            if(escolhaMaquina.equals("Pedra")){
                vencedor= "Ganhou";
            }else if(escolhaMaquina.equals("Tesoura"))
                vencedor= "Perdeu";
            break;
        case "Pedra":
            if(escolhaMaquina.equals("Papel")){
                vencedor= "Perdeu";
            }else if(escolhaMaquina.equals("Tesoura"))
                vencedor= "Ganhou";
            break;
        case "Tesoura":
            if(escolhaMaquina.equals("Pedra")){
               vencedor= "Perdeu";
            }else if(escolhaMaquina.equals("Papel"))
               vencedor= "Ganhou";
            break;
        default:
            return "Null";
       
    }
        return vencedor;
    }    
}
