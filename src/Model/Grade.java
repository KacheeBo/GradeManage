package Model;

public class Grade {
    private String stuId;            //ѧ�����
    private String stuName;            //ѧ������
    private String courseId;        //�γ̱��
    private String tcId;            //��ʦ
    private String courseGrade;        //�γ̷���
    private String classId;            //�༶���

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStuId() {
        return stuId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTcId() {
        return tcId;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public String getClassId() {
        return classId;
    }
}
