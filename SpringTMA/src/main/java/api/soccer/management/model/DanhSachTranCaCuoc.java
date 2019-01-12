package api.soccer.management.model;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

import javax.persistence.*;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

@Entity

@Table(name = "ds_trancacuoc")
public class DanhSachTranCaCuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trandau_id")
	int trandau_id;
	@Column(name = "ten_trandau")
	String ten_trandau;
	@OneToMany(mappedBy = "ds_cacuoc", cascade = CascadeType.ALL)
	List<TiSo> list_ts;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id")
NguoiChoi nguoichoi;
	public DanhSachTranCaCuoc() {
	}

	
public DanhSachTranCaCuoc(int trandau_id, String ten_trandau, List<TiSo> list_ts) {
		super();
		this.trandau_id = trandau_id;
		this.ten_trandau = ten_trandau;
		this.list_ts = list_ts;
	}

@JsonIgnore
public NguoiChoi getNguoichoi() {
	return nguoichoi;
}


public void setNguoichoi(NguoiChoi nguoichoi) {
	this.nguoichoi = nguoichoi;
}


	public int getTrandau_id() {
		return trandau_id;
	}

	public void setTrandau_id(int trandau_id) {
		this.trandau_id = trandau_id;
	}

	public String getTen_trandau() {
		return ten_trandau;
	}

	public void setTen_trandau(String ten_trandau) {
		this.ten_trandau = ten_trandau;
	}

	public List<TiSo> getList_ts() {
		return list_ts;
	}

	public void setList_ts(List<TiSo> list_ts) {
		this.list_ts = list_ts;
	}

	
}
