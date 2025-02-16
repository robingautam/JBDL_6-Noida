import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/formlogin")
public class loginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside the login form post request");
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String fullName = firstName+" "+lastName;
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(fullName);
    }
}
