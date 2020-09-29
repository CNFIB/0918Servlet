package com.tjetc.empmanager.dao;

import com.tjetc.empmanager.domain.Dept;

import java.util.List;

public interface DeptDao {
    int insert(Dept dept);
    int delete(int id);
    int update(Dept dept);
    List<Dept> selectAll();
    Dept selectById(int id);
    Dept selectByName(String name);
    List<Dept> selectByLikeName(String name);
}
