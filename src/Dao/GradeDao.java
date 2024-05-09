package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Grade;
import Util.JDBCUtils;

public class GradeDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    //��ӳɼ�����
    public boolean insert(Grade grade) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into grade (stuId, stuName, courseId, tcId, courseGrade, classId) "
                    + "values('"
                    + grade.getStuId()
                    + "','"
                    + grade.getStuName()
                    + "','"
                    + grade.getCourseId()
                    + "','"
                    + grade.getTcId()
                    + "','"
                    + grade.getCourseGrade()
                    + "','"
                    + grade.getClassId()
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

    //��ѯ���е�grade����
    public ArrayList<Grade> findAll() {
        ArrayList<Grade> list = new ArrayList<Grade>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from grade";
            System.out.println("��ѯ���е�SQL��䣺" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setCourseId(rs.getString("courseId"));
                grade.setStuName(rs.getString("stuName"));
                grade.setCourseGrade(rs.getString("courseGrade"));
                grade.setStuId(rs.getString("stuId"));
                grade.setTcId(rs.getString("tcId"));
                grade.setClassId(rs.getString("classId"));
                list.add(grade);
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
    public ArrayList<Grade> find(String stuId) {
        ArrayList<Grade> list = new ArrayList<Grade>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from grade where stuId = '" + stuId + "'";
            rs = stmt.executeQuery(sql);
            System.out.println("������ѯSQL��䣺" + sql);
            while (rs.next()) {
                Grade grade = new Grade();
                grade.setCourseId(rs.getString("courseId"));
                grade.setStuName(rs.getString("stuName"));
                grade.setCourseGrade(rs.getString("courseGrade"));
                grade.setStuId(rs.getString("stuId"));
                grade.setTcId(rs.getString("tcId"));
                grade.setClassId(rs.getString("classId"));
                list.add(grade);
            }
            return list;
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //ɾ���ɼ�
    public boolean delete(Grade grade) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from grade where stuId= '" + grade.getStuId()
                    + "' and stuName = '" + grade.getStuName()
                    + "' and courseId = '" + grade.getCourseId()
                    + "' and tcId = '" + grade.getTcId()
                    + "' and courseGrade = '" + grade.getCourseGrade()
                    + "' and classId = '" + grade.getClassId()
                    + "'";
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

    //�޸ĳɼ�
    public boolean update(Grade grade) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update grade set "
                    + "courseGrade='" + grade.getCourseGrade()
                    + "' where stuId='" + grade.getStuId()
                    + "' and stuName= '" + grade.getStuName()
                    + "' and courseId='" + grade.getCourseId()
                    + "' and tcId='" + grade.getTcId()
                    + "' and classId='" + grade.getClassId()
                    + "'";
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
