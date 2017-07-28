package springloz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ReplyTable;
import springloz.ThemeTable;
import springloz.User;

/**
 * @���ߣ�loz
 * @��ע�����ѯ��ϢDAO��
 * @ReplyTableDao
 */



@Repository
public class ReplyTableDao implements IReplyTableDao {
	
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * @������selsctReplyTable ���ѯ��Ϣ
	 * @������ReplyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
	 */
	@Override
	public List<ReplyTable> selsctReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("replyTable.selectReplyTable", replyTable);
	}
	/**
	 * @������selectReplyTableuid ���ģ����ѯ��ѯ��Ϣ
	 * @������ReplyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
	 */
	@Override
	public List <ReplyTable> selectReplyTableuid(ReplyTable replyTable){
		// TODO Auto-generated method stub
		return sqlSession.selectList("replyTable.selectReplyTableuid", replyTable);
	}
	/**
	 * @������selectReplyTablereplyid  ��ҳ��ѯ��ѯ��Ϣ
	 * @������ReplyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
	 */
	@Override
	public List <ReplyTable> selectReplyTablereplyid(ReplyTable replyTable){
		// TODO Auto-generated method stub
		return sqlSession.selectList("replyTable.selectReplyTablereplyid", replyTable);
	}
	/**
	 * @������selectReplyTablethemeid ������ѯ��ѯ��Ϣ
	 * @������ReplyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
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
	 * @������insertReplyTable ����µĿ���Ϣ
	 * @������ReplyTable �û���ӵĿ���Ϣ
	 * @����ֵ����
	 */
	@Override
	public void  insertReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		 sqlSession.insert("replyTable.insertReplyTable", replyTable);
	}
	
	
	/**
	 * @������updateReplyTable �����µĿ���Ϣ
	 * @������ReplyTable �û���ӵĿ���Ϣ
	 * @����ֵ����
	 */
	@Override
	public void updateReplyTable(ReplyTable replyTable){
		// TODO Auto-generated method stub
		 sqlSession.insert("replyTable.updateReplyTable", replyTable);
	}
	
}
