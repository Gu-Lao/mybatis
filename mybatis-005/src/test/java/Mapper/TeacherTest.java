package Mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import utils.mybatiutils;

import java.util.List;

public class TeacherTest {
    @Test
    public void test1(){
        SqlSession sqlSession = mybatiutils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);

        System.out.println(teacher);

        sqlSession.close();
    }

}
