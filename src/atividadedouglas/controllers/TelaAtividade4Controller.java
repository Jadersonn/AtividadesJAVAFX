/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package atividadedouglas.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import listview.Pedido;

/**
 * FXML Controller class
 *
 * @author INFO
 */
public class TelaAtividade4Controller implements Initializable {

    @FXML
    private ToggleGroup tamanhos;
    @FXML
    private TextField identidade;
    @FXML
    private TextField quant;
    @FXML
    private ToggleGroup cores;
    @FXML
    private Text status;
    @FXML
    private ListView<String> resultado;
    @FXML
    private MenuButton cor;
    @FXML
    private MenuButton tamanho;
    
    private static int controle = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> roupas = carregarPedidos();
        resultado.setItems(roupas);
        if(controle == 1){
          status.setText("Roupa armazenada com sucesso!");  
        }else if(controle == 2){
            status.setText("Roupa armazenada sem sucesso!ERRO!");
        }
    }
    
    @FXML
    private void clickEnviar() throws IOException{
        Pedido pedido = new Pedido();
        pedido.setCor(retornaStringSelecionada(cores));
        pedido.setIdentidade(identidade.getText());
        pedido.setQuant(Integer.parseInt(quant.getText()));
        pedido.setTamanho(retornaStringSelecionada(tamanhos));
        armazenarRoupas("roupas.txt", pedido);
        
        //atualizando a pagina
        Stage stage = (Stage) this.status.getScene().getWindow();
        SplitPane ap = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaAtividade4.fxml")).load();
        Scene cena = new Scene(ap);
        stage.setScene(cena);
        stage.show();
    }

    @FXML
    private void clickVoltar() throws IOException {
        TelaAtividade4Controller.controle=0;
        Stage stage = (Stage) this.identidade.getScene().getWindow();
        Pane p = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaInicial.fxml")).load();
        Scene cena = new Scene(p);
        stage.setScene(cena);
        stage.show();
    }

    @FXML
    private void alteraTamanho(ActionEvent event) {
        Toggle selectedToggle = tamanhos.getSelectedToggle();        
        RadioMenuItem selectedRadioMenuItem = (RadioMenuItem) tamanhos.getSelectedToggle();
        tamanho.setText(selectedRadioMenuItem.getText());
    }


    @FXML
    private void alteraCor(ActionEvent event) {
        Toggle selectedToggle = cores.getSelectedToggle();        
        RadioMenuItem selectedRadioMenuItem = (RadioMenuItem) cores.getSelectedToggle();
        cor.setText(selectedRadioMenuItem.getText());
    }
    
    private ObservableList<String> carregarPedidos() {
    ObservableList<String> roupasList = FXCollections.observableArrayList();
    // Leia o arquivo e adicione as linhas à lista observável
    try (BufferedReader reader = new BufferedReader(new FileReader("roupas.txt"))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            roupasList.add(linha);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return roupasList;
}

    private void armazenarRoupas(String nomeArquivo, Pedido roupa) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            // Formate a linha com os dados da roupa no formato "identidade:cor:tamanho:quant
            int controle = roupa.getQuant();
            String linha = null;
            
            
            while(controle >= 1 ){
            linha = roupa.getIdentidade() + ":" + roupa.getTamanho() + ":" + roupa.getCor();
            // Escreva a linha no arquivo
            writer.write(linha);
            //Adicione uma quebra de linha para separar as entradas
            writer.newLine();
            controle = controle - 1;
            }
            TelaAtividade4Controller.controle = 1;
        } catch (IOException e) {
            
            TelaAtividade4Controller.controle = 2;
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
    
    private String retornaStringSelecionada(ToggleGroup selecionado){
       
        Toggle selectedToggle = selecionado.getSelectedToggle();        
        RadioMenuItem selectedRadioMenuItem = (RadioMenuItem) selecionado.getSelectedToggle();
        return selectedRadioMenuItem.getText();
    }

}
