package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Classes;
import Util.JDBCUtils;

public class ClassesDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    //��Ӱ༶����
    public boolean insert(Classes classes) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into classes (classId, stuNum, className) "
                    + "values('"
                    + classes.getClassId()
                    + "',"
                    + classes.getStuNum()
                    + ",'"
                    + classes.getClassName()
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

    //��ѯ���е�classes����
    public ArrayList<Classes> findAll() {
        ArrayList<Classes> list = new ArrayList<Classes>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from classes";
            System.out.println("��ѯ���е�SQL��䣺" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setClassId(rs.getString("classId"));
                classes.setStuNum(rs.getInt("stuNum"));
                classes.setClassName(rs.getString("className"));
                list.add(classes);
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
    public Classes find(String classId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from classes where classId = '" + classId + "'";
            rs = stmt.executeQuery(sql);
            System.out.println("������ѯSQL��䣺" + sql);
            while (rs.next()) {
                Classes classes = new Classes();
                classes.setClassId(rs.getString("classId"));
                classes.setStuNum(rs.getInt("stuNum"));
                classes.setClassName(rs.getString("className"));
                return classes;
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
    public boolean delete(String classId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from classes where classId='" + classId + "'";
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
    public boolean update(Classes classes) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update classes set stuNum=" + classes.getStuNum()
                    + ",className='" + classes.getClassName()
                    + "' where classId='" + classes.getClassId() + "'";
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
