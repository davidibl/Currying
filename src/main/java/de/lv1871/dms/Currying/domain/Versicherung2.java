package de.lv1871.dms.Currying.domain;

public class Versicherung2 {

	private Integer beitragJahr;

	public Versicherung2(int beitragJahr) {
		this.setBeitragJahr(beitragJahr);
	}

	public Integer getBeitragJahr() {
		return beitragJahr;
	}

	public void setBeitragJahr(Integer beitragJahr) {
		this.beitragJahr = beitragJahr;
	}
}
