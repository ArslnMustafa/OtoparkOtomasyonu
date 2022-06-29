package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import com.mustafaarslanMySQL.Util.VeritabaniUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class satisController {
	public satisController() {
		// TODO Auto-generated constructor stub
		conn = VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGuncelle;

    @FXML
    private Button btnSil;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableAd;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableEmail;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableMarka;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableParkYeri;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tablePlaka;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableRenk;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableSoyad;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableTarih;

    @FXML
    private TableColumn<aracotoparkkaydi, String> tableTelefon;

    @FXML
    private TableView<aracotoparkkaydi> tableview;

    @FXML
    private Button tiklabuton;

    @FXML
    private TextField txtAd;
    
    @FXML
    private Label labelParkYeri;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMarka;

    @FXML
    private TextField txtPlaka;

    @FXML
    private TextField txtRenk;

    @FXML
    private TextField txtSoyad;

    @FXML
    private TextField txtTelefon;
    
    @FXML
    void txtAd(KeyEvent event) {

    	if(txtAd.getText().equals("")) {
    		sql="select * from aracotoparkkaydi";
    	}else {
    		sql="select * from aracotoparkkaydi where ad like '%"+txtAd.getText()+"%'";
    	}
    	fetchValues(tableview, sql);
    }

    @FXML
    void txtSoyad(KeyEvent event) {

    	if(txtSoyad.getText().equals("")) {
    		sql="select * from aracotoparkkaydi";
    	}else {
    		sql="select * from aracotoparkkaydi where soyad like '%"+txtSoyad.getText()+"%'";
    	}
    	fetchValues(tableview, sql);
    }

    @FXML
    void txtemail(KeyEvent event) {

    	if(txtEmail.getText().equals("")) {
    		sql="select * from aracotoparkkaydi";
    	}else {
    		sql="select * from aracotoparkkaydi where email like '%"+txtEmail.getText()+"%'";
    	}
    	fetchValues(tableview, sql);
    }

    @FXML
    void txtmarka(KeyEvent event) {

    	if(txtMarka.getText().equals("")) {
    		sql="select * from aracotoparkkaydi";
    	}else {
    		sql="select * from aracotoparkkaydi where marka like '%"+txtMarka.getText()+"%'";
    	}
    	fetchValues(tableview, sql);
    
    }

    @FXML
    void txtplaka(KeyEvent event) {

    	if(txtPlaka.getText().equals("")) {
    		sql="select * from aracotoparkkaydi";
    	}else {
    		sql="select * from aracotoparkkaydi where plaka like '%"+txtPlaka.getText()+"%'";
    	}
    	fetchValues(tableview, sql);
    }

    @FXML
    void txtrenk(KeyEvent event) {

    	if(txtRenk.getText().equals("")) {
    		sql="select * from aracotoparkkaydi";
    	}else {
    		sql="select * from aracotoparkkaydi where renk like '%"+txtRenk.getText()+"%'";
    	}
    	fetchValues(tableview, sql);
    }

    @FXML
    void txttelefon(KeyEvent event) {

    	if(txtTelefon.getText().equals("")) {
    		sql="select * from aracotoparkkaydi";
    	}else {
    		sql="select * from aracotoparkkaydi where telefon like '%"+txtTelefon.getText()+"%'";
    	}
    	fetchValues(tableview, sql);
    }
    
    
    @FXML
    void tableviewOnClicked(MouseEvent event) {

    	
    aracotoparkkaydi kayit = new aracotoparkkaydi();
	int secilenIndex = tableview.getSelectionModel().getSelectedIndex();
		if(secilenIndex != -1) {
			kayit=(aracotoparkkaydi) tableview.getItems().get(secilenIndex);
			
			txtAd.setText(String.valueOf(kayit.getAd()));
			txtSoyad.setText(kayit.getSoyad());
			txtTelefon.setText(kayit.getTelefon());
			txtEmail.setText(kayit.getEmail());
			txtPlaka.setText(kayit.getPlaka());
			txtMarka.setText(kayit.getMarka());
			txtRenk.setText(kayit.getRenk());
		}
    }
    
    @FXML
    void btnGuncelleOnAction(ActionEvent event) {

    	sql="update aracotoparkkaydi set ad=?,soyad =?,telefon =?,email =?,plaka =?,marka =?,renk =? where ad=? or plaka=?";
    	try {
    		sorguIfadesi=conn.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtAd.getText());
    		sorguIfadesi.setString(2, txtSoyad.getText());
    		sorguIfadesi.setString(3, txtTelefon.getText());
    		sorguIfadesi.setString(4, txtEmail.getText());
    		sorguIfadesi.setString(5, txtPlaka.getText());
    		sorguIfadesi.setString(6, txtMarka.getText());
    		sorguIfadesi.setString(7, txtRenk.getText());
    		sorguIfadesi.setString(8, txtAd.getText());
    		sorguIfadesi.setString(9, txtPlaka.getText());
    		sorguIfadesi.executeUpdate();
    		String s="select * from aracotoparkkaydi";
    		fetchValues(tableview,s);
    		txtAd.clear();
    		txtSoyad.clear();
    		txtTelefon.clear();
    		txtEmail.clear();
    		txtPlaka.clear();
    		txtRenk.clear();
    		txtMarka.clear();
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    }

    @FXML
    void btnSilOnAction(ActionEvent event) {
    	
    	String a="select parkyeri from aracotoparkkaydi where plaka='"+txtPlaka.getText()+"'";
	   	 ObservableList<String> archives = FXCollections.observableArrayList();
	   	 try {
	        	sorguIfadesi=conn.prepareStatement(a);
	            ResultSet fetch = sorguIfadesi.executeQuery();
	            while(fetch.next()) {
	       		 archives.add(fetch.getString("parkyeri"));  
	       		 
	            }
	            labelParkYeri.setText(archives.get(0));
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage().toString());
	        }
	       String b="UPDATE aracdurumu SET durumu='BOS' WHERE parkyeri='"+labelParkYeri.getText()+"'" ;
	       try {
	        	sorguIfadesi=conn.prepareStatement(b);
	            sorguIfadesi.executeUpdate();
	
	            
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage().toString());
	        }
    	
    	sql="delete from aracotoparkkaydi where ad=? and plaka=?";
    	try {
    		sorguIfadesi=conn.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtAd.getText());
    		sorguIfadesi.setString(2, txtPlaka.getText());
    		sorguIfadesi.executeUpdate();
    		String s = "select * from aracotoparkkaydi";
    		fetchValues(tableview,s);
    		
    		txtAd.clear();
    		txtSoyad.clear();
    		txtTelefon.clear();
    		txtEmail.clear();
    		txtPlaka.clear();
    		txtRenk.clear();
    		txtMarka.clear();
    	

			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
    	
        
    	

    }
    
    Connection conn = null;
	PreparedStatement sorguIfadesi=null;
	ResultSet fetch=null;
	String sql;
	
    public void fetchValues(TableView<aracotoparkkaydi> table, String sql){
       // sql="select * from aracotoparkkaydi";
        ObservableList<aracotoparkkaydi> archives = FXCollections.observableArrayList();
        try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
                archives.add(new aracotoparkkaydi(fetch.getString("tc"),
                                                fetch.getString("ad"),
                                                fetch.getString("soyad"),
                                                fetch.getString("telefon"),
                                                fetch.getString("email"),
                                                fetch.getString("plaka"),
                                                fetch.getString("marka"),
                                                fetch.getString("renk"),
                                                fetch.getString("parkyeri"),
                                                fetch.getString("tarih")));    
            }
            
            tableAd.setCellValueFactory(new PropertyValueFactory<>("ad"));
            tableSoyad.setCellValueFactory(new PropertyValueFactory<>("soyad"));
            tableTelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
            tableEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            tablePlaka.setCellValueFactory(new PropertyValueFactory<>("plaka"));
            tableMarka.setCellValueFactory(new PropertyValueFactory<>("marka"));
            tableRenk.setCellValueFactory(new PropertyValueFactory<>("renk"));
            tableParkYeri.setCellValueFactory(new PropertyValueFactory<>("parkyeri"));
            tableTarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
            tableview.setItems(archives);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage().toString());
        }
        
    }


    @FXML
    void initialize() {
    	String s = "select * from aracotoparkkaydi" ;
        fetchValues(tableview,s);
        Tooltip tip = new Tooltip();
        Tooltip tip1 = new Tooltip();
        tip.setStyle("-fx-background-color: gray");
        tip.setText("Verileri siler.");
        tip1.setStyle("-fx-background-color: gray");
        tip1.setText("Verileri Günceller.");
        btnSil.setTooltip(tip);
        btnGuncelle.setTooltip(tip1);
    }
    
   
    
}
