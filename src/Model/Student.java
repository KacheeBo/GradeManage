package Model;

public class Student {
    private String stuId;        //ѧ�����
    private String stuName;        //ѧ������
    private String stuSex;        //ѧ���Ա�
    private String stuClassId;    //�༶���
    private String stuPassword;    //ѧ������

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public void setStuClassId(String stuClassId) {
        this.stuClassId = stuClassId;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public String getStuId() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public String getStuClassId() {
        return stuClassId;
    }

    public String getStuPassword() {
        return stuPassword;
    }
}
