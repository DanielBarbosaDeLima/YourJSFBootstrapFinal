package com.yourcodelab.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yourcodelab.model.Category;
import com.yourcodelab.model.Customer;
import com.yourcodelab.service.CustomerService;

@ManagedBean(name = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable{
	private static final long serialVersionUID = -9004785433894347006L;
	
	private Customer customer;
	private List<Customer> listCustomer;
	
	private CustomerService service;
	
	public CustomerManagedBean(){
		service = new CustomerService();
		customer = new Customer(0, "", "",0,false,false,false,new Category());
		listCustomer = service.listAll();
	}

	public void searchByNameAction(){
		this.listCustomer = service.searchByName(customer.getName());
	}
	
	public String insertCustomerAction(){
		service.insertCustomer(customer);
		update();
		return "index";
	}
	
	public String updateCustomerAction(){
		service.updateCustomer(customer);
		update();
		return "index";
	}
	public void deleteCustomerAction(){
		service.deleteCustomer(customer);
		update();
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}
	public void update(){
		this.service = new CustomerService();
		this.customer = new Customer();
		this.listCustomer = service.listAll();
	}
}
