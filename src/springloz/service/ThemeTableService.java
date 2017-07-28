package springloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ThemeTable;
import springloz.dao.IThemeTableDao;
/**
 * @作者：loz
 * @备注：生产信息查询信息Service层
 *  
 */

@Repository
public class ThemeTableService implements IThemeTableService {
	
	
	//生产信息记录dao层依赖注入
	@Autowired
	private IThemeTableDao themeTableDao;
	
	
	/**
	 * @方法：selsctThemeTable 生产查询信息
	 * @参数：themeTable 用户输入的查询条件
	 * @返回值：查询到生产查询信息
	 */
	@Override
	public List<ThemeTable> selsctThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		
		List<ThemeTable> list=themeTableDao.selsctThemeTable(themeTable);
				
		return list;
	}
	
	
	/**
	 * @方法：selsctThemeTableLike 生产查询信息
	 * @参数：themeTable 用户输入的查询条件
	 * @返回值：查询到生产查询信息
	 */
	@Override
	public List<ThemeTable> selsctThemeTableLike(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		
		List<ThemeTable> list=themeTableDao.selsctThemeTableLike(themeTable);
				
		return list;
	}
	
	/**
	 * @方法：selectthemeTableuid 生产查询信息
	 * @参数：themeTable 用户输入的查询条件
	 * @返回值：查询到生产查询信息
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
	 * @方法：insertAssemblyTable 添加新的生产库信息
	 * @参数：assemblyTable 用户添加的生产信息
	 * @返回值：无
	 */
	@Override
	public void insertThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		themeTableDao.insertThemeTable(themeTable);
		
	}
	
	
	/**
	 * @方法：updateThemeTable 修改新的生产库信息
	 * @参数：themeTable 用户添加的生产信息
	 * @返回值：无
	 */
	@Override
	public int updateThemeTable(ThemeTable themeTable){		
		int i=0;
		i=themeTableDao.updateThemeTable(themeTable);
		return i;
		
	}
	
	
	/**
	 * @方法：updatethemeTabletime 修改新的生产库信息
	 * @参数：themeTable 用户添加的生产信息
	 * @返回值：无
	 */
	@Override
	public int updatethemeTabletime(ThemeTable themeTable){		
		int i=0;
		i=themeTableDao.updatethemeTabletime(themeTable);
		return i;
		
	}
		/**
		 * @方法：deleteassemblyTable 删除生产库信息
		 * @参数：assemblyTable 用户添加的生产信息
		 * @返回值：无
		 */
		@Override
		public int deletedateThemeTable(ThemeTable themeTable){		
			int i=0;
			i=themeTableDao.deletedateThemeTable(themeTable);
			return i;
	}

}
