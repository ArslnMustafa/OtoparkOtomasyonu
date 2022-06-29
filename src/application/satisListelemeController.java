package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.mustafaarslanMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class satisListelemeController {
	public satisListelemeController() {
		conn=VeritabaniUtil.Baglan();
		// TODO Auto-generated constructor stub
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<satislisteleme> tableview;

    @FXML
    private TableColumn<satislisteleme, String> tvcikis;

    @FXML
    private TableColumn<satislisteleme, String> tvgelis;

    @FXML
    private TableColumn<satislisteleme, String> tvparkyeri;

    @FXML
    private TableColumn<satislisteleme, String> tvplaka;

    @FXML
    private TableColumn<satislisteleme, String> tvsure;

    @FXML
    private TableColumn<satislisteleme, String> tvtutar;

    Connection conn = null;
   	PreparedStatement sorguIfadesi=null;
   	ResultSet fetch=null;
   	String sql;
   	public void fetchValues(TableView<satislisteleme> table){
    	sql="select * from satis";
    	ObservableList<satislisteleme> archives = FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=conn.prepareStatement(sql);
			ResultSet fetch = sorguIfadesi.executeQuery();
			while(fetch.next()) {
				archives.add(new satislisteleme(fetch.getInt("kID"),
												fetch.getString("parkyeri"),
												fetch.getString("plaka"),
												fetch.getString("gelis_tarihi"),
												fetch.getString("cikis_tarihi"),
												fetch.getString("sure"),
												fetch.getString("tutar")));	
			}
			//tvkid.setCellValueFactory(new PropertyValueFactory<>("kID"));
			tvparkyeri.setCellValueFactory(new PropertyValueFactory<>("parkyeri"));
			tvplaka.setCellValueFactory(new PropertyValueFactory<>("plaka"));
			tvgelis.setCellValueFactory(new PropertyValueFactory<>("gelis_tarihi"));
			tvcikis.setCellValueFactory(new PropertyValueFactory<>("cikis_tarihi"));
			tvsure.setCellValueFactory(new PropertyValueFactory<>("sure"));
			tvtutar.setCellValueFactory(new PropertyValueFactory<>("tutar"));
			tableview.setItems(archives);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    	
    }
    @FXML
    void initialize() {
    	
    	fetchValues(tableview);
    	
       

    }

}
