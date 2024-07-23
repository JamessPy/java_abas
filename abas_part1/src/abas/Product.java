package abas;

public class Product {
	
	private int siparis;
	private int mal_no;
	private int miktar;
	private double birim_fiyat;
	
	
	Product(int siparis,int mal_no,int miktar,double birim_fiyat){
		
		this.siparis = siparis;
		this.mal_no = mal_no;
		this.miktar = miktar;
		this.birim_fiyat = birim_fiyat;
	}
	
	public Product() {
	}

	public int getSiparis() {
		return siparis;
	}
	public void setSiparis(int siparis) {
		this.siparis = siparis;
	}
	public int getMal_no() {
		return mal_no;
	}
	public void setMal_no(int mal_no) {
		this.mal_no = mal_no;
	}
	public int getMiktar() {
		return miktar;
	}
	public void setMiktar(int miktar) {
		this.miktar = miktar;
	}
	public double getBirim_fiyat() {
		return birim_fiyat;
	}
	public void setBirim_fiyat(double birim_fiyat) {
		this.birim_fiyat = birim_fiyat;
	}

	@Override
	public String toString() {
		return "Product [siparis=" + siparis + ", mal_no=" + mal_no + ", miktar=" + miktar + ", birim_fiyat="
				+ birim_fiyat + "]";
	}
	
	
	
	

}
