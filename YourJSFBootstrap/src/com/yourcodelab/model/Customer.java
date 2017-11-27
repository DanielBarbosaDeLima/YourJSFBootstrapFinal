package com.yourcodelab.model;

public class Customer {
	private Integer id;
	private String name;
	private String email;
	private Integer fumante=0;
	private Boolean video_game;
	private Boolean series;
	private Boolean futebol;
	private Category category;
	
	public Customer(){
		
	}
	public Customer(Integer id, String name, String email, Integer fumante, Boolean video_game, Boolean series,
			Boolean futebol, Category category) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.fumante = fumante;
		this.video_game = video_game;
		this.series = series;
		this.futebol = futebol;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getFumante() {
		return fumante;
	}

	public void setFumante(Integer fumante) {
		this.fumante = fumante;
	}
	public Boolean getVideo_game() {
		return video_game;
	}
	public void setVideo_game(Boolean video_game) {
		this.video_game = video_game;
	}
	public Boolean getSeries() {
		return series;
	}
	public void setSeries(Boolean series) {
		this.series = series;
	}
	public Boolean getFutebol() {
		return futebol;
	}
	public void setFutebol(Boolean futebol) {
		this.futebol = futebol;
	}
}
