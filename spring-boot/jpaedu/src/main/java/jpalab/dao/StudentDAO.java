package jpalab.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jpalab.entity.Student;

import java.util.Collections;
import java.util.List;

public class StudentDAO {
    private EntityManagerFactory factory;

    public StudentDAO() {
        super();
        factory = Persistence.createEntityManagerFactory("emptest");
    }

    public boolean insertStudent(Student vo) {
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(vo);
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        em.close();
        return result;
    }

    public List<Student> getAllStudent() {
        EntityManager em = factory.createEntityManager();
        try {
            TypedQuery<Student> q = em.createQuery("select t from Student t", Student.class);
            List<Student> list = q.getResultList();
            return list != null ? list : Collections.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            em.close();
        }
    }

    public Student getScore(String name) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Student.class, name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public boolean updateStudent(Student entity) {
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Student oldVo = em.find(Student.class, entity.getName());
            System.out.println(oldVo.getName());
            oldVo.setName(entity.getName());
            oldVo.setScore(entity.getScore());
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        em.close();
        return result;
    }

    public boolean deleteStudent(String name) {
        boolean result = true;
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Student vo = em.find(Student.class, name);
            em.remove(vo);
            em.getTransaction().commit();
        } catch (Exception e) {
            result = false;
        }
        em.close();
        return result;
    }

    public void close() {
        if (factory != null)
            factory.close();
    }
}
