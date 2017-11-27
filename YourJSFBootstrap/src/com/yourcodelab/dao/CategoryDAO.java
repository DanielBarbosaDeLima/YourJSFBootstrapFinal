package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Category;

public class CategoryDAO extends GenericDAO{
	private PreparedStatement ps;
	private String lista = "SELECT * FROM CATEGORY";
	
	public List<Category> listar() throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(lista);
		List<Category> categories = new ArrayList<Category>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			categories.add(new Category(rs.getInt("id"),rs.getString("descricao")));
		}
		closeConnection();
		
		return categories;
	}
}
