package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.bookmall.vo.CategoryVo;

public class CategoryDao {
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
	
	public boolean update(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();

			String sql = "update category set name = ? where no = ? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setLong(2, vo.getNo());

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

	public boolean delete(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();

			String sql = "delete from category where no = ?";
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

	public List<CategoryVo> getList() {
		List<CategoryVo> list = new ArrayList<CategoryVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select no, name from category order by no asc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);

				CategoryVo vo = new CategoryVo();
				vo.setNo(no);
				vo.setName(name);

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

	public boolean insert(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {

			conn = getConnection();

			// 3, statment 준비
			String sql = "insert into category values(category_seq.nextval, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4, 바인딩
			pstmt.setString(1, vo.getName());

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
