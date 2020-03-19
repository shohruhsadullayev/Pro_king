package dao;

import config.MySessionFactory;
import entity.StudentEntity;
import org.hibernate.Session;

import java.util.List;

public class StudentDao {

    public static Session session = MySessionFactory.getSession();

    public static void saveProduct(StudentEntity studentEntity){
        session.beginTransaction();
        session.save(studentEntity);
        session.getTransaction().commit();

    }
    public StudentEntity getProductEntity(Long id){

        return (StudentEntity) session.get(StudentEntity.class, id);
    }

    public void deleteProduct(StudentEntity entity){
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public List<StudentEntity> listStudents(){
        return session.createQuery("SELECT a FROM StudentEntity a").list();
    }





}
/*
public class StudentDao {






}*/
