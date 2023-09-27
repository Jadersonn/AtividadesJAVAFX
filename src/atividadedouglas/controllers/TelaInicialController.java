/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadedouglas.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author 05247690109
 */
public class TelaInicialController implements Initializable{

    @FXML
    private Pane telaInicial;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
        
    public void clickAtividade1() throws IOException{
                Stage stage = (Stage) this.telaInicial.getScene().getWindow();
                SplitPane p = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaAtividade1.fxml")).load();
                Scene cena = new Scene(p);
                stage.setScene(cena);
                stage.show();
    }
    
    public void clickAtividade2() throws IOException{
                Stage stage = (Stage) this.telaInicial.getScene().getWindow();
                Pane p = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaAtividade2.fxml")).load();
                Scene cena = new Scene(p);
                stage.setScene(cena);
                stage.show();
    }
    
    public void clickAtividade3() throws IOException{
                Stage stage = (Stage) this.telaInicial.getScene().getWindow();
                AnchorPane ap = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaAtividade3.fxml")).load();
                Scene cena = new Scene(ap);
                stage.setScene(cena);
                stage.show();
    }
    
    public void clickAtividade4() throws IOException{
                Stage stage = (Stage) this.telaInicial.getScene().getWindow();
                SplitPane ap = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaAtividade4.fxml")).load();
                Scene cena = new Scene(ap);
                stage.setScene(cena);
                stage.show();
    }
    
}
