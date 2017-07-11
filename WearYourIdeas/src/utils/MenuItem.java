package utils;

public class MenuItem {

	String name, url;

	public MenuItem(String namec, String urlc) {
		if (namec != null && urlc != null) {
			name = namec;
			url = urlc;
		} else
			throw new IllegalArgumentException();
	}

	public String getDescription() {
		return name;
	}

	public String getUrl() {
		return url;
	}

}
