package manager;

import java.util.List;

import DAO.MyPageDAO;
import DTO.MyPageDTO;

public class MyPageManager {
	
	private static final MyPageManager instance = new MyPageManager();
	private static MyPageDAO myPageDAO;
	
	private MyPageManager() {
		myPageDAO = MyPageDAO.getInstance();
	}
	
	public static MyPageManager getInstance() {
		return instance;
	}
	
	public int insertMyPage(MyPageDTO myPage) {
		return myPageDAO.insertMyPage(myPage);
	}
	
	public int updateMyPage(MyPageDTO myPage) {
		
		myPageDAO.updateAcc(myPage);
		
		return myPageDAO.updateColor(myPage);
	}
	
	public MyPageDTO getMyPage(String userId) {
		return myPageDAO.getMyPage(userId);
	}
	
	public List<MyPageDTO> getMyPages() {
		return myPageDAO.getMyPages();
	}

}
