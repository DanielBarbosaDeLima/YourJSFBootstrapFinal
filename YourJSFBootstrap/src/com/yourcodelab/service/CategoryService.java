package com.yourcodelab.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.dao.CategoryDAO;
import com.yourcodelab.model.Category;

public class CategoryService {
	CategoryDAO dao = new CategoryDAO();
	public List<Category> listAll(){
		List<Category> list = new ArrayList<Category>();
		try {
			list = dao.listar();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
