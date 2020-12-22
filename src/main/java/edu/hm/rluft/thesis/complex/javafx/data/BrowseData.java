package edu.hm.rluft.thesis.complex.javafx.data;

public class BrowseData {

	private long kundenNr;
	private String name;
	private ViewData view;

	public BrowseData(long kundenNr, String name, ViewData view) {
		this.kundenNr = kundenNr;
		this.name = name;
		this.view = view;
	}

	public long getKundenNr() {
		return kundenNr;
	}

	public String getName() {
		return name;
	}

	public ViewData getViewData() {
		return view;
	}

}
