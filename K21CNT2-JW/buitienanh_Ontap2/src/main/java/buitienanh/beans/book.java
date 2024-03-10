package buitienanh.beans;

public class book {
	private String BookId;
	private String Title;
	private String Author;
	private int Release;
	private String Price;
	private String Picture;
	private int PublisherId;
	private int CategoryId;
	
	public book() {
    	
    }
	
	public book(String bookId, String title, String author, int release, String price, String picture, int publisherId, int categoryId) {
		super();
		BookId = bookId;
		Title = title;
		Author = author;
		Release = release;
		Price = price;
		Picture = picture;
		PublisherId = publisherId;
		CategoryId = categoryId;
	}

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public int getRelease() {
		return Release;
	}

	public void setRelease(int release) {
		Release = release;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	public int getPublisherId() {
		return PublisherId;
	}

	public void setPublisherId(int publisherId) {
		PublisherId = publisherId;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
	
	
}
