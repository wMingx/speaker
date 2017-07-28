package springloz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ThemeTable;


/**
 * @���ߣ�loz
 * @��ע�� 
 *  
 */

@Repository
public  class ThemeTableDao implements IThemeTableDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * @������selsctAssemblyTable ������ѯ��Ϣ
	 * @������assemblyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ��������ѯ��Ϣ
	 */
	@Override
	public List<ThemeTable> selsctThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("themeTable.selectthemeTable", themeTable);
	}
	
	/**
	 * @������selsctAssemblyTableLike ������ѯ��Ϣ
	 * @������assemblyTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ��������ѯ��Ϣ
	 */
	@Override
	public List<ThemeTable> selsctThemeTableLike(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("themeTable.selectthemeTableLike", themeTable);
	}
	
	/**
	 * @������selectthemeTableuid ������ѯ��Ϣ
	 * @������themeTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ��������ѯ��Ϣ
	 */
	@Override
	public List<ThemeTable> selectthemeTableuid(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("themeTable.selectthemeTableuid", themeTable);
	}
	
	@Override
	public int selectthemeTablecount(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		int i=0;
		i=sqlSession.selectOne("themeTable.selectthemeTablecount", themeTable);
		return i;
	}
	
	@Override
	public int selectthemeTableuidcount(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		int i=0;
		i=sqlSession.selectOne("themeTable.selectthemeTableuidcount", themeTable);
		return i;
	}
	
	/**
	 * @������insertAssemblyTable ����µĿ���Ϣ
	 * @������assemblyTable �û���ӵ�������Ϣ
	 * @����ֵ����
	 */
	@Override
	public void insertThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		 sqlSession.insert("themeTable.insertthemeTable", themeTable);
	}

	
	
	
	/**
	 * @������updateassemblyTable �޸��µĿ���Ϣ
	 * @������assemblyTable �û���ӵ�������Ϣ
	 * @����ֵ����
	 */
	@Override
	public int updateThemeTable(ThemeTable themeTable){
		
		int i=0;
		i=sqlSession.update("themeTable.updatethemeTable", themeTable);
		return i;
		
	}
	
	/**
	 * @������updateassemblyTable �޸��µĿ���Ϣ
	 * @������assemblyTable �û���ӵ�������Ϣ
	 * @����ֵ����
	 */
	@Override
	public int updatethemeTabletime(ThemeTable themeTable){
		
		int i=0;
		i=sqlSession.update("themeTable.updatethemeTabletime", themeTable);
		return i;
		
	}
	/**
	 * @������deletedateassemblyTable ɾ���Ŀ���Ϣ
	 * @������assemblyTable �û���ӵ�������Ϣ
	 * @����ֵ����
	 */
	@Override
	public int deletedateThemeTable(ThemeTable themeTable ){
		
		int i=0;
		i=sqlSession.delete("themeTable.deletethemeTable", themeTable);
		return i;
		
	}
	
	
	
}
