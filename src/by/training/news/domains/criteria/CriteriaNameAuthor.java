package by.training.news.domains.criteria;

public class CriteriaNameAuthor implements ICriteria{
	private String name;
	private String author;

	@Override
	public CriteriaType getCriteriaType() {
		return CriteriaType.NAME_AUTHOR;
	}

	@Override
	public String[] getParams() {
		String[] s = {this.name,this.author};
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
