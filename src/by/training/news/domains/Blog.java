package by.training.news.domains;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( namespace = "http://www.traning.by/news", name = "blog")
public class Blog {
	private List<Category> categories;

	public Blog(){
		
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	@XmlElement(name = "category")
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category) { 
		 		if(!categories.contains(category)){ 
		 			categories.add(category);	 
		 		} 
		 	} 
	
	public Category getCategoryByName(String categoryN) { 
				for(Category category:categories){ 
					if(categoryN.equals(category.getCatName())){ 
		 				return category; 
		 			} 
		 		} 
		 		return new Category(categoryN); 
		 	} 

		 
		 


}
