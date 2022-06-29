package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;

public class ornek1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEkle;

    @FXML
    private Button btnGoster;

    @FXML
    private Button btnGuncelle;

    @FXML
    private Button btnSil;

    @FXML
    private TableView<ornek1getandset> tableView;
    
    @FXML
    private TableColumn<ornek1getandset, Integer> tvid;

    @FXML
    private TableColumn<ornek1getandset, String> tvkuladi;

    @FXML
    private TableColumn<ornek1getandset, String> tvsifre;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtKul_adi;

    @FXML
    private TextField txtSifre;
    
    @FXML
    private Label lbldeger;


    ObservableList<ornek1getandset> veriler;
    @FXML
    void btnEkleOnAction(ActionEvent event) {

    	veriler = FXCollections.observableArrayList();
    	veriler.add(new ornek1getandset(Integer.parseInt(txtID.getText()),txtKul_adi.getText(),txtSifre.getText()));
    	tableView.getItems().addAll(veriler);
    }

    @FXML
    void btnGosterOnAction(ActionEvent event) {

    	ornek1getandset kayitlar = new ornek1getandset();
    	if (tableView.getSelectionModel().getSelectedIndex()!=-1) {
			kayitlar = (ornek1getandset) tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
			lbldeger.setText("id"+kayitlar.getId()+"\n kullanýcý adý:"+kayitlar.getKul_adi()+"\n sifre"+kayitlar.getSifre());
		}
    }

    @FXML
    void btnGuncelleOnAction(ActionEvent event) {
    	ornek1getandset kayitlar = new ornek1getandset();
    	if (tableView.getSelectionModel().getSelectedIndex()!=-1) {
    		kayitlar = (ornek1getandset) tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
    		int idm = kayitlar.getId();
    		ornek1getandset yk = new ornek1getandset(idm,txtKul_adi.getText(),txtSifre.getText());
    		int sira = tableView.getSelectionModel().getSelectedIndex();
    		tableView.getItems().set(sira, yk);
    	}
    }

    @FXML
    void btnSilOnAction(ActionEvent event) {
    	
    	ObservableList<ornek1getandset> tumKayitlar, secilenKayitlar;
    	tumKayitlar = tableView.getItems();
    	secilenKayitlar = tableView.getSelectionModel().getSelectedItems();
    	secilenKayitlar.forEach(tumKayitlar::remove);

    }

    @FXML
    void tableViewOnClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
    	
    	Tooltip tip1 = new Tooltip();
    	Tooltip tip2 = new Tooltip();
    	tip1.setText("silme yapar.");
    	tip2.setText("ekleme yapar.");
    	btnEkle.setTooltip(tip2);
    	btnSil.setTooltip(tip1);
    	
    	
    	tvid.setCellValueFactory(new PropertyValueFactory<>("id"));
    	tvkuladi.setCellValueFactory(new PropertyValueFactory<>("kul_adi"));
    	tvsifre.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    	//tableView.setItems(veriler);
        
    }

}
