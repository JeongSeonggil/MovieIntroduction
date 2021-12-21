package poly.dto;

public class MemberDTO {
    private String EMAIL;
    private String MEMBER_PW;
    private String MEMBER_NIC;
    private String MEMBER_NAME;


   public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getMEMBER_PW() {
        return MEMBER_PW;
    }

    public void setMEMBER_PW(String MEMBER_PW) {
        this.MEMBER_PW = MEMBER_PW;
    }

    public String getMEMBER_NIC() {
        return MEMBER_NIC;
    }

    public void setMEMBER_NIC(String MEMBER_NIC) {
        this.MEMBER_NIC = MEMBER_NIC;
    }

    public String getMEMBER_NAME() {
        return MEMBER_NAME;
    }

    public void setMEMBER_NAME(String MEMBER_NAME) {
        this.MEMBER_NAME = MEMBER_NAME;
    }
}
