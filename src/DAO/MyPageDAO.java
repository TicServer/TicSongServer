package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import DTO.MyPageDTO;
import DTO.UserDTO;

public class MyPageDAO {

	private static MyPageDAO myPageDAO;
	static {
		myPageDAO = new MyPageDAO();
	}
	public static MyPageDAO getInstance() {
		return myPageDAO;
	}
	private MyPageDAO(){
		
	}
	
	 public int insertDefaultMyPage(MyPageDTO myPage) {
	        PreparedStatement pstmt = null;
	        Connection conn = null;
	        int success = 0;

	        try {
	            conn = DBConnection.getInstance().getConn();
	            conn.setAutoCommit(false);

	            String sql = " insert into mypage (userid,color,acc) values(?,?,?);";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, myPage.getUserId());
	            pstmt.setInt(2, 1);
	            pstmt.setInt(3, 1);
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

	    public int insertMyPage(MyPageDTO myPage) {
	        PreparedStatement pstmt = null;
	        Connection conn = null;
	        int success = 0;

	        try {
	            conn = DBConnection.getInstance().getConn();
	            conn.setAutoCommit(false);

	            String sql = " insert into mypage (userid,color,acc) values(?,?,?);";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, myPage.getUserId());
	            pstmt.setString(2, myPage.getColor());
	            pstmt.setString(3, myPage.getAcc());
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

	    public int updateColor(MyPageDTO myPage) {
	        PreparedStatement pstmt = null;
	        Connection conn = null;
	        ResultSet rs = null;
	        int success = 0;

	        try {
	            conn = DBConnection.getInstance().getConn();

	            String sql = "select * from user where userid=?;";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, myPage.getUserId());
	            rs = pstmt.executeQuery();

	            if(rs.next()){
	                conn.setAutoCommit(false);
	                String updateSql = "update mypage set color=? where userid=?;";
	                pstmt = conn.prepareStatement(updateSql);
	                pstmt.setString(1, myPage.getColor());
	                pstmt.setString(2, myPage.getUserId());
	                pstmt.executeUpdate();

	                success = 1;
	            }else
	                success = 0;

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

	    public int updateAcc(MyPageDTO myPage) {
	        PreparedStatement pstmt = null;
	        Connection conn = null;
	        ResultSet rs = null;
	        int success = 0;

	        try {
	            conn = DBConnection.getInstance().getConn();

	            String sql = "select * from user where userid=?;";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, myPage.getUserId());
	            rs = pstmt.executeQuery();

	            if(rs.next()){
	                conn.setAutoCommit(false);
	                String updateSql = "update mypage set acc=? where userid=?;";
	                pstmt = conn.prepareStatement(updateSql);
	                pstmt.setString(1, myPage.getAcc());
	                pstmt.setString(2, myPage.getUserId());
	                pstmt.executeUpdate();

	                success = 1;
	            }else
	                success = 0;

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

	    public MyPageDTO getMyPage(String userId) {
	        final String sql =  "select * from mypage where userid="+userId+";";

	        PreparedStatement pstmt = null;
	        Connection conn = null;
	        ResultSet rs = null;
	        //List<MyPageDTO> myPageList = null;
	        MyPageDTO myPageDTO=null;

	        try {
	            //myPageList = new ArrayList<MyPageDTO>();
	            conn = DBConnection.getInstance().getConn();

	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();

	            while(rs.next()){

	                myPageDTO=new MyPageDTO(rs.getString("userId"),rs.getString("color"),rs.getString("acc"));

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
	        return myPageDTO;
	    }

	
	public List<MyPageDTO> getMyPages() {
		final String sql =  "select * from mypage;";
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<MyPageDTO> myPageList = null;
		
		try {
			myPageList = new ArrayList<MyPageDTO>();
			conn = DBConnection.getInstance().getConn();
			
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
                
            while(rs.next()){
            	
            	myPageList.add(new MyPageDTO(rs.getString("userId"),rs.getString("color"),rs.getString("acc")));
            	
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
		return myPageList;
	}
	
}
