package api.soccer.management.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "nguoichoi")
public class NguoiChoi implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "balance")
	int tongThu;
	@Column(name = "role")
	String role;
	
	@OneToMany(mappedBy = "nguoichoi")
	List<DanhSachTranCaCuoc> list_dscc;
	
	


	public List<DanhSachTranCaCuoc> getList_dscc() {
		return list_dscc;
	}

	public void setList_dscc(List<DanhSachTranCaCuoc> list_dscc) {
		this.list_dscc = list_dscc;
	}

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTongThu() {
		return tongThu;
	}

	public void setTongThu(int tongThu) {
		this.tongThu = tongThu;
	}


	public void setRole(String role) {
		this.role = role;
	}




	

}
