package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Course;
import Util.JDBCUtils;

public class CourseDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    //��ӿγ̲���
    public boolean insert(Course course) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into course (courseId, courseTime, credit, courseName) "
                    + "values('"
                    + course.getCourseId()
                    + "','"
                    + course.getCourseTime()
                    + "',"
                    + course.getCredit()
                    + ",'"
                    + course.getCourseName()
                    + "')";
            System.out.println("���SQL���Ϊ��" + sql);
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    //��ѯ���е�course����
    public ArrayList<Course> findAll() {
        ArrayList<Course> list = new ArrayList<Course>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from course";
            System.out.println("��ѯ���е�SQL��䣺" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getString("courseId"));
                course.setCourseName(rs.getString("courseName"));
                course.setCredit(rs.getInt("credit"));
                course.setCourseTime(rs.getString("CourseTime"));
                list.add(course);
            }
            return list;
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //����ID��ѯ
    public Course find(String courseId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from course where courseId = '" + courseId + "'";
            rs = stmt.executeQuery(sql);
            System.out.println("������ѯSQL��䣺" + sql);
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getString("CourseId"));
                course.setCourseName(rs.getString("CourseName"));
                course.setCredit(rs.getInt("Credit"));
                course.setCourseTime(rs.getString("CourseTime"));
                return course;
            }
            return null;
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //ɾ���༶
    public boolean delete(String courseId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from course where courseId= '" + courseId + "'";
            System.out.println("ɾ����SQL����ǣ�" + sql);
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }

    //�޸İ༶
    public boolean update(Course course) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update course set courseTime='" + course.getCourseTime()
                    + "',credit=" + course.getCredit()
                    + ",courseName='" + course.getCourseName()
                    + "' where courseId='" + course.getCourseId() + "'";
            System.out.println("�޸ĵ�SQL����ǣ�" + sql);
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
            return false;
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }
}
