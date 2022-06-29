package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mustafaarslanMySQL.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	public LoginController() {
		// TODO Auto-generated constructor stub
		conn= VeritabaniUtil.Baglan();
	}

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button btnGiris;

	    @FXML
	    private Button btnIptal;
	    
	    @FXML
	    private Label lblhataligiris;
	    	    
	    @FXML
	    private Button btnekle;

	    @FXML
	    private ImageView imgLoginResim;

	    @FXML
	    private PasswordField psfPassword;

	    @FXML
	    private TextField txtUser;
	    
	    @FXML
	    void btnekleOnAction(ActionEvent event) {

	    	sql="insert into login(user,password,role) values (?,?,?)";
	        try {
	        	sorguIfadesi=conn.prepareStatement(sql);
	        	sorguIfadesi.setString(1, txtUser.getText());
	        	sorguIfadesi.setString(2, VeritabaniUtil.MD5(psfPassword.getText().trim()));
	        	sorguIfadesi.setString(3, "0");
	            sorguIfadesi.executeUpdate();
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage().toString());
	        }
	    }

	    
	    @FXML
	    void btnGirisOnAction(ActionEvent event) {

	    	sql="select * from login where user=? and password=? and role=1";
	    	
	    	try {
	        	sorguIfadesi=conn.prepareStatement(sql);
	        	sorguIfadesi.setString(1, txtUser.getText());
	        	sorguIfadesi.setString(2, VeritabaniUtil.MD5(psfPassword.getText().trim()));

	            ResultSet fetch = sorguIfadesi.executeQuery();
	            if(!fetch.next()) {
	            	
	            	lblhataligiris.setText("Kullanýcý Adý veya Þifreniz Hatalýdýr.");
	            	
	            }else {
	            	try {
	            		Stage stage=new Stage();
	                	AnchorPane pane1=(AnchorPane) FXMLLoader.load(getClass().getResource("anasayfa.fxml"));
	                	Scene scene1=new Scene(pane1);
	                	stage.setScene(scene1);
	                	stage.setTitle("Otopark Otomasyonu");
	                	stage.show();
	                	
	        			
	        		} catch (Exception e) {
	        			
	        		}
	            	try {
	    	    		Stage stage = (Stage) btnGiris.getScene().getWindow();
	    	            // do what you have to do
	    	            stage.close();
	    				
	    			} catch (Exception e) {
	    				// TODO: handle exception
	    			}
				}     
	        } catch (Exception e) {
	            // TODO: handle exception
	            //System.out.println(e.getMessage().toString());
	        }
	    	

	    	sql="select * from login where user=? and password=? and role=0";
	    	
	    	try {
	        	sorguIfadesi=conn.prepareStatement(sql);
	        	sorguIfadesi.setString(1, txtUser.getText());
	        	sorguIfadesi.setString(2, VeritabaniUtil.MD5(psfPassword.getText().trim()));//þifreyi mdd5 ile þifreli olarak db ye gönderdik.

	            ResultSet fetch = sorguIfadesi.executeQuery();
	            if(!fetch.next()) {
	            	lblhataligiris.setText("Kullanýcý Adý veya Þifreniz Hatalýdýr.");
	            	
	            }else {
	            	try {
	            		  FXMLLoader loader = new FXMLLoader();
					       loader.setLocation(getClass().getResource("kullaniciBilgi.fxml"));
					       Parent tableViewParent = loader.load();
					       Scene tableViewScene = new Scene(tableViewParent);
					       kullaniciBilgiController controller = loader.getController();
					       controller.VeriAl(txtUser.getText());
					       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
					       window.setScene(tableViewScene);
					       window.show();
	                	
	        			
	        		} catch (Exception e) {
	        			
	        		}
	            	try {
	    	    		Stage stage = (Stage) btnGiris.getScene().getWindow();
	    	            // do what you have to do
	    	            stage.close();
	    				
	    			} catch (Exception e) {
	    				// TODO: handle exception
	    			}
				}
	            
	            
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println(e.getMessage().toString());
	        }
	    	
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

    
	    Connection conn = null;
		PreparedStatement sorguIfadesi=null;
		ResultSet getirilen=null;
		String sql;

    @FXML
    void initialize() {
    	btnekle.setTooltip(new Tooltip("btn ekle"));
    	Tooltip tip = new Tooltip();
        Tooltip tip1 = new Tooltip();
        //Tooltip tip2= new Tooltip();
        tip.setStyle("-fx-background-color: gray");
        tip.setText("Giriþ yapar.");
        tip1.setStyle("-fx-background-color: gray");
        tip1.setText("Çýkýþ yapar.");
        //tip2.setStyle("-fx-background-color: gray");
        //tip2.setText("Veri tabanýna kullanýcý eklemesi yapar.");
        btnGiris.setTooltip(tip);
        btnIptal.setTooltip(tip1);
        //btnekle.setTooltip(tip2);
   }
    


}
