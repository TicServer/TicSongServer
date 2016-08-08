package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.ScoreManager;
import manager.UserManager;

import org.json.simple.JSONObject;

import DTO.ScoreDTO;
import DTO.UserDTO;

/**
 * Servlet implementation class ScoreServlet
 */
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScoreManager scoreMgr;
  
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
		
		scoreMgr = ScoreManager.getInstance();
		
		String userId = request.getParameter("userId");
		String score = request.getParameter("score");
		String userLevel = request.getParameter("userLevel");
		
		String service = request.getParameter("service");
		System.out.println("MyPage @@ Service : " + service + " userId : " + userId + " score : " + score + " userLevel : " + userLevel);
		switch(service) {
			case "insert" :
				jsonOut(response, scoreMgr.insertScore(new ScoreDTO(userId, Integer.parseInt(score), Integer.parseInt(userLevel))));
				break;
			
			case "update" :
				jsonOut(response, scoreMgr.updateScore(new ScoreDTO(userId, Integer.parseInt(score), Integer.parseInt(userLevel))));
				break;
			
			case "get" :
				jsonOut(response, scoreMgr.getScore(userId));
				break;
			
			case "all" :
				break;
		
		}
	}
	
	private void jsonOut(HttpServletResponse response, int result) throws ServletException, IOException {
		
		JSONObject scoreJson = new JSONObject();
		try {
			if(result == 1) {
				scoreJson.put("resultCode", "1");
				scoreJson.put("timestamp", System.currentTimeMillis());
			} else {
				scoreJson.put("resultCode", "0");
				scoreJson.put("errorCode", "");
				scoreJson.put("errorDescription", "");
			}
			
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			scoreJson.put("resultCode", "0");
			scoreJson.put("errorCode", "");
			scoreJson.put("errorDescription", "");
			
		} finally {
			
			PrintWriter pw = response.getWriter();
			pw.print(scoreJson.toString());
			pw.close();
		}
		return ;
	}
	
	private void jsonOut(HttpServletResponse response, ScoreDTO score) throws ServletException, IOException {
		JSONObject scoreJson = new JSONObject();
		try {
			if(score != null) {
				scoreJson.put("resultCode", "1");
				scoreJson.put("timestamp", System.currentTimeMillis());
				scoreJson.put("userId", score.getUserId());
				scoreJson.put("score", score.getScore());
				scoreJson.put("userLevel", score.getUserLevel());
			} else {
				scoreJson.put("resultCode", "0");
				scoreJson.put("errorCode", "");
				scoreJson.put("errorDescription", "");
			}
			
		} catch(NullPointerException npe) {
			npe.printStackTrace();
			scoreJson.put("resultCode", "0");
			scoreJson.put("errorCode", "");
			scoreJson.put("errorDescription", "");
			
		} finally {
			
			PrintWriter pw = response.getWriter();
			pw.print(scoreJson.toString());
			pw.close();
		}
		return ;
	}

}
