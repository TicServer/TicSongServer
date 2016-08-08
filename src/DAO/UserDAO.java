package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.UserDTO;
import module.DBConnection;

public class UserDAO {
	
	private final String INSERT_USER_ID_NAME = "insert into user (userid,name) values(?,?);";
	private final String INSERT_USER_ID_NAME_PLATFORM = "insert into user (userid,name,platform) values(?,?,?);";
	
	private final String LOGIN_BY_ID = "select * from user where userid=?";
	private final String LOGIN_BY_ID_NAME = "select * from user where userid=? and name=?;";
	private final String LOGIN_BY_ID_NAME_PLATFORM = "select * from user where userid=? and name=? and platform=?;";
	
	private static UserDAO userDAO;
	static {
		userDAO = new UserDAO();
	}
	public static UserDAO getInstance() {
		return userDAO;
	}
	private UserDAO(){
		
	}
	
	
	public int insertUser(String userId, String name) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int success = 0;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(INSERT_USER_ID_NAME);
			pstmt.setString(1, userId);pstmt.setString(2, name);
			success = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e ) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
            		conn.setAutoCommit(true);
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return success;
	}
	
	public int insertUser(String userId, String name, int platform) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int success = 0;
		
		try {
			conn = DBConnection.getInstance().getConn();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(INSERT_USER_ID_NAME_PLATFORM);
			pstmt.setString(1, userId);pstmt.setString(2, name);
			pstmt.setInt(3, platform);
			success = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e ) {
	        e.printStackTrace();
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	if (conn != null) {
	            try {
	                System.err.print("Transaction is being Rolled back");
	                conn.rollback();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
            		conn.setAutoCommit(true);
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return success;
	}

	
	public UserDTO login(String userId) {
		
		PreparedStatement pstmt = null;
		UserDTO userDTO = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getInstance().getConn();
			
			pstmt = conn.prepareStatement(LOGIN_BY_ID);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userDTO = new UserDTO(rs.getString("userid"),rs.getString("name"),rs.getInt("platform"));
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userDTO;
	}
	
	public UserDTO login(String userId, String name) {
		
		PreparedStatement pstmt = null;
		UserDTO userDTO = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getInstance().getConn();
			
			pstmt = conn.prepareStatement(LOGIN_BY_ID_NAME);
			pstmt.setString(1,userId);
			pstmt.setString(2,name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userDTO = new UserDTO(rs.getString("userid"),rs.getString("name"),rs.getInt("platform"));
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userDTO;
	}
	
	public UserDTO login(String userId, String name, int platform) {
		
		PreparedStatement pstmt = null;
		UserDTO userDTO = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getInstance().getConn();
			
			pstmt = conn.prepareStatement(LOGIN_BY_ID_NAME_PLATFORM);
			pstmt.setString(1,userId);
			pstmt.setString(2,name);
			pstmt.setInt(3, platform);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userDTO = new UserDTO(rs.getString("userid"),rs.getString("name"),rs.getInt("platform"));
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return userDTO;
	}
	
	public List<UserDTO> getUsers() {
		final String sql =  "select * from user;";
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<UserDTO> userList = null;
		
		try {
			userList = new ArrayList<UserDTO>();
			conn = DBConnection.getInstance().getConn();
			
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
                
            while(rs.next()){
            	
            	userList.add(new UserDTO(rs.getString("userId"),rs.getString("name"), rs.getInt("platform")));
            	
			}
		} catch (SQLException e ) {
	        e.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) {
            	try { 
                	conn.close(); 
            	} catch(SQLException ex) {}
            } 
	    }
		return userList;
	}
	
	
	
	
}
