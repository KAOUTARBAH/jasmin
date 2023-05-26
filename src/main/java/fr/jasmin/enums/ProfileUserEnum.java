package fr.jasmin.enums;

public enum ProfileUserEnum {

	CLIENT ("Client"),
	MAGASINIER ("Magasinier"),
	ADMIN ("Admin");
	
	
	private String profilUser;

	private ProfileUserEnum(String profilUser) {
		this.profilUser = profilUser;
	}

	public String getValue() {
		return profilUser;
	}
}
