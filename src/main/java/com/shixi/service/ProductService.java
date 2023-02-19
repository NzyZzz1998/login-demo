package com.shixi.service;

import com.shixi.mapper.ProductMapper;
import com.shixi.pojo.Product;
import com.shixi.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProductService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    //查询所有
    public List<Product> selectAll(){

        SqlSession sqlSession = factory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        List<Product> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }

    //添加
    public void add(Product product){

        SqlSession sqlSession = factory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        mapper.add(product);


        sqlSession.commit();
        sqlSession.close();
    }

    //根据id查询
    public Product selectById(int id){

        SqlSession sqlSession = factory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        Product product = mapper.selectById(id);

        sqlSession.close();
        return product;
    }

    //修改
    public void update(Product product){

        SqlSession sqlSession = factory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        mapper.update(product);

        sqlSession.commit();
        sqlSession.close();

    }

    //删除
    public void delete(int id){

        SqlSession sqlSession = factory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

        mapper.delete(id);

        sqlSession.commit();
        sqlSession.close();
    }
}
