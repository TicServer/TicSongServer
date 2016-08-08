package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.UserManager;

import org.json.simple.JSONObject;

//import DAO.ScoreDAO;
//import DTO.ScoreDTO;
import DTO.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		response.setContentType("application/json;charset=utf-8");
		
		String userAgent = request.getHeader("User-Agent").split("/")[0];
		System.out.println("userAgent : " + userAgent);
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		
		//String platform = request.getParameter("platform");
		// rDate 추가.
		
		System.out.println("요청온 아이디 : "+userId);
		System.out.println("요청온 이름 : "+name);
		
		UserManager userM = UserManager.getInstance();
		UserDTO userDTO = userM.login(userId,name);
		//UserDTO userDTO = userM.login("123123","Daesub");
		//System.out.println(" userDTO : " + userDTO);

		JSONObject loginJson = new JSONObject();
		/*---------------모바일을 사용하는 경우 --------------------*/
		if ( userAgent.toLowerCase().equals("okhttp")  ) {
			try {
				loginJson.put("resultCode", "1");
				loginJson.put("timestamp", System.currentTimeMillis());
				loginJson.put("userId", userDTO.getUserId());
				loginJson.put("name", userDTO.getName());
				loginJson.put("platform", userDTO.getPlatform());
				
			} catch(NullPointerException npe) {
				npe.printStackTrace();
				loginJson.put("resultCode", "0");
				loginJson.put("errorCode", "");
				loginJson.put("errorDescription", "");
				
			} finally {
				
				PrintWriter pw = response.getWriter();
				pw.print(loginJson.toString());
				pw.close();
			}
			return ;
		} // if end.	
		
	}
}
