package application;

public class aracotoparkkaydi {

	
	private String tc;
	private String ad;
    private String soyad;
    private String telefon;
    private String email;
    private String plaka;
    private String marka;
    private String renk;
    private String parkyeri;
    private String tarih;
    	
    aracotoparkkaydi() {
		
	}
	aracotoparkkaydi(String tc,String ad,String soyad, String telefon,String email,String plaka,String marka,String renk,String parkyeri,String tarih){
        this.tc=tc;
        this.ad=ad;
        this.soyad=soyad;
        this.telefon=telefon;
        this.email=email;
        this.plaka=plaka;
        this.marka=marka;
        this.renk=renk;
        this.parkyeri=parkyeri;
        this.tarih=tarih;
        
    }
	
    public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPlaka() {
		return plaka;
	}
	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getRenk() {
		return renk;
	}
	public void setRenk(String renk) {
		this.renk = renk;
	}
	public String getParkyeri() {
		return parkyeri;
	}
	public void setParkyeri(String parkyeri) {
		this.parkyeri = parkyeri;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	
}
