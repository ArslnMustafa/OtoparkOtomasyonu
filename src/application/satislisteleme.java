package application;

public class satislisteleme {
	
	
	private Integer kID;
	private String parkyeri;
	private String plaka;
	private String gelis_tarihi;
	private String cikis_tarihi;
	private String sure;
	private String tutar;

	public satislisteleme() {
		// TODO Auto-generated constructor stub
	} 
	satislisteleme(Integer kID,String parkyeri,String plaka,String gelis_tarihi,String cikis_tarihi,String sure,String tutar){
		this.kID=kID;
        this.parkyeri=parkyeri;
        this.plaka=plaka;
        this.gelis_tarihi=gelis_tarihi;
        this.cikis_tarihi=cikis_tarihi;
        this.sure=sure;
        this.tutar=tutar;
        
	}
	public Integer getkID() {
		return kID;
	}
	public void setkID(Integer kID) {
		this.kID = kID;
	}
	public String getParkyeri() {
		return parkyeri;
	}
	public void setParkyeri(String parkyeri) {
		this.parkyeri = parkyeri;
	}
	public String getPlaka() {
		return plaka;
	}
	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}
	public String getGelis_tarihi() {
		return gelis_tarihi;
	}
	public void setGelis_tarihi(String gelis_tarihi) {
		this.gelis_tarihi = gelis_tarihi;
	}
	public String getCikis_tarihi() {
		return cikis_tarihi;
	}
	public void setCikis_tarihi(String cikis_tarihi) {
		this.cikis_tarihi = cikis_tarihi;
	}
	public String getSure() {
		return sure;
	}
	public void setSure(String sure) {
		this.sure = sure;
	}
	public String getTutar() {
		return tutar;
	}
	public void setTutar(String tutar) {
		this.tutar = tutar;
	}

}
