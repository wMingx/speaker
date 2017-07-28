package springloz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ReplyTable;
import springloz.ThemeTable;
import springloz.User;

/**
 * @作者：loz
 * @备注：库查询信息DAO层
 * @ReplyTableDao
 */



@Repository
public class ReplyTableDao implements IReplyTableDao {
	
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * @方法：selsctReplyTable 库查询信息
	 * @参数：ReplyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List<ReplyTable> selsctReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("replyTable.selectReplyTable", replyTable);
	}
	/**
	 * @方法：selectReplyTableuid 库非模糊查询查询信息
	 * @参数：ReplyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List <ReplyTable> selectReplyTableuid(ReplyTable replyTable){
		// TODO Auto-generated method stub
		return sqlSession.selectList("replyTable.selectReplyTableuid", replyTable);
	}
	/**
	 * @方法：selectReplyTablereplyid  分页查询查询信息
	 * @参数：ReplyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List <ReplyTable> selectReplyTablereplyid(ReplyTable replyTable){
		// TODO Auto-generated method stub
		return sqlSession.selectList("replyTable.selectReplyTablereplyid", replyTable);
	}
	/**
	 * @方法：selectReplyTablethemeid 数量查询查询信息
	 * @参数：ReplyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List <ReplyTable> selectReplyTablethemeid(ReplyTable replyTable){
		// TODO Auto-generated method stub
		return sqlSession.selectList("replyTable.selectReplyTablethemeid", replyTable);
	}
	
	@Override
	public int selectReplyTablecount(ReplyTable replyTable){
		// TODO Auto-generated method stub
		int i=0;
		i=sqlSession.selectOne("replyTable.selectReplyTablecount", replyTable);
		return i;
	}
	
	@Override
	public int selectReplyTableuidcount(ReplyTable replyTable){
		// TODO Auto-generated method stub
		int i=0;
		i=sqlSession.selectOne("replyTable.selectReplyTableuidcount", replyTable);
		return i;
	}
	
	
	
	
	/**
	 * @方法：insertReplyTable 添加新的库信息
	 * @参数：ReplyTable 用户添加的库信息
	 * @返回值：无
	 */
	@Override
	public void  insertReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		 sqlSession.insert("replyTable.insertReplyTable", replyTable);
	}
	
	
	/**
	 * @方法：updateReplyTable 更新新的库信息
	 * @参数：ReplyTable 用户添加的库信息
	 * @返回值：无
	 */
	@Override
	public void updateReplyTable(ReplyTable replyTable){
		// TODO Auto-generated method stub
		 sqlSession.insert("replyTable.updateReplyTable", replyTable);
	}
	
}
