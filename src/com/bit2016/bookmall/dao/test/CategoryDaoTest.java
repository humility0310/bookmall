package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.CategoryDao;
import com.bit2016.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// insert 테스트
		insertTest();

		// deleteTest
		// deleteTest();

		// updateTest
		// updateTest();

		// getList test
		// getListTest();
	}

	public static void insertTest() {
		CategoryDao dao = new CategoryDao();

		CategoryVo vo1 = new CategoryVo();
		vo1.setName("컴퓨터1");
		dao.insert(vo1);

		CategoryVo vo2 = new CategoryVo();
		vo2.setName("컴퓨터2");
		dao.insert(vo2);

		CategoryVo vo3 = new CategoryVo();
		vo3.setName("컴퓨터3");
		dao.insert(vo3);

		CategoryVo vo4 = new CategoryVo();
		vo4.setName("컴퓨터4");
		dao.insert(vo4);
	}

	public static void deleteTest() {
		CategoryDao dao = new CategoryDao();

		CategoryVo vo1 = new CategoryVo();
		vo1.setNo(1l);
		dao.delete(vo1);
	}

	public static void updateTest() {
		CategoryVo vo = new CategoryVo();
		vo.setNo(2l);
		vo.setName("김영조");

		new CategoryDao().update(vo);

	}

	public static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		System.out.println("=================================================");
		for (CategoryVo vo : list) {
			// System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}
}
