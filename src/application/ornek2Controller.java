package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ornek2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_goster;

    @FXML
    private Button btn_guncelle;

    @FXML
    private Button btn_secili;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_yorum;

    @FXML
    private TableView<ornek2getandset> kayitlar_table;
    
    @FXML
    private TableColumn<ornek2getandset, String> buton_sutun;

    @FXML
    private TableColumn<ornek2getandset, Integer> id;

    @FXML
    private TableColumn<ornek2getandset, String> kul_adi;

    @FXML
    private TableColumn<ornek2getandset, Double> ortalama;

    @FXML
    private TableColumn<ornek2getandset, String> secili;
    
    @FXML
    private TableColumn<ornek2getandset, String> yorum;

    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;

    ObservableList<ornek2getandset> kayitlar ;
    Button[] butonlar = new Button[10];
    int butonNo=0;

    @FXML
    void btn_ekle_Click(ActionEvent event) {
    	
    	
    	kayitlar = FXCollections.observableArrayList();
    
    	
    	kayitlar.add(new ornek2getandset(3,txt_kul.getText(),Double.parseDouble(txt_sifre.getText()),"Varsayýlan",butonlar[butonNo]));
    	kayitlar_table.getItems().addAll(kayitlar);
    }

    @FXML
    void btn_goster_Click(ActionEvent event) {
    	ornek2getandset kayit = new ornek2getandset();
    	if (kayitlar_table.getSelectionModel().getSelectedIndex()!=-1) {
			System.out.println("seçilen kullanýcý: "+kayit.getKul_adi());
			System.out.println("ortalama: "+kayit.getOrtalama());
			System.out.println("ID: "+ kayit.getId());
		}

    }

    @FXML
    void btn_guncelle_Click(ActionEvent event) {
    	ornek2getandset kayit = new ornek2getandset();
    	if(kayitlar_table.getSelectionModel().getSelectedIndex()!=-1) {
    		kayit =(ornek2getandset) kayitlar_table.getItems().get(kayitlar_table.getSelectionModel().getSelectedIndex());
    		int idm = kayit.getId()-1;
    		ornek2getandset yk = new ornek2getandset(idm+1, txt_kul.getText(),Double.parseDouble(txt_sifre.getText()),"Güncellenen Mesaj",butonlar[idm]);
    		int sira = kayitlar_table.getSelectionModel().getSelectedIndex();
    		kayitlar_table.getItems().set(sira, yk);
    	}

    }
    

    @FXML
    void btn_secili_click(ActionEvent event) {
    	
    	for(ornek2getandset islem: kayitlar) {
    		if (islem.getOnay().isSelected()) {
				System.out.println("seçilenler: "+islem.getKul_adi());
			}
    	}
    }

    @FXML
    void btn_sil_Click(ActionEvent event) {

    	ObservableList<ornek2getandset> tumKayitlar, secilenKayitlar;
    	tumKayitlar =kayitlar_table.getItems();
    	secilenKayitlar= kayitlar_table.getSelectionModel().getSelectedItems();
    	secilenKayitlar.forEach(tumKayitlar::remove);
    			
    }

    @FXML
    void btn_yorum_Click(ActionEvent event) {

    	for(ornek2getandset islem:kayitlar) {
    		if(!islem.getMetinkutusu().getText().isEmpty()) {
    			if(islem.getOnay().isSelected()) {
    				System.out.println("yorum: "+islem.getMetinkutusu().getText());
    			}
    		}
    	}
    }

    @FXML
    void kayitlar_table_Click(MouseEvent event) {

    }

    @FXML
    void initialize() {
    	
    	for(int i =0; i<butonlar.length;i++) {
    		butonlar[i]=new Button();
    		butonlar[i].setId("btn"+i);
    		butonlar[i].setOnAction(this::ButonOlayi);
    	}
    
    	
    	kayitlar=FXCollections.observableArrayList();
    	kayitlar.add(new ornek2getandset(1, "admin", 0.5, "Mesaj 1", butonlar[butonNo]));
   	 	butonNo++;
  	 	kayitlar.add(new ornek2getandset(2, "root", 0.89, "Mesaj 2", butonlar[butonNo]));
   	 	butonNo++;
   	 	kayitlar.add(new ornek2getandset(3, "user", 0.56, "Mesaj 3", butonlar[butonNo]));
   	 	butonNo++;
    	
    	id.setCellValueFactory(new PropertyValueFactory<>("id"));
    	kul_adi.setCellValueFactory(new PropertyValueFactory<>("kul_adi"));
    	ortalama.setCellValueFactory(new PropertyValueFactory<>("ortalama"));
    	yorum.setCellValueFactory(new PropertyValueFactory<>("metinkutusu"));
    	secili.setCellValueFactory(new PropertyValueFactory<>("onay"));
    	buton_sutun.setCellValueFactory(new PropertyValueFactory<>("buton"));
    	kayitlar_table.setItems(kayitlar);;
    }
    @FXML
    void ButonOlayi(ActionEvent event) {
    	for(int i =0; i<butonlar.length;i++) {
    		if (event.getSource() ==butonlar[i]) {
    			for(ornek2getandset islem:kayitlar) {
					if (islem.getOnay().isSelected()) {
						int idm =islem.getId()-1;
						ornek2getandset  ort= new ornek2getandset(islem.getId(),islem.getKul_adi(),Double.parseDouble(islem.getMetinkutusu().getText()),"",butonlar[idm]);
						int sira = kayitlar_table.getSelectionModel().getSelectedIndex();
						kayitlar_table.getItems().set(sira, ort);
					}
				}
			}
    	}
    }

}
