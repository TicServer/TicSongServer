package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import manager.MyPageManager;
import DTO.MyPageDTO;
import DTO.ScoreDTO;

/**
 * Servlet implementation class MyPageServlet
 */
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MyPageManager myPageM;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		
		myPageM = MyPageManager.getInstance();
		
		String userId = request.getParameter("userId");
		String color = request.getParameter("color");
		String acc = request.getParameter("acc");
		
		String service = request.getParameter("service");
		System.out.println("MyPage @@ Service : " + service + " userId : " + userId + " color : " + color + " acc : " + acc);
		switch(service) {
		case "insert" :
			jsonOut(response, myPageM.insertMyPage(new MyPageDTO(userId, color, acc)));
			break;
		
		case "update" :
			jsonOut(response, myPageM.updateMyPage(new MyPageDTO(userId, color, acc)));
			break;
		
		case "get" :
			jsonOut(response, myPageM.getMyPage(userId));
			break;
		
		case "all" :
			break;
		}
	}
	
	private void jsonOut(HttpServletResponse response, int result) throws ServletException, IOException {
		
		JSONObject myPageJson = new JSONObject();
		try {
			if(result == 1) {
				myPageJson.put("resultCode", "1");
				myPageJson.put("timestamp", System.currentTimeMillis());
			} else {
				myPageJson.put("resultCode", "0");
				myPageJson.put("errorCode", "");
				myPageJson.put("errorDescription", "");
			}
			
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			myPageJson.put("resultCode", "-1");
			myPageJson.put("errorCode", "");
			myPageJson.put("errorDescription", "");
			
		} finally {
			
			PrintWriter pw = response.getWriter();
			pw.print(myPageJson.toString());
			pw.close();
		}
		return ;
	}
	
	private void jsonOut(HttpServletResponse response, MyPageDTO myPage) throws ServletException, IOException {
		JSONObject myPageJson = new JSONObject();
		try {
			if(myPage != null) {
				myPageJson.put("resultCode", "1");
				myPageJson.put("timestamp", System.currentTimeMillis());
				myPageJson.put("userId", myPage.getUserId());
				myPageJson.put("color", myPage.getColor());
				myPageJson.put("acc", myPage.getAcc());
			} else {
				myPageJson.put("resultCode", "0");
				myPageJson.put("errorCode", "");
				myPageJson.put("errorDescription", "");
			}
			
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			myPageJson.put("resultCode", "-1");
			myPageJson.put("errorCode", "");
			myPageJson.put("errorDescription", "");
			
		} finally {
			
			PrintWriter pw = response.getWriter();
			pw.print(myPageJson.toString());
			pw.close();
		}
		return ;
	}

}
