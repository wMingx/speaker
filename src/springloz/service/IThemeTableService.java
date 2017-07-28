package springloz.service;

import java.util.List;

import springloz.ThemeTable;

public interface IThemeTableService {

	List <ThemeTable> selsctThemeTable(ThemeTable themeTable);
	
	List <ThemeTable> selsctThemeTableLike(ThemeTable themeTable);
	
	List <ThemeTable> selectthemeTableuid(ThemeTable themeTable);
	
	int selectthemeTablecount(ThemeTable themeTable);
	
	int selectthemeTableuidcount(ThemeTable themeTable);	
	
	void insertThemeTable(ThemeTable themeTable);
	
	int updateThemeTable(ThemeTable themeTable);
	
	int updatethemeTabletime(ThemeTable themeTable);
	
	int deletedateThemeTable(ThemeTable themeTable);
}
