package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Student;
import Util.JDBCUtils;

public class StudentDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    //���ѧ������
    public boolean insert(Student student) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into student (stuId, stuName, stuSex, stuClassId, stuPassword) "
                    + "values('"
                    + student.getStuId()
                    + "','"
                    + student.getStuName()
                    + "','"
                    + student.getStuSex()
                    + "','"
                    + student.getStuClassId()
                    + "','"
                    + student.getStuPassword()
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

    //��ѯ���е�student����
    public ArrayList<Student> findAll() {
        ArrayList<Student> list = new ArrayList<Student>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from student";
            System.out.println("��ѯ���е�SQL��䣺" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setStuId(rs.getString("stuId"));
                student.setStuName(rs.getString("stuName"));
                student.setStuSex(rs.getString("stuSex"));
                student.setStuClassId(rs.getString("stuClassId"));
                student.setStuPassword(rs.getString("stuPassword"));
                list.add(student);
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
    public Student find(String stuId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from student where stuId = '" + stuId + "'";
            rs = stmt.executeQuery(sql);
            System.out.println("������ѯSQL��䣺" + sql);
            while (rs.next()) {
                Student student = new Student();
                student.setStuId(rs.getString("stuId"));
                student.setStuName(rs.getString("stuName"));
                student.setStuSex(rs.getString("stuSex"));
                student.setStuClassId(rs.getString("stuClassId"));
                student.setStuPassword(rs.getString("stuPassword"));
                return student;
            }
            return null;
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }

    //ɾ��ѧ��
    public boolean delete(String stuId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from student where stuId='" + stuId + "'";
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

    //�޸��û�
    public boolean update(Student student) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update student set stuName='" + student.getStuName()
                    + "',stuSex='" + student.getStuSex()
                    + "',stuClassId='" + student.getStuClassId()
                    + "',stuPassword='" + student.getStuPassword()
                    + "' where stuId='" + student.getStuId() + "'";
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
