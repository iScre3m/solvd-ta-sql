package db.parsers.mybatis;

import db.models.Speciality;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SpecialityDAO implements ISpecialityMapper{
    @Override
    public void insert(Speciality speciality) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ISpecialityMapper.class).insert(speciality);
        session.commit();
        session.close();
    }

    @Override
    public void update(Speciality speciality) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ISpecialityMapper.class).update(speciality);
        session.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ISpecialityMapper.class).delete(id);
        session.commit();
        session.close();
    }

    @Override
    public Speciality getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        Speciality speciality = session.getMapper(ISpecialityMapper.class).getById(id);
        session.commit();
        session.close();
        return speciality;
    }

    @Override
    public List<Speciality> getAll() {
        SqlSession session = MyBatisFactory.getSession();
        List<Speciality> specialities = session.getMapper(ISpecialityMapper.class).getAll();
        session.commit();
        session.close();
        return specialities;
    }
}
