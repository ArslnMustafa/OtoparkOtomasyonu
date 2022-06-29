package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import com.mustafaarslanMySQL.Util.VeritabaniUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.*;
import java.text.SimpleDateFormat;

public class otoparkKaydiController {
	

	public otoparkKaydiController(){
		conn =VeritabaniUtil.Baglan();
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIptal;

    @FXML
    private Button btnKayit;
    
    @FXML
    private Button btnMarkaEkle;

    @FXML
    private ComboBox<String> comboMarka;

    @FXML
    private ComboBox<String> comboParkYeri;

    @FXML
    private TextField txtAd;
    
    @FXML
    private ImageView img1;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPlaka;

    @FXML
    private TextField txtRenk;

    @FXML
    private TextField txtSoyad;

    @FXML
    private TextField txtTC;

    @FXML
    private TextField txtTelefon;
    
    Connection conn = null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	@FXML
    void comboMarkaOnMouseClicked(MouseEvent event) {


    }
	
	
    @FXML
    void btnIptalOnAction(ActionEvent event) {
    	
    	try {
    		Stage stage = (Stage) btnIptal.getScene().getWindow();
            // do what you have to do
            stage.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    
    @FXML
    void img1OnAction(MouseEvent event) {

    	try {
    		Stage stage=new Stage();
        	AnchorPane pane1=(AnchorPane) FXMLLoader.load(getClass().getResource("markaEkle.fxml"));
        	Scene scene1=new Scene(pane1);
        	stage.setScene(scene1);
        	stage.show();
			
		} catch (Exception e) {
			
		}
    }
    

    @FXML
    void btnKayitOnAction(ActionEvent event) {
    	bosAraclar();
    	markalar();
    	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    	sql="insert into aracotoparkkaydi(tc,ad,soyad,telefon,email,plaka,marka,renk,parkyeri,tarih) values (?,?,?,?,?,?,?,?,?,?) ";
    	try {
			sorguIfadesi=conn.prepareStatement(sql);
			sorguIfadesi.setString(1, txtTC.getText().trim());
			sorguIfadesi.setString(2, txtAd.getText().trim());
			sorguIfadesi.setString(3, txtSoyad.getText().trim());
			sorguIfadesi.setString(4, txtTelefon.getText().trim());
			sorguIfadesi.setString(5, txtEmail.getText().trim());
			sorguIfadesi.setString(6, txtPlaka.getText().trim());
			sorguIfadesi.setString(7, comboMarka.getSelectionModel().getSelectedItem());
			sorguIfadesi.setString(8, txtRenk.getText().trim());
			sorguIfadesi.setString(9, comboParkYeri.getSelectionModel().getSelectedItem());
			sorguIfadesi.setString(10, format.format(new Date()));	
			sorguIfadesi.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
    	sql="update aracdurumu set durumu='DOLU' WHERE parkyeri='"+comboParkYeri.getSelectionModel().getSelectedItem()+"'";
        	try {
				sorguIfadesi=conn.prepareStatement(sql);
				sorguIfadesi.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			}
        	
        	Alert alert = new Alert(AlertType.INFORMATION);
        	alert.setTitle("Araç Otopark Otomasyonu");
        	alert.setHeaderText("Kayýt iþlemi baþarýlý.");
        	alert.showAndWait();
        	txtTC.clear();
        	txtAd.clear();
        	txtSoyad.clear();
        	txtTelefon.clear();
        	txtEmail.clear();
        	txtPlaka.clear();
        	txtRenk.clear();
            comboMarka.getSelectionModel().clearSelection();
            comboParkYeri.getSelectionModel().clearSelection();    	
    }  
    
    public void markalar() {
    	sql="select * from markabilgileri";
        //ArrayList<String> a = new ArrayList<String>();
        ObservableList<String> archives = FXCollections.observableArrayList();
        try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	archives.add(fetch.getString("marka"));
            }
            comboMarka.getItems().addAll(archives);    
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    
    @FXML
    void initialize() {
    	bosAraclar();
    	markalar();    
    	Tooltip tip = new Tooltip();
        Tooltip tip1 = new Tooltip();
       
        tip.setStyle("-fx-background-color: gray");
        tip.setText("Araç kaydýnýzý yapar.");
        tip1.setStyle("-fx-background-color: gray");
        tip1.setText("Çýkýþ yapar.");
        
        btnKayit.setTooltip(tip);
        btnIptal.setTooltip(tip1);
        

    }
    
    
    public void bosAraclar(){
        sql="select * from aracdurumu where parkyeri OR durumu='BOS' ";
        ArrayList<String> a = new ArrayList<String>();
        //ObservableList<aracdurumu> archives = FXCollections.observableArrayList();
        try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	a.add(fetch.getString("parkyeri"));
            }
            for(int i=0;i<11;i++) {
        		comboParkYeri.getItems().addAll(a.get(i));
        	}
        } catch (Exception e) {
            // TODO: handle exception 
        }	
	}
}
