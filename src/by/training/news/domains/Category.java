package by.training.news.domains;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category") 
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
	@XmlAttribute(required = true)
	private String catName;
	
	@XmlElement(name = "subcategory")
	private List<SubCategory> subCategori;

	public Category() {
		
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
	
	public SubCategory getSubcategoryByName(String subcategoryN) { 
		 		for(SubCategory subcategory:subCategori){ 
		 			if(subcategoryN.equals(subcategory.getSubName())){ 
		 				return subcategory; 
					} 
		 		} 
		 		return new SubCategory(subcategoryN); 
		 	} 

	
}
