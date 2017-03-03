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
public class listDao {
	@Autowired
	DataSource ds;
	@Autowired
	SqlSessionFactory factory;
	
	public int createOne(HashMap map) {
		int rst = 0;
		SqlSession sql = factory.openSession();
		try {
			rst = sql.insert("list.createOne", map);
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
			list = sql.selectList("list.readAll");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	public int getArticlesCount() {
		int cnt = 0;
		SqlSession sql = factory.openSession();
		try {
			cnt = sql.selectOne("list.cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return cnt;
	}
	public List<HashMap> getSelectFreeBoard(int num){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("list.selectList", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	public List<HashMap> getSelectPage(HashMap map){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("list.freeboardList", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	public int update(HashMap map){
		SqlSession sql = factory.openSession();
		int result = 0;
		try{
			result = sql.update("list.update", map);
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sql.close();
		}
		return result;
	}
}
