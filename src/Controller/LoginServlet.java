package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdministratorDao;
import Dao.StudentDao;
import Dao.UserDao;
import Model.Administrator;
import Model.Student;
import Model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");
        String autoLogin = request.getParameter("autologin");
        String checkCode = request.getParameter("check_code");
        String savedCode = (String) request.getSession().getAttribute("check_code");

        System.out.println(username + " " + password + " " + checkCode + " "
                + savedCode + " " + identity);
        if (username != null && password != null) {
            System.out.println("�˺����벻Ϊ��");
            //�˺����벻Ϊ��
            if (checkCode.equals(savedCode)) {
                //��֤����ȷ
                System.out.println("��֤����ȷ");
                if (identity != null) {
                    if (identity.equals("admin")) {        //��ʦ
                        try {
                            System.out.println("�����ʦ");
                            AdministratorDao adminDao = new AdministratorDao();
                            Administrator admin = adminDao.find(username);
                            if (admin != null) {
                                if (admin.getTcPassword().equals(password)) {
                                    System.out.println("ok");
                                    function1(username, password, autoLogin, 1, request, response);
                                }
                            } else {
                                request.setAttribute("errerMsg", "û�иý�ʦ");
                                request.getRequestDispatcher("/Jsp/Login.jsp").forward(request, response);
                            }
                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
                    } else if (identity.equals("student")) {            //ѧ��
                        try {
                            System.out.println("����ѧ��");
                            StudentDao stuDao = new StudentDao();
                            Student student = stuDao.find(username);
                            if (student != null) {
                                if (student.getStuPassword().equals(password)) {
                                    System.out.println("ok");
                                    function1(username, password, autoLogin, 2, request, response);
                                }
                            } else {
                                request.setAttribute("errerMsg", "û�и�ѧ��");
                                request.getRequestDispatcher("/Jsp/Login.jsp").forward(request, response);
                            }
                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
                    }
                } else {
                    request.setAttribute("errerMsg", "���Ϊ��");
                    request.getRequestDispatcher("/Jsp/Login.jsp").forward(request, response);
                }
            } else {
                //��֤����ȷ
                request.setAttribute("errerMsg", "��֤�����");
                request.getRequestDispatcher("/Jsp/Login.jsp").forward(request, response);
            }
        } else {
            //�˺Ż�����Ϊ��
            request.setAttribute("errerMsg", "�û��������벻��Ϊ��");
            request.getRequestDispatcher("/Jsp/Login.jsp").forward(request, response);
        }
    }

    private void function1(String username, String password, String autoLogin, int num,
                           HttpServletRequest request, HttpServletResponse response) throws IOException {
        //���û�״̬user�������session��
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (num == 1) {
            user.setIdentity("admin");

        } else if (num == 2) {
            user.setIdentity("student");
        }
        request.getSession().setAttribute("user", user);
        //��½��¼
        UserDao userDao = new UserDao();
        userDao.insert(user);
        //�����Զ���½��cookie
        if (autoLogin != null) {
            //ע��cookie�е�����Ҫ����
            if (num == 1) {
                Cookie cookie = new Cookie("autologin", username + "-" + password + "-" + "1");
                cookie.setMaxAge(Integer.parseInt(autoLogin));
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            } else if (num == 2) {
                Cookie cookie = new Cookie("autologin", username + "-" + password + "-" + "2");
                cookie.setMaxAge(Integer.parseInt(autoLogin));
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }

        }
        if (num == 1) {            //��ʦ
            //��ת����ҳ
            response.sendRedirect(request.getContextPath() + "/Jsp/Admin.jsp");
        } else if (num == 2) {    //ѧ��
            //��ת����ҳ
            response.sendRedirect(request.getContextPath() + "/Jsp/Student.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
