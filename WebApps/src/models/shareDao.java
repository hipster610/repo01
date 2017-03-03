package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class shareDao {
	@Autowired
	DataSource ds;
	@Autowired
	SqlSessionFactory factory;
	
	public int createOne(HashMap map){
		int rst = 0;
		SqlSession sql = factory.openSession();
		try {
			rst = sql.insert("share.createOne", map);
			if (rst == 1)
				sql.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sql.close();
		}
		return rst;
	}
	public List<HashMap> readAll() {
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("share.read");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	public HashMap readOne(int num) {
		SqlSession session = factory.openSession();
		try {
			return session.selectOne("share.readOne", num);
		} finally {
			session.close();
		}
	}

	public int increaseCount(int num) {
		SqlSession session = factory.openSession();
		try {
			int rst = session.update("share.increaseCount", num);
			if(rst !=0)
				session.commit();
			return rst;
		} finally {
			session.close();
		}
	}
}

