/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadedouglas;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author 05247690109
 */
public class AtividadeDouglas extends Application {
    
    @Override
    public void start(Stage primaryStage) {
		try {
			Pane root = new FXMLLoader(getClass().getResource("/atividadedouglas/views/TelaInicial.fxml")).load();
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(IOException e) {
		}
	}
    
    
    
	
	public static void main(String[] args) {
		launch(args);
	}
    
}
