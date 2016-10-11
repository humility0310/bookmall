package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.bookmall.vo.BookVo;

public class BookDao {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(url, "bitdb", "bitdb");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		}
		return conn;
	}

	public boolean update(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();

			String sql = "update book set TITLE =?, PRICE=?,  CATEGORY_NO=? WHERE NO=? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategory_no());
			pstmt.setLong(4, vo.getNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
		return result == 1;
	}

	public boolean delete(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();

			String sql = "delete from book where no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
		return result == 1;
	}

	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select no, title, price, category_no from book order by no asc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				Long price = rs.getLong(3);
				Long category_no = rs.getLong(4);

				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategory_no(category_no);

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return list;
	}

	public boolean insert(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {

			conn = getConnection();

			// 3, statment 준비
			String sql = "insert into book values(book_seq.nextval, ?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4, 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategory_no());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3, 자원 정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result == 1;
	}
}
