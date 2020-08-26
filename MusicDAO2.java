package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.manager.MusicVO;
import com.sist.manager.MusicVO2;

public class MusicDAO2 {
	   private Connection conn;
	   //sql ����
	   private PreparedStatement ps;
	   
	   //����
	   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	   
	   public MusicDAO2()
	   {
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         //����̹��� �̿��ؼ� ���� = > thin ����̹� 
	      }catch (Exception e) {}
	   }
	   //2.���� �޼ҵ�
	   public void getConnection()
	   {
	      try {
	         conn=DriverManager.getConnection(URL,"hr","happy");
	      }catch (Exception e) {}
	   }
	   //3.�ݴ� �޼ҵ�
	   public void disConnection()
	   {
	      try {
	         if(ps!=null)ps.close();
	         if(conn!=null)conn.close();
	      }catch (Exception e) {}
	   }
	   // ���
	   public void musicInsert(MusicVO2 vo) {
		   try {
			   // ����
			   getConnection();
			   // sql����
			   String sql="INSERT INTO music VALUES(music_mno_seq.nextval,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   // ?�� ���� ä���
			   ps.setInt(1, vo.getCateno());
			   ps.setString(2, vo.getTitle());
			   ps.setString(3, vo.getPoster());
			   ps.setString(4, vo.getSinger());
			   ps.setString(5, vo.getAlbum());
			   // ���� ����
			   ps.executeUpdate(); // INSERT ������ ���� => �����ϸ� �ڵ����� COMMIT
		   }catch(Exception ex) {
			   System.out.println(ex.getMessage());
		   }
		   finally {
			   disConnection();
		   }
	   }
	   // �帣
	   public ArrayList<String> musicGenreAllData(){
		   ArrayList<String> list=new ArrayList<String>();
		   try {
			   getConnection();
			   String sql="SELECT genre FROM music_genre2 ORDER BY no";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   String genre=rs.getString(1);
				   list.add(genre);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   System.out.println(ex.getMessage());
		   }
		   finally {
			   disConnection();
		   }
		   return list;
	   }
	   // Music ���
	   public ArrayList<MusicVO2> musicAllData(int cateno, int page){
		   ArrayList<MusicVO2> list=new ArrayList<MusicVO2>();
		   try {
			   getConnection();
			   String sql="SELECT mno,title,poster,singer,album,RANK() OVER(ORDER BY mno ASC),num "
			   		+ "FROM (SELECT mno,title,poster,singer,album,rownum as num "
			   		+ "FROM (SELECT mno,title,poster,singer,album "
			   		+ "FROM music WHERE cateno=? ORDER BY mno)) "
			   		+ "WHERE num BETWEEN ? AND ?"; //����¡ ���
			   int rowSize=30;
			   int start=(rowSize*page)-(rowSize-1);
			   //rownum ==> ���۹�ȣ(1)
			   int end=rowSize*page;
			   
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, cateno);
			   ps.setInt(2, start);
			   ps.setInt(3, end);
			   
			   //����
			   ResultSet rs=ps.executeQuery();
			   while(rs.next()) {
				   MusicVO2 vo=new MusicVO2();
				   vo.setMno(rs.getInt(1));
				   vo.setTitle(rs.getString(2));
				   vo.setPoster(rs.getString(3));
				   vo.setSinger(rs.getString(4));
				   vo.setAlbum(rs.getString(5));
				   vo.setRank(rs.getInt(6));
				   
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex) {
			   System.out.println(ex.getMessage());
		   }
		   finally {
			   disConnection();
		   }
		   return list;
	   }
	   public String musicGetGenre(int cateno) {
		   String genre="";
		   try{
			   getConnection();
			   String sql="SELECT genre FROM music_genre2 WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, cateno);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   genre=rs.getString(1);
			   rs.close();
		   }catch(Exception ex) {
			   System.out.println(ex.getMessage());
		   }
		   finally {
			   disConnection();
		   }
		   return genre;
	   }
}