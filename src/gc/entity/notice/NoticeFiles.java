package gc.entity.notice;

public class NoticeFiles {
	private int noticeid;
	private String fileName;

	public NoticeFiles() {
		// TODO Auto-generated constructor stub
	}

	public NoticeFiles(String fileName) {
		this.fileName = fileName;
	}

	public NoticeFiles(int noticeid, String fileName) {
		super();
		this.noticeid = noticeid;
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "NoticeFiles [noticeid=" + noticeid + ", fileName=" + fileName + "]";
	}

	public int getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

}
