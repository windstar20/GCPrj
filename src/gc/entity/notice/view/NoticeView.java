package gc.entity.notice.view;

import java.util.Date;

import gc.entity.notice.Notice;

public class NoticeView extends Notice{
	
	private String title;
	private Date regDate;
	private String nicname;
	
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(String title, Date regDate, String nicname) {
		super();
		this.title = title;
		this.regDate = regDate;
		this.nicname = nicname;
	}

	@Override
	public String toString() {
		return "NoticeView [title=" + title + ", regDate=" + regDate + ", nicname=" + nicname + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getNicname() {
		return nicname;
	}

	public void setNicname(String nicname) {
		this.nicname = nicname;
	}

	
	
	
	
}