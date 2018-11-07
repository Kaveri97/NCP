import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.*; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchR extends HttpServlet{
     /* /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    String oid;
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException{
    response.setContentType("text/html;charset=UTF-8");
    Main f = new Main();
    PrintWriter out = response.getWriter();
      
      
      try{
      	Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement pstmt1=f.conn.prepareStatement("select Name, RegNo, OrderID from NCP where Status=\"Delivered\" order by Name;");
		ResultSet rs = pstmt1.executeQuery();
                ResultSet rs1 = rs;
                
        /*while(rs.next()){
                            //response.sendRedirect("Contents.html");
                            //request.setAttribute("name", rs.getString("Name"));
                            //request.setAttribute("Rno", rs.getString("Name"));
                            //response.sendRedirect("Contents.html");
                            String name = rs.getString("Name");
                            String name2 = rs.getString("RegNo");
                            System.out.println(name+" "+ name2);
                            
                            
        }*/
out.print("<html>"); 
    out.print("<link href=\"style.css\" rel='stylesheet' type='text/css' media=\"all\" />"); 
    out.print("<link rel=\"stylesheet\" href=\"NCP.css\">"); 
    out.print("<script src='jquery.min.js'></script>"); 
out.print("<script src=\"index.js\"></script>"); 
out.print("<title>Courier Management</title>");
    out.print("<body>"); 
    out.print("<h3 align=\"right\"><a href=\"Second.html\">Home</a></h3>");
    out.print("<h1 align=\"center\" color=\"white\">Student Details</h1>"); 
    out.print("<div style=\"background-color:white; width:95%; height:70%; margin:0 auto; padding:20px;\" >"); 	
        out.print("<form method=\"get\" action=\"Delete\" >"); 
out.print("<table width=90% border=1>");  
//out.print("<caption>Customers:</caption>");  
  
//ResultSet rs=ps.executeQuery();  
              
/* Printing column names */  
ResultSetMetaData rsmd=rs.getMetaData();  
int total=rsmd.getColumnCount();  
out.print("<tr>");  
out.print("<th> S.no </th>");
for(int i=1;i<=total;i++)  
{  
out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
}  
out.print("<th align=\"right\"> Check </th>");
out.print("<th>  </th>");
out.print("</tr>");  
              
/* Printing result */  
int j=0; 
while(rs.next())  
{  
out.print("<tr><td align=\"center\"><input type=\"text\" name=\"Sno\" value=\""+(j+1)+
        "\" readonly></td><td align=\"center\"><input type=\"text\" name=\"Name\" "
                + "value=\""+rs.getString(1)+"\" readonly></td><td align=\"center\">"
                        + "<input type=\"text\" name=\"Rno\" value=\""+rs.getString(2)+"\" readonly>"
                                + "</td><td align=\"center\"><input type=\"text\" name=\"Oid\" value=\""
        +rs.getString(3)+"\" readonly></td><td align=\"center\">Delivered</td><td align=\"center\"><input type=\"checkbox\" name=\"deliver\" value="+(j+1)+"></td></tr>"
);  
j+=1;
}  
out.print("</table>");
out.print("<button>Update</button>");
out.print("</form>");
out.print("</div>");
out.print("<script>");
out.print("$(\'button\').click(function() {");
//out.print("if(this.checked==true)");
//out.print("var s = $(\"input[name=Sno]\").val();");
out.print("alert(\"Record(s) Updated!\");");
//out.print("$(\"input[name=deliver]\").val(s);}else{");
//out.print("$(\"input[name=deliver]\").val(\"No\");}");
//out.print("alert($(\"input[name=deliver]\").val());");
out.print("});");
//return true;
out.print("</script>");
out.print("</body>");
out.print("</html>");
}      
    catch (Exception e){
      out.println(e);
      //e.printStackTrace();
    }
}
    //public void done(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException, ClassNotFoundException{
    //    processRequest(req,res);
    //}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /*/**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
	/*public static void main(String [] args){
            SearchR s = new SearchR();
            s.done();
        }*/
}
