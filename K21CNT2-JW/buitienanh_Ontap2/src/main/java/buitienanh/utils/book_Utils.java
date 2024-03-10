package buitienanh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buitienanh.beans.book;



public class book_Utils {

	//Đọc danh sách sản phẩm 
	public static List<book> querybook(Connection conn) throws SQLException{
		String sql = "Select a.BookId, a.Title, a.Author, a.Release, a.Price, a.Picture, a.PublisherId, a.CategoryId form book a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		List<book> list = new ArrayList<book>();
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			
			String BookId = rs.getString("BookId");
			String Title = rs.getString("Title");
			String Author = rs.getString("Author");
			int Release = rs.getInt("Release");
			String Price = rs.getString("Price");
			String Picture = rs.getString("Picture");
			int PublisherId = rs.getInt("PublisherId");
			int CategoryId = rs.getInt("CategoryId");
		
			book books = new book();
			books.setBookId(BookId);
			books.setTitle(Title);
			books.setAuthor(Author);
			books.setRelease(Release);
			books.setPrice(Price);
			books.setPicture(Picture);
			books.setPublisherId(PublisherId);
			books.setCategoryId(CategoryId);
			
			list.add(books);
		}
		return list;
	}

	//Tìm kiếm theo mã sản phẩm (code)
	public static book findbook(Connection conn, String BookId) throws SQLException{
		String sql = "Select a.BookId, a.Title, a.Author, a.Release, a.Price, a.Picture, a.PublisherId, a.CategoryId form book a where a.Code=?";	
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, BookId);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String Title = rs.getString("Title");
			String Author = rs.getString("Author");
			int Release = rs.getInt("Release");
			String Price = rs.getString("Price");
			String Picture = rs.getString("Picture");
			int PublisherId = rs.getInt("PublisherId");
			int CategoryId = rs.getInt("CategoryId");
			book books = new book(BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId);
			return books;
	}
		return null;
  }
	
	//Thêm mới sản phẩm
	public static void insertbook(Connection conn, book books) throws SQLException {
		String sql = "Insert into book (BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId ) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, books.getBookId());
		pstm.setString(2, books.getAuthor());
		pstm.setInt(3, books.getRelease());
		pstm.setString(4, books.getPrice());
		pstm.setString(5, books.getPicture());
		pstm.setInt(6, books.getPublisherId());
		pstm.setInt(7, books.getCategoryId());
		
		pstm.executeUpdate();
	}
	
	//Cập nhập sản phẩm
	public static void updatebook(Connection conn, book books) throws SQLException{
		String sql =  "Update book set BookId =?, Title=?, Author =?, Release =?, Price =?, Picture =? ,PublisherId =?, CategoryId =?   where BookId=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, books.getBookId());
		pstm.setString(2, books.getAuthor());
		pstm.setInt(3, books.getRelease());
		pstm.setString(4, books.getPrice());
		pstm.setString(5, books.getPicture());
		pstm.setInt(6, books.getPublisherId());
		pstm.setInt(7, books.getCategoryId());
		
		pstm.executeUpdate();
	}
	
	//Xóa một sản phẩm
	public static void deletebook (Connection conn ,String BookId) throws SQLException{
		String sql = "Delete Form book where BookId= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, BookId);;
		pstm.executeUpdate();
	}
	
}
