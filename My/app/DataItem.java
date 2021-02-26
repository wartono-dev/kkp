public class DataItem{

	@SerializedName("nama_teknisi")
	private String namaTeknisi;

	@SerializedName("tanggal_pesanan")
	private String tanggalPesanan;

	@SerializedName("nomer_kontak")
	private String nomerKontak;

	@SerializedName("alamat_pemesan")
	private String alamatPemesan;

	@SerializedName("id_pesan")
	private String idPesan;

	@SerializedName("jenis_pesanan")
	private String jenisPesanan;

	@SerializedName("nama_pemesan")
	private String namaPemesan;

	@SerializedName("nomer_kontak_pemesan")
	private String nomerKontakPemesan;

	@SerializedName("kota_administrasi")
	private String kotaAdministrasi;

	@SerializedName("status_pesanan")
	private String statusPesanan;

	public void setNamaTeknisi(String namaTeknisi){
		this.namaTeknisi = namaTeknisi;
	}

	public String getNamaTeknisi(){
		return namaTeknisi;
	}

	public void setTanggalPesanan(String tanggalPesanan){
		this.tanggalPesanan = tanggalPesanan;
	}

	public String getTanggalPesanan(){
		return tanggalPesanan;
	}

	public void setNomerKontak(String nomerKontak){
		this.nomerKontak = nomerKontak;
	}

	public String getNomerKontak(){
		return nomerKontak;
	}

	public void setAlamatPemesan(String alamatPemesan){
		this.alamatPemesan = alamatPemesan;
	}

	public String getAlamatPemesan(){
		return alamatPemesan;
	}

	public void setIdPesan(String idPesan){
		this.idPesan = idPesan;
	}

	public String getIdPesan(){
		return idPesan;
	}

	public void setJenisPesanan(String jenisPesanan){
		this.jenisPesanan = jenisPesanan;
	}

	public String getJenisPesanan(){
		return jenisPesanan;
	}

	public void setNamaPemesan(String namaPemesan){
		this.namaPemesan = namaPemesan;
	}

	public String getNamaPemesan(){
		return namaPemesan;
	}

	public void setNomerKontakPemesan(String nomerKontakPemesan){
		this.nomerKontakPemesan = nomerKontakPemesan;
	}

	public String getNomerKontakPemesan(){
		return nomerKontakPemesan;
	}

	public void setKotaAdministrasi(String kotaAdministrasi){
		this.kotaAdministrasi = kotaAdministrasi;
	}

	public String getKotaAdministrasi(){
		return kotaAdministrasi;
	}

	public void setStatusPesanan(String statusPesanan){
		this.statusPesanan = statusPesanan;
	}

	public String getStatusPesanan(){
		return statusPesanan;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"nama_teknisi = '" + namaTeknisi + '\'' + 
			",tanggal_pesanan = '" + tanggalPesanan + '\'' + 
			",nomer_kontak = '" + nomerKontak + '\'' + 
			",alamat_pemesan = '" + alamatPemesan + '\'' + 
			",id_pesan = '" + idPesan + '\'' + 
			",jenis_pesanan = '" + jenisPesanan + '\'' + 
			",nama_pemesan = '" + namaPemesan + '\'' + 
			",nomer_kontak_pemesan = '" + nomerKontakPemesan + '\'' + 
			",kota_administrasi = '" + kotaAdministrasi + '\'' + 
			",status_pesanan = '" + statusPesanan + '\'' + 
			"}";
		}
}
