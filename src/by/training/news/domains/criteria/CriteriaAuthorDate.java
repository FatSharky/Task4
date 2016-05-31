package by.training.news.domains.criteria;

public class CriteriaAuthorDate implements ICriteria {
	private String author;
	private String date;

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.AUTHOR_DATE;
	}

	@Override
	public String[] getParams() {
		String[] s = { this.author, this.date };
		return s;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
