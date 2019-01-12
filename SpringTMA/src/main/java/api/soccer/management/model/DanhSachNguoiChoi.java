package api.soccer.management.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "danhsach_nguoichoi")
public class DanhSachNguoiChoi implements Serializable{
	@Id
	@Column(name = "nguoichoi_id")
	private int nguoichoi_id;
	@Column(name = "tiso_id")
	private int tiso_id;
	public int getNguoichoi_id() {
		return nguoichoi_id;
	}
	public void setNguoichoi_id(int nguoichoi_id) {
		this.nguoichoi_id = nguoichoi_id;
	}
	public int getTiso_id() {
		return tiso_id;
	}
	public void setTiso_id(int tiso_id) {
		this.tiso_id = tiso_id;
	}
	
}
