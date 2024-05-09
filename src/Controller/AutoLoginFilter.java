package Controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import Dao.AdministratorDao;
import Dao.StudentDao;
import Model.Administrator;
import Model.Student;
import Model.User;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        //��ȡһ����Ϊautologin��cookie
        Cookie[] cookies = request.getCookies();
        String autologin = null;
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("autologin".equals(cookies[i].getName())) {
                //�ҵ���ָ����cookie
                autologin = cookies[i].getValue();
                break;
            }
        }
        if (autologin != null) {
            //���Զ���½
            System.out.println("�����������");
            String[] parts = autologin.split("-");
            String username = parts[0];
            String password = parts[1];
            String num = parts[2];
            User user = new User();
            int flag = 0;
            if (num == "1") {
                AdministratorDao adminDao = new AdministratorDao();
                Administrator admin = adminDao.find(username);
                if (admin != null) {
                    if (admin.getTcPassword().equals(password)) {
                        flag = 1;
                        user.setIdentity("admin");
                    }
                }
            } else {
                StudentDao stuDao = new StudentDao();
                Student stu = stuDao.find(username);
                if (stu != null) {
                    if (stu.getStuPassword().equals(password)) {
                        flag = 1;
                        user.setIdentity("student");
                    }
                }
            }
            //����û���������
            if (flag == 1) {
                //��½�ɹ������û�״̬user�������session��
                user.setUsername(username);
                user.setPassword(password);
                request.getSession().setAttribute("user", user);
            }
        }
        //����
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
