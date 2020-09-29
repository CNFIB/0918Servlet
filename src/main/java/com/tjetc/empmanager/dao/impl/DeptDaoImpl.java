package com.tjetc.empmanager.dao.impl;

import com.tjetc.empmanager.dao.DeptDao;
import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public int insert(Dept dept) {
        //调用Dbutil获取连接对象
        Connection conn = DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DButil.getPstmt(conn, "insert into dept(deptno,dname,loc) values(?,?,?)",
                dept.getDeptno(), dept.getDname(), dept.getLoc());
        //执行插入操作
        int i = DButil.update(pstmt);
        //关闭资源
        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int delete(int id) {
        //调用Dbutil获取连接对象
        Connection conn = DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DButil.getPstmt(conn, "delete from dept where deptno = ?",id);
        //执行插入操作
        int i = DButil.update(pstmt);
        //关闭资源
        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int update(Dept dept) {
        //调用Dbutil获取连接对象
        Connection conn = DButil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DButil.getPstmt(conn, "update dept set dname=?,loc=? where deptno=?",dept.getDname(),dept.getLoc(),dept.getDeptno());
        //执行插入操作
        int i = DButil.update(pstmt);
        //关闭资源
        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public List<Dept> selectAll() {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept");
        ResultSet rs =  DButil.query(pstmt);
        List<Dept> list = new ArrayList<Dept>();
        try {
            while (rs.next()){
                list.add(new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")));
            }
            return list;
        }catch (Exception e){
            return list;
        }

    }

    @Override
    public Dept selectById(int id) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept where deptno=?",id);
        ResultSet rs =  DButil.query(pstmt);
        try {
            if(rs.next()){
                return new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc"));
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Dept selectByName(String name) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept where dname=?",name);
        ResultSet rs =  DButil.query(pstmt);
        try {
            if(rs.next()){
                return new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc"));
            }
            return null;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Dept> selectByLikeName(String name) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from dept where dname like ?","%"+name+"%");
        ResultSet rs =  DButil.query(pstmt);
        List<Dept> list = new ArrayList<Dept>();
        try {
            while (rs.next()){
                list.add(new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")));
            }
            return list;
        }catch (Exception e){
            return list;
        }
    }
}
