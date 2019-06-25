package spring.dao;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author 石亚宁
 * @version 1.0.0.1
 * @description:
 * @date 2019年06月13日 17:24:41.
 */
@MapperScan
public interface CityDao {
    @Select("select * from city")
    String query();
}
