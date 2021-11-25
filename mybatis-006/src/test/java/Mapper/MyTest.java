package Mapper;

import Mapper.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IDutils;
import utils.mybatiutils;

import java.util.Date;
import java.util.UUID;

public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession sqlSession = mybatiutils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("mybatis");
        blog.setAuthor("作者");
        blog.setCreateTime(new Date());
        blog.setViews(99999);
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("JAVA");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("SpringBoot");
        mapper.addBlog(blog);


    }
}
