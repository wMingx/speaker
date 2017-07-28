package springloz.dao;

import java.util.List;

import springloz.ReplyTable;
import springloz.ThemeTable;


public interface IReplyTableDao {
	
	List <ReplyTable> selsctReplyTable(ReplyTable replyTable);
	List <ReplyTable> selectReplyTableuid(ReplyTable replyTable);
	List <ReplyTable> selectReplyTablereplyid(ReplyTable replyTable);
	List <ReplyTable> selectReplyTablethemeid(ReplyTable replyTable);
	int selectReplyTablecount(ReplyTable replyTable);
	int selectReplyTableuidcount(ReplyTable replyTable);
	 
	
	void insertReplyTable(ReplyTable replyTable);
	
	void updateReplyTable(ReplyTable replyTable);

}
