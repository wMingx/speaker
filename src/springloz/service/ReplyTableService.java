package springloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ReplyTable;
import springloz.dao.IReplyTableDao;
/**
 * @作者：loz
 * @备注：库查询信息Service层
 * @DeliveryTableService
 */
@Repository
public class ReplyTableService implements IReplyTableService {
	
	//库查询信息dao层依赖注入		
	@Autowired		
	private IReplyTableDao replyTableDao; 
	
	/**
	 * @方法：selsctReplyTable 库查询信息
	 * @参数：replyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List<ReplyTable> selsctReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		List<ReplyTable> list=replyTableDao.selsctReplyTable(replyTable);
		return list;
	}

	/**
	 * @方法：selectReplyTableuid 库查询信息
	 * @参数：replyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List<ReplyTable> selectReplyTableuid(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		List<ReplyTable> list=replyTableDao.selectReplyTableuid(replyTable);
		return list;
	}
	/**
	 * @方法：selectReplyTablereplyid 分页库查询信息
	 * @参数：replyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List<ReplyTable> selectReplyTablereplyid(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		List<ReplyTable> list=replyTableDao.selectReplyTablereplyid(replyTable);
		return list;
	}
	/**
	 * @方法：selectReplyTablethemeid 数量查询信息
	 * @参数：replyTable 用户输入的查询条件
	 * @返回值：查询到库信息
	 */
	@Override
	public List<ReplyTable> selectReplyTablethemeid(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		List<ReplyTable> list=replyTableDao.selectReplyTablethemeid(replyTable);
		return list;
	}
	
	
	@Override
	public int selectReplyTablecount(ReplyTable replyTable){
		// TODO Auto-generated method stub
		int i=0;
		i=replyTableDao.selectReplyTablecount(replyTable);
		return i;
	}
	
	@Override
	public int selectReplyTableuidcount(ReplyTable replyTable){
		// TODO Auto-generated method stub
		int i=0;
		i=replyTableDao.selectReplyTableuidcount(replyTable);
		return i;
	}
	
	/**
	 * @方法：insertReplyTable 添加新的库信息
	 * @参数：replyTable 用户添加的库信息
	 * @返回值：无
	 */
	@Override
	public void insertReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		replyTableDao.insertReplyTable(replyTable);
		
	}
	
	
	/**
	 * @方法：updateReplyTable 更新新的库信息
	 * @参数：replyTable 用户添加的库信息
	 * @返回值：无
	 */
	@Override
	public void updateReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		replyTableDao.updateReplyTable(replyTable);
		
	}
	
	

}
