import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author: liubo
 * @version: 2018/10/10 12:26
 * @describe:
 */
public class HelloServlet extends javax.servlet.http.HttpServlet {
    /**
     * 初次加载时调用,只执行一次
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("HelloServlet init...");
    }

    /**
     * 每次请求都执行一次
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("HelloServlet service...");
    }

    /**
     * 项目被移除或服务停止调用
     */
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("HelloServlet destroy...");
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        ServletConfig servletConfig = getServletConfig();
        String servletName = servletConfig.getServletName();

        Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = servletConfig.getInitParameter(key);
            if (value == null) {
                throw new IllegalArgumentException("请配置 "+key);
            }
            System.out.println("key ==  "+key+"   value ==  "+value);
        }

    }
}
