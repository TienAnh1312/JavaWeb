package buitienanh.beans;

public class publisher {
	private int PublisherId;
	private String PublisherName;
	private String Phone;
	private String Address;
	
	public publisher() {
    	
    }

	public publisher(int publisherId, String publisherName, String phone, String address) {
		super();
		PublisherId = publisherId;
		PublisherName = publisherName;
		Phone = phone;
		Address = address;
	}

	public int getPublisherId() {
		return PublisherId;
	}

	public void setPublisherId(int publisherId) {
		PublisherId = publisherId;
	}

	public String getPublisherName() {
		return PublisherName;
	}

	public void setPublisherName(String publisherName) {
		PublisherName = publisherName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	
}
