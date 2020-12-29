package cn.edu.zjut.dao;

import cn.edu.zjut.ejb.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * @author ：甘明浩
 * @date ：Created in 2020/12/29 16:08
 * @description ：
 */
@Stateless
public class UserDAO implements UserDAORemote {
    @PersistenceContext(type= PersistenceContextType.EXTENDED, unitName="userpu")
    EntityManager em;
    public UserDAO() {
    }
    public boolean insert(User user){
        try{
            em.persist(user);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<User> select(String sql){
        List< User> userlist=null;
        try{
            Query q=em.createQuery(sql);
            userlist=(List<User>)q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            return userlist;
        }
        return userlist;
    }
}
