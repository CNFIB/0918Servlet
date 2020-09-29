package com.tjetc.empmanager.service.impl;

import com.tjetc.empmanager.dao.EmpDao;
import com.tjetc.empmanager.dao.impl.EmpDaoImpl;
import com.tjetc.empmanager.domain.Emp;
import com.tjetc.empmanager.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    public EmpServiceImpl() {
        this.empDao=  new EmpDaoImpl();
    }

    @Override
    public String addEmp(Emp emp) {
        if (this.empDao.selectByIdAndName(emp.getEmpno(),emp.getEname())!=null){
            return "对不起员工已经录入";
        }
        return this.empDao.insert(emp)>0?"录入员工信息成功":"录入失败";
    }

    @Override
    public List<Emp> findAll() {
        return this.empDao.selectAll();
    }

    @Override
    public List<Emp> findAllManager() {
        return this.empDao.selectManager();
    }
}
