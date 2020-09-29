package com.tjetc.empmanager.servlet;

import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.domain.Emp;
import com.tjetc.empmanager.service.DeptService;
import com.tjetc.empmanager.service.EmpService;
import com.tjetc.empmanager.service.impl.DeptServiceImpl;
import com.tjetc.empmanager.service.impl.EmpServiceImpl;
import com.tjetc.empmanager.util.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "empServlet",urlPatterns = "/emp")
public class EmpServlet extends HttpServlet {
    private DeptService deptService;
    private EmpService empService;

    public EmpServlet() {
         this.deptService = new DeptServiceImpl();
         this.empService = new EmpServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        String op = req.getParameter("op");
        if ("addFind".equals(op)){
            this.addFind(req,resp);
        }else if ("addEmp".equals(op)){
            this.addEmp(req,resp);
        }else if ("findAll".equals(op)){
            this.findAll(req,resp);
        }
    }
    private void findAll(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        List<Emp>all = this.empService.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("showAllEmp.jsp").forward(req,resp);
    }
    private void addEmp(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        String empno = req.getParameter("empno");
        String ename = req.getParameter("ename");
        String job =  req.getParameter("job");
        String mgr = req.getParameter("mgr");
        String hiredate = req.getParameter("hiredate");
        String sal = req.getParameter("sal");
        String comm = req.getParameter("comm");
        String deptno = req.getParameter("deptno");
        Dept d = new Dept();
        d.setDeptno(Integer.valueOf(deptno));
        String info = this.empService.addEmp(new Emp(
                Integer.valueOf(empno),
                ename,
                job,
                Integer.valueOf(mgr),
                DateFormat.stringToDate(hiredate),
                Double.valueOf(sal),
                Double.valueOf(comm),
                d
        ));
        req.setAttribute("info",info);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }
    private void addFind(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        List<Dept> deptAll = this.deptService.findAll();
        List<Emp> managerAll = this.empService.findAllManager();
        req.setAttribute("deptAll",deptAll);
        req.setAttribute("managerAll",managerAll);
        req.getRequestDispatcher("addEmp.jsp").forward(req,resp);
    }
}
