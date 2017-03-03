package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDao {

	
	@Autowired
	SqlSessionFactory factory;
	
	public int addLogin(String id){
		SqlSession session = factory.openSession();
		int r = 0;
		try{
			r = session.insert("member.loginLog", id);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		return r;
	}
	public int addMember(HashMap map) {
		SqlSession session = factory.openSession();
		int r = 0;
		try {
			r = session.insert("member.insert", map);
			session.commit();
		} catch (Exception e){
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return r;
	}
	public boolean checkMember(Map map) {
		boolean flag = false;
		SqlSession session = factory.openSession();
		try {
			// select mapper의 resultType은 데이터 한줄을 바꿀 객체 
			// select 를 사용할때 한줄이 나오면 selectOne ==> resultType
			//                    여러줄이 나오면 selectList ==> List<resultType> 
			int r = session.selectOne("member.checkCountOne", map);
			if(r==1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
	}
	public List<HashMap> ageGroup() {
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("member.ageGroup");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	public List<HashMap> genderGroup() {
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try {
			list = sql.selectList("member.genderGroup");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}
	public List<HashMap> genderLogin(){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try{
			list = sql.selectList("member.genderLogin");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sql.close();
		}
		return list;
	}
	public List<HashMap> ageLogin(){
		List<HashMap> list = new ArrayList<>();
		SqlSession sql = factory.openSession();
		try{
			list = sql.selectList("member.ageLogin");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sql.close();
		}
		return list;
	}
}
