package api.soccer.management.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "tiso")
public class TiSo implements Serializable {
	@Id
	@Column(name = "tiso_id")
	int tiso_id;
	@Column(name = "tiso_1")
	int tiSo1;
	@Column(name = "tiso_2")
	int tiSo2;
	@Column(name = "ratio")
	double ratio;
	@Column(name = "price")
	int price;
	
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "trandau_id")
	DanhSachTranCaCuoc ds_cacuoc;

	public TiSo() {
	}

	public int getTiso_id() {
		return tiso_id;
	}

	public void setTiso_id(int tiso_id) {
		this.tiso_id = tiso_id;
	}

	public int getTiSo1() {
		return tiSo1;
	}

	public void setTiSo1(int tiSo1) {
		this.tiSo1 = tiSo1;
	}

	public int getTiSo2() {
		return tiSo2;
	}

	public void setTiSo2(int tiSo2) {
		this.tiSo2 = tiSo2;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@JsonIgnore
	public DanhSachTranCaCuoc getDs_cacuoc() {
		return ds_cacuoc;
	}

	public void setDs_cacuoc(DanhSachTranCaCuoc ds_cacuoc) {
		this.ds_cacuoc = ds_cacuoc;
	}

	



}
