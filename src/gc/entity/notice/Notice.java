package gc.entity.notice;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private Date regDate;
	private String adminNicname;
	private String files;
	

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public Notice(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public Notice(int id, String title, String content, Date regDate, String adminNicname, String files) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.adminNicname = adminNicname;
		this.files = files;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", adminNicname=" + adminNicname + ", files=" + files + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getAdminNicname() {
		return adminNicname;
	}

	public void setAdminNicname(String adminNicname) {
		this.adminNicname = adminNicname;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	
	
	
}
