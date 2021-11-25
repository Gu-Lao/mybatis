package Mapper;

import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

}
