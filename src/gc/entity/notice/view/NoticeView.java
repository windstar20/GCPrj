package gc.entity.notice.view;

import java.util.Date;

import gc.entity.notice.Notice;

public class NoticeView extends Notice{
	
	private String title;
	private Date regDate;
	private String adminNicname;
	private String noticeFiles;
	
	public NoticeView() {
		// TODO Auto-generated constructor stub
	}

	public NoticeView(String title, Date regDate, String adminNicname, String noticeFiles) {
		super();
		this.title = title;
		this.regDate = regDate;
		this.adminNicname = adminNicname;
		this.noticeFiles = noticeFiles;
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

	public String getAdminNicname() {
		return adminNicname;
	}

	public void setAdminNicname(String adminNicname) {
		this.adminNicname = adminNicname;
	}

	public String getNoticeFiles() {
		return noticeFiles;
	}

	public void setNoticeFiles(String noticeFiles) {
		this.noticeFiles = noticeFiles;
	}

	@Override
	public String toString() {
		return "NoticeView [title=" + title + ", regDate=" + regDate + ", adminNicname=" + adminNicname
				+ ", noticeFiles=" + noticeFiles + "]";
	}
}