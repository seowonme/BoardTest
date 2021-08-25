package choi.seowon.board.domain.Entity.enums;

public enum BoardType {
	notice("공지사항"),
	press("보도자료");
	
	private String value;
	BoardType(String value){
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}

}
