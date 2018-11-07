import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Insert extends HttpServlet{
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
	 public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException{
    response.setContentType("text/html;charset=UTF-8");
    Main f = new Main();
    PrintWriter out = response.getWriter();
      String name = request.getParameter("name");
      String rno = request.getParameter("Rno");
      String tel = request.getParameter("tel");
      //int tel = Integer.parseInt(ph);
      String ser = request.getParameter("ser");
      String oid = request.getParameter("Oid");
      //String password = request.getParameter("password");
      //f.insert(uname, eid, phone, pass);
      response.sendRedirect("Add.html");
      //Class.forName("oracle.jdbc.driver.OracleDriver");
//Connection con=DriverManager.getConection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
      //conn = DriverManager.getConnection(f.connectionUrl,f.username, f.password);
      /*PreparedStatement pst = con.prepareStatement("insert into emp_info values(?,?)");
      pst.setString(1,username);
      pst.setString(2,password);*/
      try{
      	Class.forName("com.mysql.jdbc.Driver");
		PreparedStatement pstmt1 = f.conn.prepareStatement("insert into NCP (Name,RegNo,PhNo,Service,OrderID) values (?,?,?,?,?);");
			pstmt1.setString(1, name);
			pstmt1.setString(2,rno);
			pstmt1.setString(3,tel);
			pstmt1.setString(4,ser);
			pstmt1.setString(5,oid);
			//pstmt1.setInt(6, c_a);
      int i = pstmt1.executeUpdate();
      if(i!=0){
        System.out.println("<br>Record has been inserted");
      }
      else{
        System.out.println("failed to insert the data");
      }
    }
    catch (Exception e){
      out.println(e);
    }
}


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
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
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
  

	/*String name,rno,phno,ser,oid;
	Insert(String name,String rno,int phno,String ser,String oid){
		Main f = new Main();
		try{
				Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException cnfe){
				System.out.println("Could not find the JDBC driver!");
				System.exit(1);
		}
		//conn = DriverManager.getConnection(f.connectionUrl,f.username, f.password);
		/*String name = document.getElementById("Name");
        String rno = document.getElementById("Rno");
        String phno = document.getElementById("PhNo");
        String ser = document.getElementById("Ser");
        String oid = document.getElementById("OID");
		try{
		PreparedStatement pstmt1 = f.conn.prepareStatement("insert into NCP (Name,RegNo,PhNo,Service,OrderID) values (?,?,?,?,?);");
			pstmt1.setString(1, name);
			pstmt1.setString(2,rno);
			pstmt1.setInt(3,phno);
			pstmt1.setString(4,ser);
			pstmt1.setString(5,oid);
			//pstmt1.setInt(6, c_a);
			int rs1 = pstmt1.executeUpdate();
	}catch (SQLException sqle) {
					System.out.println(sqle);
					System.exit(1);
		}
}*/
	//public static void main(String args[]) {
		
		//Insert f1 = new Insert();

	//}
}
























/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
/**
 *
 * @author asus
 */
//public class Insert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {*/
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Insert</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Insert at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/
/*
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
*/
/*
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

    /*@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
*/
