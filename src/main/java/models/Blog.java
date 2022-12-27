package models;

public class Blog {
	private int id;
	private String title;
	private String image;
	private int year;
	private int collectionId;

	public Blog() {}
	
	public Blog(int id, String title, String image, int year, int collectionId) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.year = year;
		this.collectionId = collectionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
