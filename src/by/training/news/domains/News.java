package by.training.news.domains;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "news")
@XmlAccessorType(XmlAccessType.FIELD)
public class News {
	@XmlElement(required = true)
	private String newsName;
	@XmlElement(name = "author")
	private String authors;
	@XmlElement(required = true, name = "dateOfIssue")
	private String dateOfIssue;
	@XmlElement(required = true)
	private String newsBody;

	public News() {

	}

	public String getNewsName() {
		return newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}

}
