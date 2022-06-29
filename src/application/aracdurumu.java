package application;

public class aracdurumu {

	private String parkyeri;
	private String durumu;
	
	
	
	
	public aracdurumu() {
		// TODO Auto-generated constructor stub
	}
	aracdurumu(String parkyeri,String durumu){
        this.parkyeri=parkyeri;
        this.durumu=durumu;
        
        
	}
	public String getParkyeri() {
		return parkyeri;
	}
	public void setParkyeri(String parkyeri) {
		this.parkyeri = parkyeri;
	}
	public String getDurumu() {
		return durumu;
	}
	public void setDurumu(String durumu) {
		this.durumu = durumu;
	}
	
	
}
