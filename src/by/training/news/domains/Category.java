package by.training.news.domains;

import java.util.List;

public class Category {
	private String catName;
	private List<SubCategory> subCategori;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String catName) {
		this.catName = catName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public List<SubCategory> getSubCategori() {
		return subCategori;
	}

	public void setSubCategori(List<SubCategory> subCategori) {
		this.subCategori = subCategori;
	}

	public void addSubcategory(SubCategory subCategori) {
		if (!this.subCategori.contains(subCategori)) {
			this.subCategori.add(subCategori);
		}
	}
	
	
}
