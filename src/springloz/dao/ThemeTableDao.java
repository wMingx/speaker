package springloz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springloz.ThemeTable;


/**
 * @作者：loz
 * @备注： 
 *  
 */

@Repository
public  class ThemeTableDao implements IThemeTableDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * @方法：selsctAssemblyTable 生产查询信息
	 * @参数：assemblyTable 用户输入的查询条件
	 * @返回值：查询到生产查询信息
	 */
	@Override
	public List<ThemeTable> selsctThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("themeTable.selectthemeTable", themeTable);
	}
	
	/**
	 * @方法：selsctAssemblyTableLike 生产查询信息
	 * @参数：assemblyTable 用户输入的查询条件
	 * @返回值：查询到生产查询信息
	 */
	@Override
	public List<ThemeTable> selsctThemeTableLike(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("themeTable.selectthemeTableLike", themeTable);
	}
	
	/**
	 * @方法：selectthemeTableuid 生产查询信息
	 * @参数：themeTable 用户输入的查询条件
	 * @返回值：查询到生产查询信息
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
	 * @方法：insertAssemblyTable 添加新的库信息
	 * @参数：assemblyTable 用户添加的生产信息
	 * @返回值：无
	 */
	@Override
	public void insertThemeTable(ThemeTable themeTable) {
		// TODO Auto-generated method stub
		 sqlSession.insert("themeTable.insertthemeTable", themeTable);
	}

	
	
	
	/**
	 * @方法：updateassemblyTable 修改新的库信息
	 * @参数：assemblyTable 用户添加的生产信息
	 * @返回值：无
	 */
	@Override
	public int updateThemeTable(ThemeTable themeTable){
		
		int i=0;
		i=sqlSession.update("themeTable.updatethemeTable", themeTable);
		return i;
		
	}
	
	/**
	 * @方法：updateassemblyTable 修改新的库信息
	 * @参数：assemblyTable 用户添加的生产信息
	 * @返回值：无
	 */
	@Override
	public int updatethemeTabletime(ThemeTable themeTable){
		
		int i=0;
		i=sqlSession.update("themeTable.updatethemeTabletime", themeTable);
		return i;
		
	}
	/**
	 * @方法：deletedateassemblyTable 删除的库信息
	 * @参数：assemblyTable 用户添加的生产信息
	 * @返回值：无
	 */
	@Override
	public int deletedateThemeTable(ThemeTable themeTable ){
		
		int i=0;
		i=sqlSession.delete("themeTable.deletethemeTable", themeTable);
		return i;
		
	}
	
	
	
}
