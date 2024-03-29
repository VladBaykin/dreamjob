package dream.servlet;

import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import dream.model.Candidate;
import dream.store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CandidateEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("newCand.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (BufferedReader read = req.getReader();
             PrintWriter out = resp.getWriter()) {
            StringBuilder fullLine = new StringBuilder();
            String oneLine;
            while ((oneLine = read.readLine()) != null) {
                fullLine.append(oneLine);
            }
            JSONObject json = (JSONObject) new JSONParser().parse(fullLine.toString());
            String temp = (String) json.get("action");
            int id = Integer.parseInt((String) json.get("id"));
            if (temp.equals("getCand")) {
                resp.setCharacterEncoding("UTF-8");
                String jsonOut = new Gson().toJson(PsqlStore.instOf().findCandidateById(id));
                out.write(jsonOut);
                out.flush();
            }
            if (temp.equals("saveCand")) {
                Candidate candidate = new Candidate(
                        id,
                        (String) json.get("name"),
                        (String) json.get("city")
                );
                PsqlStore.instOf().saveCandidate(candidate);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
