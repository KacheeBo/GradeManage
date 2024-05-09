package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Administrator;
import Util.JDBCUtils;

public class AdministratorDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    //��ӹ���Ա����
    public boolean insert(Administrator admin) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into administrator (tcId, tcName, tcClassId, tcSex, tcPassword) "
                    + "values('"
                    + admin.getTcId()
                    + "','"
                    + admin.getTcName()
                    + "','"
                    + admin.getTcClassId()
                    + "','"
                    + admin.getTcSex()
                    + "','"
                    + admin.getTcPassword()
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

    //��ѯ���е�Administrator����
    public ArrayList<Administrator> findAll() {
        ArrayList<Administrator> list = new ArrayList<Administrator>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from administrator";
            System.out.println("��ѯ���е�SQL��䣺" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Administrator admin = new Administrator();
                admin.setTcId(rs.getString("tcId"));
                admin.setTcName(rs.getString("tcName"));
                admin.setTcSex(rs.getString("tcSex"));
                admin.setTcClassId(rs.getString("tcClassId"));
                admin.setTcPassword(rs.getString("tcPassword"));
                list.add(admin);
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
    public Administrator find(String tcId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from administrator where tcId = '" + tcId + "'";
            System.out.println("������ѯSQL��䣺" + sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Administrator admin = new Administrator();
                admin.setTcId(rs.getString("TcId"));
                admin.setTcName(rs.getString("TcName"));
                admin.setTcSex(rs.getString("TcSex"));
                admin.setTcClassId(rs.getString("TcClassId"));
                admin.setTcPassword(rs.getString("TcPassword"));
                return admin;
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
    public boolean delete(String tcId) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from administrator where tcId= '" + tcId + "'";
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
    public boolean update(Administrator admin) {
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "update administrator set tcName='" + admin.getTcName()
                    + "',tcClassId='" + admin.getTcClassId()
                    + "',tcSex='" + admin.getTcSex()
                    + "',tcPassword='" + admin.getTcPassword()
                    + "' where tcId='" + admin.getTcId() + "'";
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
