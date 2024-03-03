package buitienanh.edu.vn.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="Product")
public class Product implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "MaSP") private String maSP;
	@Column(name = "TenSanPham") private String tenSanPham;
	@Column(name = "AnhSanPham") private String anhSanPham;
	@Column(name = "SoLuong") private Integer soLuong;
	@Column(name = "DonGia") private Double donGia;
	@Column(name = "Trangthai") private Boolean trangthai;
	
	public Product() {
		
	}

	public Product(String maSP, String tenSanPham, String anhSanPham, Integer soLuong, Double donGia,
			Boolean trangthai) {
		super();
		this.maSP = maSP;
		this.tenSanPham = tenSanPham;
		this.anhSanPham = anhSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.trangthai = trangthai;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getAnhSanPham() {
		return anhSanPham;
	}

	public void setAnhSanPham(String anhSanPham) {
		this.anhSanPham = anhSanPham;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public Boolean getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Boolean trangthai) {
		this.trangthai = trangthai;
	}
	
}
