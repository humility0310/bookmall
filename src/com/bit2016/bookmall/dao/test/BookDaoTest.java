package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.BookDao;
import com.bit2016.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		// insert 테스트
		insertTest();

		// deleteTest
		// deleteTest();

		// updateTest
		updateTest();

		// getList test
		// getListTest();

	}

	public static void insertTest() {
		BookDao dao = new BookDao();

		BookVo vo1 = new BookVo();
		vo1.setTitle("컴퓨터1");
		vo1.setPrice(10000l);
		vo1.setCategory_no(3l);
		dao.insert(vo1);

		BookVo vo2 = new BookVo();
		vo2.setTitle("컴퓨터2");
		vo2.setPrice(12000l);
		vo2.setCategory_no(3l);
		dao.insert(vo2);

		BookVo vo3 = new BookVo();
		vo3.setTitle("컴퓨터3");
		vo3.setPrice(13000l);
		vo3.setCategory_no(3l);
		dao.insert(vo3);

		BookVo vo4 = new BookVo();
		vo4.setTitle("컴퓨터4");
		vo4.setPrice(14000l);
		vo4.setCategory_no(3l);
		dao.insert(vo4);
	}

	public static void deleteTest() {
		BookDao dao = new BookDao();

		BookVo vo1 = new BookVo();
		vo1.setNo(1l);
		dao.delete(vo1);
	}

	public static void updateTest() {
		BookVo vo = new BookVo();
		vo.setNo(2l);
		vo.setTitle("김영조");

		new BookDao().update(vo);

	}

	public static void getListTest() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		System.out.println("=================================================");
		for (BookVo vo : list) {
			// System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}
}
