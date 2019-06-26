package spring.dao;

import org.apache.ibatis.annotations.Select;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:24:41.
 */

public interface CityDao {
    @Select("select * from city")
    String query();
}
