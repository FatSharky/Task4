package by.training.news.domains;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subcategory")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubCategory {
	@XmlAttribute(required = true)
	private String subName;
	@XmlElement(name = "news")
	private List<News> news;

	public SubCategory() {
	}

	public SubCategory(String subName) {
		this.subName = subName;

	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public void addNews(News news) {
		if (!this.news.contains(news)) {
			this.news.add(news);
		}

	}
}
