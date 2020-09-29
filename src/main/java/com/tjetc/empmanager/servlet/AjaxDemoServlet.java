package com.tjetc.empmanager.servlet;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

public class AjaxDemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String info = req.getParameter("info");
        System.out.println("接受的info"+info);
        System.out.println("name:"+name+",password:"+password);
        PrintWriter out = resp.getWriter();
        out.write("恭喜你使用了post请求");
        out.flush();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("使用的GET请求");
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        String info = req.getParameter("info");
        System.out.println("接受info"+info);
        PrintWriter out = resp.getWriter();
        out.write("2333");
        out.flush();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        super.service(req,resp);
    }

}
