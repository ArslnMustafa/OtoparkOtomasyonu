package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.mustafaarslanMySQL.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class otoparkCikisController {

	Connection conn = null;
   	PreparedStatement sorguIfadesi=null;
   	ResultSet fetch=null;
   	String sql;
   	
   	public otoparkCikisController() {
		// TODO Auto-generated constructor stub
		conn = VeritabaniUtil.Baglan();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAracCikisi;

    @FXML
    private Button btnIptal;
    
    @FXML
    private Button btnAra;

    @FXML
    private ComboBox<String> comboPlakaAra;

    @FXML
    private Label lblCikisTarihi;

    @FXML
    private Label lblGelisTarihi;

    @FXML
    private Label lblSure;

    @FXML
    private Label lblToplamTutar;

    @FXML
    private TextField txtAd;

    @FXML
    private TextField txtMarka;

    @FXML
    private TextField txtParkYeri2;

    @FXML
    private TextField txtPlaka;

    @FXML
    private TextField txtSeri;

    @FXML
    private TextField txtSoyad;

    @FXML
    private TextField txtTC;

    @FXML
    void btnAracCikisiOnAction(ActionEvent event) {

    	doldur();
    	sql="UPDATE aracdurumu SET durumu='BOS' WHERE parkyeri='"+txtParkYeri2.getText()+"'" ;
    	
    	 try {
         	sorguIfadesi=conn.prepareStatement(sql);
             sorguIfadesi.executeUpdate();

             
             
         } catch (Exception e) {
             // TODO: handle exception
             System.out.println(e.getMessage().toString());
         }
    	 
    	 sql="insert into satis(parkyeri, plaka, gelis_tarihi, cikis_tarihi, sure, tutar) values (?,?,?,?,?,?)";
     	try {
     		sorguIfadesi=conn.prepareStatement(sql);
     		sorguIfadesi.setString(1, txtParkYeri2.getText());
     		sorguIfadesi.setString(2, comboPlakaAra.getSelectionModel().getSelectedItem());
     		sorguIfadesi.setString(3, lblGelisTarihi.getText());
     		sorguIfadesi.setString(4, lblCikisTarihi.getText());
     		sorguIfadesi.setString(5, lblSure.getText());
     		sorguIfadesi.setString(6, lblToplamTutar.getText());
     		sorguIfadesi.executeUpdate();	
            txtAd.clear();
            txtMarka.clear();
            txtParkYeri2.clear();
            txtPlaka.clear();
            txtSeri.clear();
            txtSoyad.clear();
            txtTC.clear();
            
 		} catch (Exception e) {
 			System.out.println(e.getMessage().toString());
 		}
     	
     	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Araç Otopark Otomasyonu");
    	alert.setHeaderText("Araç çýkýþ iþlemi baþarýlý.");
    	alert.showAndWait();
    }
    
    @FXML
    void btnAraOnAction(ActionEvent event) {
    	doldur();
    	parkyeridoldur();
    }

    @FXML
    void btnIptalOnAction(ActionEvent event) {

    	try {
    		Stage stage = (Stage) btnIptal.getScene().getWindow();
            // do what you have to do
            stage.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    }
    
    public void cikis(){
    	
    	sql="SELECT plaka , durumu, ak.parkyeri, ad.parkyeri FROM aracotoparkkaydi ak INNER JOIN aracdurumu ad ON ak.parkyeri=ad.parkyeri where ad.durumu='DOLU'" ;
    	 ObservableList<String> archives = FXCollections.observableArrayList();
    	 try {
         	sorguIfadesi=conn.prepareStatement(sql);
             ResultSet fetch = sorguIfadesi.executeQuery();
             while(fetch.next()) {
        		 archives.add(fetch.getString("plaka"));   
        		 
             }
             comboPlakaAra.getItems().addAll(archives);
             comboPlakaAra.getSelectionModel().getSelectedItem();
         } catch (Exception e) {
             // TODO: handle exception
             System.out.println(e.getMessage().toString());
         }

    	 comboPlakaAra.getSelectionModel().getSelectedItem();
    	 
    	 lblCikisTarihi.setText(format.format(new java.util.Date()));
   
    }
    
    public void parkyeridoldur() {
    	sql="select *from aracotoparkkaydi where plaka='"+comboPlakaAra.getSelectionModel().getSelectedItem()+"'";
    	
    	
   	 ObservableList<String> archives = FXCollections.observableArrayList();
   	 try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
           	 archives.add(fetch.getString("tc"));
           	 archives.add(fetch.getString("ad"));
           	 archives.add(fetch.getString("soyad"));
           	 archives.add(fetch.getString("telefon"));
           	 archives.add(fetch.getString("email"));
           	 archives.add(fetch.getString("plaka"));
           	 archives.add(fetch.getString("marka"));
           	 archives.add(fetch.getString("renk"));
           	 archives.add(fetch.getString("parkyeri"));
           	 archives.add(fetch.getString("tarih"));
            }
            txtTC.setText(archives.get(0));
            txtAd.setText(archives.get(1));
            txtSoyad.setText(archives.get(2));
            txtMarka.setText(archives.get(6));
            txtPlaka.setText(archives.get(5)); 
            txtSeri.setText(archives.get(7));
            txtParkYeri2.setText(archives.get(8));
            lblGelisTarihi.setText(archives.get(9));
    }catch (Exception e) {
        // TODO: handle exception
        System.out.println(e.getMessage().toString());
    }
   }
    
    public void doldur() {
    	
    	sql="select *from aracotoparkkaydi where plaka='"+comboPlakaAra.getSelectionModel().getSelectedItem()+"'";
    	
    	
    	 ObservableList<String> archives = FXCollections.observableArrayList();
    	 try {
         	sorguIfadesi=conn.prepareStatement(sql);
             ResultSet fetch = sorguIfadesi.executeQuery();
             while(fetch.next()) {
            	 archives.add(fetch.getString("tc"));
            	 archives.add(fetch.getString("ad"));
            	 archives.add(fetch.getString("soyad"));
            	 archives.add(fetch.getString("telefon"));
            	 archives.add(fetch.getString("email"));
            	 archives.add(fetch.getString("plaka"));
            	 archives.add(fetch.getString("marka"));
            	 archives.add(fetch.getString("renk"));
            	 archives.add(fetch.getString("parkyeri"));
            	 archives.add(fetch.getString("tarih"));
             }
             
             lblGelisTarihi.setText(archives.get(9));
             SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
             Date firstDate = sdf.parse(archives.get(9));
             Date secondDate = sdf.parse(format.format(new java.util.Date()));

             long diff = secondDate.getTime() - firstDate.getTime();

             TimeUnit time = TimeUnit.MINUTES; 
             long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
             lblSure.setText(String.valueOf(diffrence)+" Dakika");
             double sonuc = 0;
             final double otoParkUcret = 0.5;
             
             int i = (int)diffrence;
             sonuc = otoParkUcret * i;
             lblToplamTutar.setText(String.valueOf(sonuc));
             
         } catch (Exception e) {
             // TODO: handle exception
             System.out.println(e.getMessage().toString());
         }
    }

    LocalTime myObj = LocalTime.now();
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
	
    @FXML
    void initialize() {
    	
        cikis();
        
        Tooltip tip = new Tooltip();
        Tooltip tip1 = new Tooltip();
        Tooltip tip2= new Tooltip();
        tip.setStyle("-fx-background-color: gray");
        tip.setText("Plakaya göre arama iþlemi yapar.");
        tip1.setStyle("-fx-background-color: gray");
        tip1.setText("Çýkýþ yapar.");
        tip2.setStyle("-fx-background-color: gray");
        tip2.setText("Aracýn otoparktan çýkýþýný yapar.");
        btnAra.setTooltip(tip);
        btnIptal.setTooltip(tip1);
        btnAracCikisi.setTooltip(tip2);
    }

}
