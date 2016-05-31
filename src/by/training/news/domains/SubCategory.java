package by.training.news.domains;

import java.util.List;

public class SubCategory {
	private String subName;
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
