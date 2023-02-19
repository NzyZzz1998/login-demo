package com.shixi.mapper;

import com.shixi.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {

    //查询所有
    @Select("select * from product")
    List<Product> selectAll();

    @Insert("insert into product values(null,#{brandName},#{name},#{count},#{description},#{status})")
    void add(Product product);

    //根据id查询
    @Select("select * from product where id = #{id}")
    Product selectById(int id);

    //修改
    @Update("update product set brandName = #{brandName},name = #{name},count = #{count},description = #{description},status = #{status} where id = #{id}")
    void update(Product product);

    //删除
    @Delete("delete from product where id = #{id}")
    void delete(int id);
}
