package top.sillyfan.auxiliaryplatform.dao.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T, I, E> {

    int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(I id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(I id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
