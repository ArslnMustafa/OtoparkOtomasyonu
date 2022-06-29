package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class userAnasayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button anasayfaCikis;

    @FXML
    private AnchorPane anchor1;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button kullaniciBilgi;

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
    void kullaniciBilgiOnAction(ActionEvent event) {

    	try {
        	AnchorPane pane1= (AnchorPane) FXMLLoader.load(getClass().getResource("kullaniciBilgi.fxml"));
        	anchor1.getChildren().setAll(pane1);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void initialize() {
    	Tooltip tip = new Tooltip();
        
        tip.setStyle("-fx-background-color: gray");
        tip.setText("Sayfayý kapatýr.");
        
        anasayfaCikis.setTooltip(tip);
        
       
    }

}
