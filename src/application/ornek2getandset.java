package application;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ornek2getandset {
	public ornek2getandset() {
		// TODO Auto-generated constructor stub
	}
	
	int id;
	String kul_adi;
	double ortalama;
	Button buton;
	CheckBox onay;
	TextField metinkutusu;
	
	ornek2getandset(int id, String kul_adi, double ortalama, String icerik, Button buton){
		this.id=id;
		this.kul_adi=kul_adi;
		this.ortalama=ortalama;
		this.onay= new CheckBox();
		this.metinkutusu=new TextField();
		this.metinkutusu.setText(icerik);
		this.buton=buton;
		this.buton.setText("mesaj gönder");
		
		
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKul_adi() {
		return kul_adi;
	}

	public void setKul_adi(String kul_adi) {
		this.kul_adi = kul_adi;
	}

	public double getOrtalama() {
		return ortalama;
	}

	public void setOrtalama(double ortalama) {
		this.ortalama = ortalama;
	}

	public Button getButon() {
		return buton;
	}

	public void setButon(Button buton) {
		this.buton = buton;
	}

	public CheckBox getOnay() {
		return onay;
	}

	public void setOnay(CheckBox onay) {
		this.onay = onay;
	}

	public TextField getMetinkutusu() {
		return metinkutusu;
	}

	public void setMetinkutusu(TextField metinkutusu) {
		this.metinkutusu = metinkutusu;
	}

}
