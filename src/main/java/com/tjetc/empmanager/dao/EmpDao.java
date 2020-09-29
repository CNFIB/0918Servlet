package com.tjetc.empmanager.dao;

import com.tjetc.empmanager.domain.Emp;

import java.util.List;

public interface EmpDao {
    int insert(Emp emp);
    List<Emp> selectAll();
    Emp selectByIdAndName(int empno,String ename);
    List<Emp> selectManager();
}
