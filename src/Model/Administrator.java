package Model;

public class Administrator {
    private String tcId;        //��ʦ���
    private String tcName;        //��ʦ����
    private String tcClassId;    //�༶���
    private String tcSex;        //��ʦ�Ա�
    private String tcPassword;    //��ʦ����

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public void setTcClassId(String tcClassId) {
        this.tcClassId = tcClassId;
    }

    public void setTcSex(String tcSex) {
        this.tcSex = tcSex;
    }

    public void setTcPassword(String tcPassWord) {
        this.tcPassword = tcPassWord;
    }

    public String getTcId() {
        return tcId;
    }

    public String getTcName() {
        return tcName;
    }

    public String getTcClassId() {
        return tcClassId;
    }

    public String getTcSex() {
        return tcSex;
    }

    public String getTcPassword() {
        return tcPassword;
    }
}
