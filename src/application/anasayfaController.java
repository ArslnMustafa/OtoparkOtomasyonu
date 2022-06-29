package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class anasayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AracCikisSayfasi;

    @FXML
    private Button anasayfaCikis;

    @FXML
    private Button aracKayitSayfasi;

    @FXML
    private Button aracOtoparkYerleri;

    @FXML
    private Button aracSatisSayfasi;
    
    @FXML
    private AnchorPane anchor1;

    @FXML
    private BorderPane borderPane;

    @FXML
    void AracCikisSayfasiOnAction(ActionEvent event) {

    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("otoparkCikis.fxml"));
        	anchor1.getChildren().setAll(pane1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void anasayfaCikisOnAction(ActionEvent event) {

    	try {
    		Stage stage = (Stage) anasayfaCikis.getScene().getWindow();
            // do what you have to do
            stage.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    	
    
    }

    @FXML
    void aracKayitSayfasiOnAction(ActionEvent event) {

    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("otoparkKaydi.fxml"));
        	anchor1.getChildren().setAll(pane1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }

    @FXML
    void aracOtoparkYerleriOnAction(ActionEvent event) {

    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("otoparkYerleri.fxml"));
        	anchor1.getChildren().setAll(pane1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void aracSatisSayfasiOnAction(ActionEvent event) {
    	
    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("satisListeleme.fxml"));
        	anchor1.getChildren().setAll(pane1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @FXML
    void kullaniciBilgiOnAction(ActionEvent event) {

    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("KullaniziBilgi.fxml"));
        	anchor1.getChildren().setAll(pane1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void initialize() {
    	
       
    }

}
