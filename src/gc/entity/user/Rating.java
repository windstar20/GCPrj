package gc.entity.user;

public class Rating {

	private int id;
	private String content;
	
	public Rating() {
		// TODO Auto-generated constructor stub
	}

	public Rating(int id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", content=" + content + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
