package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import com.mustafaarslanMySQL.Util.VeritabaniUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class kullaniciBilgiController {
	public kullaniciBilgiController() {
		// TODO Auto-generated constructor stub
		conn = VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSorgula;

    @FXML
    private TextField txtAd;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMarka;

    @FXML
    private TextField txtParkYeri;
    
    @FXML
    private Label txtGelisTarihi;
    
    @FXML
    private Label txtCikisTarihi;
    
    @FXML
    private Label lblTutar;

    @FXML
    private TextField txtPlaka;

    @FXML
    private TextField txtRenk;

    @FXML
    private TextField txtSoyad;

    @FXML
    private TextField txtTC;
    
    @FXML
    private ImageView imgClose;

    @FXML
    private TextField txtTelefon;

    Connection conn = null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	String name;
	
	public void VeriAl(String deger) {
	    	
			name = deger;
			sql="SELECT * FROM aracotoparkkaydi ak INNER JOIN login log ON ak.ad =log.user where ak.ad='"+name+"'";
	    	try {
	    		sorguIfadesi=conn.prepareStatement(sql);
				getirilen = sorguIfadesi.executeQuery();
				ArrayList<String> archives = new ArrayList<String>();
				while(getirilen.next()) {
					archives.add(getirilen.getString("plaka"));
				}
				txtPlaka.setText(archives.get(0));
				

			} catch (Exception e) {
				// TODO: handle exception
			}
	 }
	
    @FXML
    void btnSorgulaOnAction(ActionEvent event) {

    	sql="SELECT * FROM aracotoparkkaydi ak INNER JOIN login log ON ak.ad =log.user where ak.plaka='"+txtPlaka.getText()+"'";
    	
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
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            txtTC.setText(archives.get(0));
            txtAd.setText(archives.get(1));
            txtSoyad.setText(archives.get(2));
            txtTelefon.setText(archives.get(3));
            txtEmail.setText(archives.get(4));
            txtPlaka.setText(archives.get(5));
            txtMarka.setText(archives.get(6));
            txtRenk.setText(archives.get(7));
            txtParkYeri.setText(archives.get(8));
            txtGelisTarihi.setText(archives.get(9));
            txtCikisTarihi.setText(format.format(new java.util.Date()));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date firstDate = sdf.parse(archives.get(9));
            Date secondDate = sdf.parse(format.format(new java.util.Date()));

            long diff = secondDate.getTime() - firstDate.getTime();

            TimeUnit time = TimeUnit.MINUTES; 
            long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            //lblSure.setText("Aracýnýz "+String.valueOf(diffrence)+" dakikadýr Otoparktadýr.");
            double sonuc = 0;
            final double otoParkUcret = 0.5;
            
            int i = (int)diffrence;
            sonuc = otoParkUcret * i;
            lblTutar.setText( String.valueOf(sonuc));
            
          
        }
        catch (Exception e) {
				// TODO: handle exception
        	System.out.println(e.getMessage().toString());
		}
            
    	
    }
    
    @FXML
    void imgCloseOnClicked(MouseEvent event) {
    	
    	try {
    		Stage stage = (Stage) imgClose.getScene().getWindow();
            // do what you have to do
            stage.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

    }
    @FXML
    void initialize() {
        
    	
    	Tooltip tip = new Tooltip();
        
        tip.setStyle("-fx-background-color: gray");
        tip.setText("Araç plakanýza göre sorgulama yapar.");
        
        btnSorgula.setTooltip(tip);
       
    }

}
