package springloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ReplyTable;
import springloz.dao.IReplyTableDao;
/**
 * @���ߣ�loz
 * @��ע�����ѯ��ϢService��
 * @DeliveryTableService
 */
@Repository
public class ReplyTableService implements IReplyTableService {
	
	//���ѯ��Ϣdao������ע��		
	@Autowired		
	private IReplyTableDao replyTableDao; 
	
	/**
	 * @������selsctReplyTable ���ѯ��Ϣ
	 * @������replyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
	 */
	@Override
	public List<ReplyTable> selsctReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		List<ReplyTable> list=replyTableDao.selsctReplyTable(replyTable);
		return list;
	}

	/**
	 * @������selectReplyTableuid ���ѯ��Ϣ
	 * @������replyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
	 */
	@Override
	public List<ReplyTable> selectReplyTableuid(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		List<ReplyTable> list=replyTableDao.selectReplyTableuid(replyTable);
		return list;
	}
	/**
	 * @������selectReplyTablereplyid ��ҳ���ѯ��Ϣ
	 * @������replyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
	 */
	@Override
	public List<ReplyTable> selectReplyTablereplyid(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		List<ReplyTable> list=replyTableDao.selectReplyTablereplyid(replyTable);
		return list;
	}
	/**
	 * @������selectReplyTablethemeid ������ѯ��Ϣ
	 * @������replyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ������Ϣ
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
	 * @������insertReplyTable ����µĿ���Ϣ
	 * @������replyTable �û���ӵĿ���Ϣ
	 * @����ֵ����
	 */
	@Override
	public void insertReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		replyTableDao.insertReplyTable(replyTable);
		
	}
	
	
	/**
	 * @������updateReplyTable �����µĿ���Ϣ
	 * @������replyTable �û���ӵĿ���Ϣ
	 * @����ֵ����
	 */
	@Override
	public void updateReplyTable(ReplyTable replyTable) {
		// TODO Auto-generated method stub
		replyTableDao.updateReplyTable(replyTable);
		
	}
	
	

}
