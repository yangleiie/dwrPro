package sugar.servlet;

import sugar.task.MyTask;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Timer;

/**
 * Created by lei on 2018/2/5.
 */
public class ServerRun extends HttpServlet {

    private Timer timer = null;
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        timer = new Timer(true);
        timer.schedule(new MyTask(), 0, 1000*6);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
    public void destroy(){}
}
