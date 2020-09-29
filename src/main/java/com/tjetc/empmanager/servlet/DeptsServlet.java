package com.tjetc.empmanager.servlet;

import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.service.DeptService;
import com.tjetc.empmanager.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeptsServlet extends HttpServlet {
    private DeptService service;
    public DeptsServlet() {
        this.service = new DeptServiceImpl();
    }
    public DeptsServlet(DeptService service) {
        this.service = new DeptServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        System.out.println(encoding);
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        String op = req.getParameter("op");
        if ("addDept".equals(op)){
            this.addDept(req,resp);
        }else if ("findAll".equals(op)){
            this.findAll(req,resp);
        }else if ("remove".equals(op)){

        }

    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> all = this.service.findAll();
        req.setAttribute("all",all);
        req.getRequestDispatcher("showAllDept.jsp").forward(req,resp);
    }

    private void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        String dname = req.getParameter("dname");
        String loc =  req.getParameter("loc");
        String info = service.addDept(deptno,dname,loc);
        req.setAttribute("info",info);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }
}
