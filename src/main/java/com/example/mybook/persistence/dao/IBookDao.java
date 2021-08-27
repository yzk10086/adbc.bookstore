package com.example.mybook.persistence.dao;

import com.example.mybook.persistence.entity.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface IBookDao {

    Book getBookById(int id);

//----------------------------------------------------    1    --------------------------------------------------------

    @Select("select * from books where is_hot = 1")
    @Results(id = "bookMapNew",value = {
            @Result(column = "id", property = "id",id = true),
            @Result(column = "title", property = "title"),
            @Result(column = "author", property = "author"),
            @Result(column = "price", property = "price",jdbcType = JdbcType.DOUBLE),
            @Result(column = "discount", property = "discount",jdbcType = JdbcType.FLOAT),
            @Result(column = "book_concern", property = "bookConcern"),
            @Result(column = "img", property = "imgUrl"),
            @Result(column = "img_big", property = "bigImgUrl"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "brief", property = "brief"),
            @Result(column = "inventory", property = "inventory"),
    })
    List<Book> getBookByHot();

//----------------------------------------------------    2    --------------------------------------------------------

    @Select("select * from books where is_new = 1")
    @ResultMap("bookMapNew")
    List<Book> getBookByNew();

//----------------------------------------------------    3    --------------------------------------------------------

    @Select("select * from books where category_id = #{id}")
    @ResultMap("bookMapNew")
    List<Book> getBookByCategory(int id);

//----------------------------------------------------    4    --------------------------------------------------------

    @Results(id = "bookDetailMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "imgUrl", column = "img"),
            @Result(property = "bigImgUrl", column = "img_Big"),
            @Result(property = "newness", column = "is_new"),
            @Result(property = "hot", column = "is_hot"),
            @Result(property = "category", column = "category_id", one = @One
                    (select = "com.example.mybook.persistence.dao.IBookDao.getBookCategory",
                            fetchType = FetchType.EAGER))                   //这里获得category_id对应的category类目
    })
    @Select("select * from books where id = #{id}")
    BookDetail getBookDetailById(int id);

//----------------------------------------------------    4    --------------------------------------------------------

    @Results(id = "categoryMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "parentId",column = "parent_id"),
//            @Result(property = "children", column = "id", many = @Many
//                    (select = "com.example.mybook.persistence.dao.IBookDao.getChildCategory",
//                            fetchType = FetchType.EAGER))                                         不需要children所以注释了
    })
    @Select("select * from category where id = #{category_id}")
    Category getBookCategory(int category_id);                      //这里实现：通过传入的book表参数category_id获得category内容
                                                                    //注意这里注释了实现递归的部分,所以不能在getAllCategory()直接复用

//----------------------------------------------------    5    --------------------------------------------------------

    @Select("select * from comment where book_id = #{book_id}")
    Comment[] getBookComment(int book_id);                                  //这里通过图书id获得对应的评论

//----------------------------------------------------    6    --------------------------------------------------------

    @Results(id = "bookMap", value = {
            @Result(id = true, property = "id", column="id"),
            @Result(property = "imgUrl", column="img"),
            @Result(property = "bigImgUrl", column="img_Big")
    })
    @Select("select * from books where category_id = #{categoryId} ")
    List<Book> getCategoryBooksByPage(int categoryId, @Param("pageNum")int pageNum, @Param("pageSize")int pageSize);

//----------------------------------------------------    7    --------------------------------------------------------

    @ResultMap(value = {"bookMap"})
    @Select("select * from books where title like '%${wd}%'")
    List<Book> getBooksByWord(String wd, int pageNum, int pageSize);

//----------------------------------------------------    8    --------------------------------------------------------

    @Results(id = "allCategoryMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "children", column = "id", many = @Many
                    (select = "com.example.mybook.persistence.dao.IBookDao.getChildCategory",
                            fetchType = FetchType.EAGER))
    })
    @Select("select * from category where ISNULL(parent_id)")        //从parentId为NULL的父母节点开始查找
    Category[] getAllCategory();                                     //并利用getChildCategory方法实现子节点的查找

//----------------------------------------------------    8    --------------------------------------------------------

    @ResultMap(value={"allCategoryMap"})                            //通过复用allCategoryMap实现子节点递归查找
    @Select("select * from category where parent_id=#{id}")
    Category[] getChildCategory(int id);                            //这里实现：通过传入的形参id获得children的内容

//----------------------------------------------------    9    --------------------------------------------------------

    @Results(id="userMap",value = {
            @Result(id = true, property = "id", column = "id")
    })
    @Select("select * from users where username = #{username} and password = #{password}")
    User getLoginUser(User user);

//----------------------------------------------------    10    --------------------------------------------------------

    @Insert("Insert ignore into users(username,password,mobile) values(#{username},#{password},#{mobile})")
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    int registerUser(User user);

//---------------------------------------------------------------------------------------------------------------------

}
