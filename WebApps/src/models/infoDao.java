package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class infoDao {
	@Autowired
	SqlSessionFactory factory;
	
	public int addPicture(HashMap map) {
		SqlSession session = factory.openSession();
		int r = 0;
		try {
			r = session.insert("info.createOne", map);
			session.commit();
		} catch (Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return r;
	}
	public List<HashMap> readOne(String id) {
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("info.readOne", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	public int updateOne(HashMap map){
		SqlSession sql = factory.openSession();
		int rst = 0;
		try{
			rst = sql.update("info.updateOne",map);
			if(rst == 1)
				sql.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sql.close();
		}
		return rst;
	}
}
