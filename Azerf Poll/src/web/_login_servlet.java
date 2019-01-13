package web;

import com.sun.xml.internal.bind.v2.TODO;
import entities._user;
import metier._user_dao;
import metier._user_dao_impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "_login_serv",urlPatterns = {"*.login"})
public class _login_servlet extends HttpServlet {

    _user_dao _new_user_dao;
    @Override
    public void init() throws ServletException {
        super.init();
        _new_user_dao = new _user_dao_impl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        _user _check_user = new _user();
        String path = req.getServletPath();
        System.out.println(path);

        if (path.equals("/user.login")){
            String _email = req.getParameter("email");
            System.out.println("here is your email :"+_email);
            String _password = req.getParameter("password");
            _check_user.set_email(_email);
            _check_user.set_password(_password);
            _user _check_user2 = (_user) _new_user_dao._login(_check_user);
            if (_check_user2!=null){
                System.out.println("This is the right person");
                ses.setAttribute("_current_user",_check_user2);
                resp.sendRedirect("userDashboard.jsp");
                //PrintWriter out = resp.getWriter();
                //req.setAttribute("user",_check_user);
                //req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else {
                System.out.println("this is a null one ");
                resp.sendRedirect("index.jsp");
            }
        }else if (path.equals("/user/register.login")){
            // TODO add register infos

            String _first_name = req.getParameter("firstname");
            String _last_name = req.getParameter("lastname");
            String _email = req.getParameter("email");
            String _password = req.getParameter("password");
            String _c_password = req.getParameter("cpassword");

            if (_password.equals(_c_password)){
                _check_user.set_first_name(_first_name);
                _check_user.set_last_name(_last_name);
                _check_user.set_email(_email);
                _check_user.set_password(_password);
                //add the new user
                _new_user_dao._add_user(_check_user);

            }
            _user _check_user2 = (_user) _new_user_dao._login(_check_user);
            if (_check_user2!=null){
                System.out.println("This is the right person");
                ses.setAttribute("_current_user",_check_user2);
                resp.sendRedirect("userDashboard.jsp");
                //PrintWriter out = resp.getWriter();
                //req.setAttribute("user",_check_user);
                //req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else {
                System.out.println("this is a null one ");
                resp.sendRedirect("register.jsp");
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}