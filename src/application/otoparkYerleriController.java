package application;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.mustafaarslanMySQL.Util.VeritabaniUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class otoparkYerleriController {
	
	Connection conn = null;
   	PreparedStatement sorguIfadesi=null;
   	ResultSet fetch=null;
   	String sql;
	public otoparkYerleriController() {

		conn = VeritabaniUtil.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private Button btn10;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;
    @FXML
    private Label lblp1;
 
    public void doluAraclar(){
        sql="select * from aracdurumu where parkyeri OR durumu='DOLU'";
        ArrayList<String> a = new ArrayList<String>();
        
       
        try {
        	sorguIfadesi=conn.prepareStatement(sql);
        	sorguIfadesi.executeQuery();
            btn1.setText(a.get(2));
        } catch (Exception e) {
            // TODO: handle exception
        }	
	}
   	
   	public void bosAraclar(){
            sql="select * from aracdurumu where parkyeri OR durumu='BOS'; ";
            ArrayList<String> a = new ArrayList<String>();
            //ObservableList<aracdurumu> archives = FXCollections.observableArrayList();
            try {
            	sorguIfadesi=conn.prepareStatement(sql);
                ResultSet fetch = sorguIfadesi.executeQuery();
                while(fetch.next()) {
                	a.add(fetch.getString("durumu"));
                }
                btn1.setText(a.get(2));
            } catch (Exception e) {
                // TODO: handle exception
            }    	
   	}
   	
   	public void Kontrol() {
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-1' AND durumu='DOLU'";
   		ArrayList<String> b = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	b.add(fetch.getString("durumu"));
            }if (b.get(0).equals("DOLU")) {
				btn1.setText(b.get(0));
				btn1.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            
        }
   		//**************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-2' AND durumu='DOLU'";
   		ArrayList<String> c = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	c.add(fetch.getString("durumu"));
            }if (c.get(0).equals("DOLU")) {
				btn2.setText(c.get(0));
				btn2.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            
        }
   		//*****************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-3' AND durumu='DOLU'";
   		ArrayList<String> d = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	d.add(fetch.getString("durumu"));
            }if (d.get(0).equals("DOLU")) {
				btn3.setText(d.get(0));
				btn3.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
        	
        }
   		//*************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-4' AND durumu='DOLU'";
   		ArrayList<String> f = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	f.add(fetch.getString("durumu"));
            }if (f.get(0).equals("DOLU")) {
				btn4.setText(f.get(0));
				btn4.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            
        }
   		
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-5' AND durumu='DOLU'";
   		ArrayList<String> g = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	g.add(fetch.getString("durumu"));

            }if (g.get(0).equals("DOLU")) {
				btn5.setText(g.get(0));
				btn5.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            // TODO: handle exception
            
        }
   	//*************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-6' AND durumu='DOLU'";
   		ArrayList<String> h = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	h.add(fetch.getString("durumu"));
            }if (h.get(0).equals("DOLU")) {
				btn6.setText(h.get(0));
				btn6.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            
        }
   	//*************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-7' AND durumu='DOLU'";
   		ArrayList<String> l = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	l.add(fetch.getString("durumu"));
            }if (l.get(0).equals("DOLU")) {
				btn7.setText(l.get(0));
				btn7.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            
        }
   	//*************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-8' AND durumu='DOLU'";
   		ArrayList<String> s = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	s.add(fetch.getString("durumu"));
            }if (s.get(0).equals("DOLU")) {
				btn8.setText(s.get(0));
				btn8.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            
        }
   	//*************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-9' AND durumu='DOLU'";
   		ArrayList<String> m = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	m.add(fetch.getString("durumu"));
            }if (m.get(0).equals("DOLU")) {
				btn9.setText(m.get(0));
				btn9.setStyle("-fx-background-color:#b71c1c");
				
			
			}
        } catch (Exception e) {
            
        }
   	//*************
   		sql="SELECT * FROM aracdurumu WHERE parkyeri='P-10' AND durumu='DOLU'";
   		ArrayList<String> n = new ArrayList<String>();
   		try {
        	sorguIfadesi=conn.prepareStatement(sql);
            ResultSet fetch = sorguIfadesi.executeQuery();
            while(fetch.next()) {
            	n.add(fetch.getString("durumu"));
            }if (n.get(0).equals("DOLU")) {
				btn10.setText(n.get(0));
				btn10.setStyle("-fx-background-color:#b71c1c");
			}
        } catch (Exception e) {
            
        }
   		
   	}
  	
    @FXML
    void initialize() {
        Kontrol();
    }

}
