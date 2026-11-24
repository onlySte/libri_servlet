package it.exolab.dao;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.LibroMapper;
import it.exolab.model.Libro;
import it.exolab.util.MyBatisUtils;

public class LibroDao {

	public void insert(Libro model) {
		
		SqlSession session = MyBatisUtils.getSqlSessionFactory().openSession();
		
		try {
			LibroMapper mapper = session.getMapper(LibroMapper.class);
			mapper.insert(model);
			session.commit();
		}
		catch(Exception e) {
			session.rollback();
		}
		finally {
			session.close();
		}
	}// insert
	
	
}
