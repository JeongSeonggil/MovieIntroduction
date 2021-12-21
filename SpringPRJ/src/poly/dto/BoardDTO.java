package poly.dto;

/**
 * @author 이협건
 * @version 1.1 공지사항 DTO
 */
public class BoardDTO {

	private String NOTICE_SEQ; // 기본키, 순번
	private String TITLE; // 제목
	private String CONTENTS; // 글 내용
	private String USER_NIC; // 작성자
	private String READ_CNT; // 조회수
	private String REG_DT; // 등록일

	public String getNOTICE_SEQ() {
		return NOTICE_SEQ;
	}

	public void setNOTICE_SEQ(String NOTICE_SEQ) {
		this.NOTICE_SEQ = NOTICE_SEQ;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}

	public String getCONTENTS() {
		return CONTENTS;
	}

	public void setCONTENTS(String CONTENTS) {
		this.CONTENTS = CONTENTS;
	}

	public String getUSER_NIC() {
		return USER_NIC;
	}

	public void setUSER_NIC(String USER_NIC) {
		this.USER_NIC = USER_NIC;
	}

	public String getREAD_CNT() {
		return READ_CNT;
	}

	public void setREAD_CNT(String READ_CNT) {
		this.READ_CNT = READ_CNT;
	}

	public String getREG_DT() {
		return REG_DT;
	}

	public void setREG_DT(String REG_DT) {
		this.REG_DT = REG_DT;
	}
}
