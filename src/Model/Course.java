package Model;

public class Course {
    private String courseId;        //�γ̱��
    private String courseTime;        //��ʱ
    private int credit;        //�γ�ѧ��
    private String courseName;        //�γ���

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public int getCredit() {
        return credit;
    }

    public String getCourseName() {
        return courseName;
    }
}
