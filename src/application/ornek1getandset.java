package application;

public class ornek1getandset {
	
	int id;
	String kul_adi;
	String sifre;
	
	public ornek1getandset() {
		// TODO Auto-generated constructor stub
	}
	ornek1getandset(int id,String kul_adi,String sifre){
		this.id=id;
		this.kul_adi=kul_adi;
		this.sifre=sifre;
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
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	

}
