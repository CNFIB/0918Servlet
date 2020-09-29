package com.tjetc.empmanager.dao.impl;

import com.tjetc.empmanager.dao.GoodsDao;
import com.tjetc.empmanager.domain.Goods;
import com.tjetc.empmanager.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao  {
    @Override
    public int insert(Goods g) {
        Connection connection = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(connection,"insert into goods(name,image,price)values(?,?,?)",
                g.getName(),g.getImage(),g.getPrice());
        int i = DButil.update(pstmt);
        DButil.close(connection,pstmt,null);
        return i;
    }

    @Override
    public List<Goods> selectAll() {
        Connection connection = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(connection,"select * from goods");
        ResultSet rs = DButil.query(pstmt);
        List<Goods>list=  new ArrayList<>();
        try {
            while (rs.next()){
                list.add(new Goods(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price")));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
