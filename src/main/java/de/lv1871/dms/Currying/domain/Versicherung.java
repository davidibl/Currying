package de.lv1871.dms.Currying.domain;

public class Versicherung {

	private Integer beitragMonat;

	public Versicherung(int beitragMonat) {
		this.beitragMonat = beitragMonat;
	}

	public Integer getBeitragMonat() {
		return beitragMonat;
	}

	public void setBeitragMonat(Integer beitragMonat) {
		this.beitragMonat = beitragMonat;
	}
}
