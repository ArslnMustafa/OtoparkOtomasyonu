package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.mustafaarslanMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class markaEkleController {
	Connection conn = null;
	PreparedStatement sorguIfadesi=null;
	ResultSet fetch=null;
	String sql;
	public markaEkleController() {
		// TODO Auto-generated constructor stub
		conn = VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEkle;

    @FXML
    private TextField txtMarka;

    @FXML
    void btnEkleOnAction(ActionEvent event) {

    	sql="insert into markabilgileri(marka) values ('"+txtMarka.getText()+"') ";
    	try {
			sorguIfadesi=conn.prepareStatement(sql);
			
			
			sorguIfadesi.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    	
    }
    

    @FXML
    void initialize() {
    	
       
    }
    
    

}
