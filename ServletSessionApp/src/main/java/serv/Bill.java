package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Bill")
public class Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> al=new ArrayList<>();
		HttpSession session=request.getSession(true);
		String itm1=request.getParameter("item1");
		String itm2=request.getParameter("item2");
		if(itm1!=null)
		{
			session.setAttribute("pc",itm1);
		}
		if(itm2!=null)
		{
			session.setAttribute("mobile",itm2);
		}
		String s=(String) session.getAttribute("fan");
		if(s!=null)
		al.add(s);
		s=(String) session.getAttribute("cooler");
		if(s!=null)
		al.add(s);
		s=(String) session.getAttribute("pc");
		if(s!=null)
		al.add(s);
		s=(String) session.getAttribute("mobile");
		if(s!=null)
		al.add(s);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Bill</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>Items</h2>");
		for(String a : al) {
			out.print("<h4>"+a+"</h4>");
		}
		out.print("</body>");
		out.print("</html>");
	}

}
