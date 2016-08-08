package manager;

import java.util.List;

import DAO.ScoreDAO;
import DTO.ScoreDTO;

public class ScoreManager {
	
	private static final ScoreManager instance = new ScoreManager();
	private static ScoreDAO scoreDAO;
	
	private ScoreManager() {
		scoreDAO = ScoreDAO.getInstance();
	}
	
	public static ScoreManager getInstance() {
		return instance;
	}
	
	public int insertScore(ScoreDTO score) {
		return scoreDAO.insertScore(score);
	}
	
	public int updateScore(ScoreDTO score) {
		return scoreDAO.updateScore(score);
	}
	
	public ScoreDTO getScore(String userId) {
		return scoreDAO.getScore(userId);
	}
	
	public List<ScoreDTO> getScores() {
		return scoreDAO.getScores();
	}

}
