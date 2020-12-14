package gc.entity.admin;

public class Admin {
	private int id;
	private String nicname;
	private String pwd;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	// insert?ö© ?Éù?Ñ±?ûê ?ò§Î≤ÑÎ°ú?ìú
	public Admin(String nicname, String pwd) {
		this.nicname = nicname;
		this.pwd = pwd;
	}

	public Admin(int id, String nicname, String pwd) {
		super();
		this.id = id;
		this.nicname = nicname;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", nicname=" + nicname + ", pwd=" + pwd + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNicname() {
		return nicname;
	}

	public void setNicname(String nicname) {
		this.nicname = nicname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	

	

}
