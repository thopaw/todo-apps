package name.pawlitzki.boot.todoapp.controller;

public class Crumb {

	private final String url;
	private final String text;

	public Crumb(String url, String text) {
		super();
		this.url = url;
		this.text = text;
	}

	public Crumb(String text) {
		super();
		this.url = null;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String getUrl() {
		return url;
	}

}
