package manager;

import DAO.MyScoreDAO;
import DTO.MyScoreDTO;

public class MyScoreManager {
	
	private static final MyScoreManager instance = new MyScoreManager();
	private static MyScoreDAO myScoreDAO;
	
	private MyScoreManager() {
		myScoreDAO = MyScoreDAO.getInstance();
	}
	
	public static MyScoreManager getInstance() {
		return instance;
	}
	
	public int insertMyScore(MyScoreDTO myScore) {
		return myScoreDAO.insertMyScore(myScore);
	}
	
	public int updateMyScore(MyScoreDTO myScore) {
		return myScoreDAO.updateMyScore(myScore);
	}
	
	public MyScoreDTO getMyScore(String userId) {
		return myScoreDAO.getMyScore(userId);
	}

}
