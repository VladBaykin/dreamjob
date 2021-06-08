package dream.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GreetingServlet extends HttpServlet {
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.println("Nice to meet you, " + name);
        writer.flush();
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String jsonIn = "";
        try (BufferedReader br = new BufferedReader(req.getReader())) {
            jsonIn += br.readLine();
        }
        String name = jsonIn.split(":")[1]
                .replace(" ", "")
                .replace("\"", "")
                .replace("}", "");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        String json = "{" + "\"name\":" + "\"" + name + "\"" + "}";
        writer.println(json);
        writer.flush();
        writer.close();
    }
}
