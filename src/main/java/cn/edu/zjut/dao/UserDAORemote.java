package cn.edu.zjut.dao;

import cn.edu.zjut.ejb.User;

import javax.ejb.Remote;
import java.util.List;

/**
 * @author ：甘明浩
 * @date ：Created in 2020/12/29 16:07
 * @description ：
 */
@Remote
public interface UserDAORemote {
    public List<User> select(String sql);
    public boolean insert(User user);
}
