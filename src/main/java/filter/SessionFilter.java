package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilter implements Filter {
    private String excludedPage;
    private String[] excludedPages;

    public void init(FilterConfig filterConfig) {
        excludedPage = filterConfig.getInitParameter("excludedPages");
        if (excludedPage != null && excludedPage.length() > 0) {
            excludedPages = excludedPage.split(",");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
// 定义表示变量 并验证用户请求URL 是否包含不过滤路径
        boolean flag = false;
        for (String page : excludedPages) {
            if (request.getServletPath().equals(page)) {
                flag = true;
            }
        }
        if (flag) {
            filterChain.doFilter(request, response);
        } else {
            if (request.getSession().getAttribute("username") == null) {
                request.setAttribute("info", "请先登录");
                request.getRequestDispatcher("/login_galaxy.jsp").forward(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }

    public void destroy() {

    }
}
