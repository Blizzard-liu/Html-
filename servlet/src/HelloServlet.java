import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
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
        request.setCharacterEncoding("UTF-8");

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        /**
         * get请求request 解决乱码:
         * 1.new String(str.getBytes("ISO-8859-1"),"UTF-8")
         *
         * 2. tomcat conf/server.xml 加上 URIEncoding="UTF-8"
         *  <Connector port="8080" protocol="HTTP/1.1"
         *         connectionTimeout="20000"
         *         redirectPort="8443"
         *         URIEncoding="UTF-8" />
         */

        String header = request.getHeader("User-Agent");
        //如果文件名包含中文需要进行编码
       /* String filename = "哈哈";
        if (header.contains("Firefox")) {

            // 火狐浏览器  base64编码
        } else {
            //谷歌,IE浏览器
            filename =  URLEncoder.encode("", "UTF-8");
        }
        //让浏览器以下载的方式提醒用户
        response.setHeader("Content-Disposition","attachment;filename="+filename);*/


        ServletContext servletContext = getServletContext();
        String namespace = servletContext.getInitParameter("namespace");
        //获取绝对路径
        String realPath = servletContext.getRealPath("");
        InputStream inputStream = new FileInputStream(realPath);

//        ServletOutputStream outputStream = response.getOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = inputStream.read(buffer)) != -1) {
//            outputStream.write(buffer,0,len);
//        }
//        inputStream.close();
//        outputStream.close();

        servletContext.setAttribute("count", 1);
        servletContext.getAttribute("count");


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


        Cookie cookie = new Cookie("name", "liubo");
        //以秒计算 默认-1,关闭浏览器就失效 cookie由服务器生成,存在客户端
        cookie.setMaxAge(60*60*24*7);
        //用于指定请求的域名 才会带上该cookie
        cookie.setDomain(".com");
        //只有访问该域名下的CookieDemo的这个路径才会带上该cookie
        cookie.setPath("/CookieDemo");
        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie1 : cookies) {
                String name = cookie1.getName();
                String value = cookie1.getValue();
                System.out.println("cookie  "+ name+" == "+value);
            }
        }

        //创建session 存放在服务器端 持久化
        HttpSession session = request.getSession();
        //session 销毁:1.关闭服务器  2.session会话过期  默认有效期30分钟


//        response.setStatus(302);
//        response.setHeader();
//        response.setContentType();
//        //默认编码是iso-8859-1
//        response.setCharacterEncoding("UTF-8");
//
//        //规定浏览器使用此编码查看
//        response.setHeader("Content-Type","text/html;charset=UTF-8");

      /*  //重定向302 至少请求两次 地址显示最后的资源路径 效率低  不是自己的工程也可以跳
        response.sendRedirect("地址");

        //请求转发 只请求一次 效率高 地址显示请求的servlet的地址
        request.getRequestDispatcher("地址").forward(request,response);*/

        //不管字节流还是字符流,都使用此段代码就行了
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("<h1>hello</h1>");
//        response.getOutputStream().write("hello world".getBytes());

    }
}
