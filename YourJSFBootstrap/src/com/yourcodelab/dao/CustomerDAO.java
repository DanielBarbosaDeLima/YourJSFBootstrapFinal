package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Category;
import com.yourcodelab.model.Customer;

public class CustomerDAO extends GenericDAO{
	private PreparedStatement ps;
	private String lista = "SELECT CUSTOMER.*,CATEGORY.DESCRICAO AS CATEGORY FROM CUSTOMER INNER JOIN CATEGORY ON CUSTOMER.ID_CATEGORY=CATEGORY.ID;";
	private String cadastrar = "INSERT INTO customer(nome,email,id_category,fumante,video_game,series,futebol) values(?,?,?,?,?,?,?); ";
	private String atualizar = "update customer set nome = ?, email = ?,id_category = ?,fumante=?,video_game=?,series=?,futebol=? where id= ?; ";
	private String excluir = "delete from customer where id= ?";
	private String procurar = "SELECT CUSTOMER.*,CATEGORY.DESCRICAO AS CATEGORY FROM CUSTOMER INNER JOIN CATEGORY ON CUSTOMER.ID_CATEGORY=CATEGORY.ID WHERE NOME LIKE ?;";
	
	
	public List<Customer> listar() throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(lista);
		List<Customer> customers = new ArrayList<Customer>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Category category = new Category(rs.getInt("id_category"),rs.getString("category"));
			customers.add(new Customer(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getInt("fumante"),rs.getBoolean("video_game"),rs.getBoolean("series"),rs.getBoolean("futebol"),category));
		}
		closeConnection();
		
		return customers;
	}
	public void cadastrar(Customer c) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(cadastrar);
		
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setInt(3, c.getCategory().getId());
		ps.setInt(4, c.getFumante());
		ps.setBoolean(5, c.getVideo_game());
		ps.setBoolean(6, c.getSeries());
		ps.setBoolean(7, c.getFutebol());
		
		ps.execute();
		closeConnection();
	}
	public void alterar(Customer c) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(atualizar);
		
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setInt(3, c.getCategory().getId());
		ps.setInt(4, c.getFumante());
		ps.setBoolean(5, c.getVideo_game());
		ps.setBoolean(6, c.getSeries());
		ps.setBoolean(7, c.getFutebol());
		ps.setInt(8, c.getId());
		
		
		ps.execute();
		closeConnection();
	}
	public void excluir(Customer c) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(excluir);
		ps.setInt(1, c.getId());
		ps.execute();
		closeConnection();
	}
	public List<Customer> procurar(String Nome) throws ClassNotFoundException, IOException, SQLException{
		openConnection();
		ps = connect.prepareStatement(procurar);
		ps.setString(1, Nome +"%");
		List<Customer> customers = new ArrayList<Customer>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Category category = new Category(rs.getInt("id_category"),rs.getString("category"));
			customers.add(new Customer(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getInt("fumante"),rs.getBoolean("video_game"),rs.getBoolean("series"),rs.getBoolean("futebol"),category));
		}
		closeConnection();
		
		return customers;
	}
}
