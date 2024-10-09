
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ComputeLoanServlet")
public class ComputeLoanServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double interestRate = Double.parseDouble(request.getParameter("interestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));

        Loan loan = new Loan(loanAmount, interestRate, numberOfYears);



        double monthlyPayment = loan.getMonthlyPayment();

        double totalPayment = loan.getTotalPayment();



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();



        out.println("<html><body>");


        out.println("<h2>Loan Payment Results</h2>");
        out.println("Monthly Payment: $" + String.format("%.2f", monthlyPayment) + "<br>");
        out.println("Total Payment: $" + String.format("%.2f", totalPayment) + "<br>");
        out.println("</body></html>");




    }
}