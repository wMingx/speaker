package springloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ThemeTable;
import springloz.dao.IThemeTableDao;
/**
 * @���ߣ�loz
 * @��ע��������Ϣ��ѯ��ϢService��
 *  
 */

@Repository
public class ThemeTableService implements IThemeTableService {
	
	
	//������Ϣ��¼dao������ע��
	@Autowired
	private IThemeTableDao themeTableDao;
	
	
	/**
	 * @������selsctThemeTable ������ѯ��Ϣ
	 * @������themeTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ��������ѯ��Ϣ
	 */
	@Override
	public List<ThemeTable> selsctThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		
		List<ThemeTable> list=themeTableDao.selsctThemeTable(themeTable);
				
		return list;
	}
	
	
	/**
	 * @������selsctThemeTableLike ������ѯ��Ϣ
	 * @������themeTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ��������ѯ��Ϣ
	 */
	@Override
	public List<ThemeTable> selsctThemeTableLike(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		
		List<ThemeTable> list=themeTableDao.selsctThemeTableLike(themeTable);
				
		return list;
	}
	
	/**
	 * @������selectthemeTableuid ������ѯ��Ϣ
	 * @������themeTable �û�����Ĳ�ѯ����
	 * @����ֵ����ѯ��������ѯ��Ϣ
	 */
	@Override
	public List<ThemeTable> selectthemeTableuid(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		
		List<ThemeTable> list=themeTableDao.selectthemeTableuid(themeTable);
				
		return list;
	}
	
	
	@Override
	public int selectthemeTablecount(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		int i=0;
		i=themeTableDao.selectthemeTablecount(themeTable);
		return i;
	}
	
	@Override
	public int selectthemeTableuidcount(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		int i=0;
		i=themeTableDao.selectthemeTableuidcount(themeTable);
		return i;
	}
	
	/**
	 * @������insertAssemblyTable ����µ���������Ϣ
	 * @������assemblyTable �û���ӵ�������Ϣ
	 * @����ֵ����
	 */
	@Override
	public void insertThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		themeTableDao.insertThemeTable(themeTable);
		
	}
	
	
	/**
	 * @������updateThemeTable �޸��µ���������Ϣ
	 * @������themeTable �û���ӵ�������Ϣ
	 * @����ֵ����
	 */
	@Override
	public int updateThemeTable(ThemeTable themeTable){		
		int i=0;
		i=themeTableDao.updateThemeTable(themeTable);
		return i;
		
	}
	
	
	/**
	 * @������updatethemeTabletime �޸��µ���������Ϣ
	 * @������themeTable �û���ӵ�������Ϣ
	 * @����ֵ����
	 */
	@Override
	public int updatethemeTabletime(ThemeTable themeTable){		
		int i=0;
		i=themeTableDao.updatethemeTabletime(themeTable);
		return i;
		
	}
		/**
		 * @������deleteassemblyTable ɾ����������Ϣ
		 * @������assemblyTable �û���ӵ�������Ϣ
		 * @����ֵ����
		 */
		@Override
		public int deletedateThemeTable(ThemeTable themeTable){		
			int i=0;
			i=themeTableDao.deletedateThemeTable(themeTable);
			return i;
	}

}
