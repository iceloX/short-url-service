package cn.wayok.dao;

import cn.wayok.pojo.ShortUrl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author icelo
 * @date 2021/10/4
 * 定义数据操作层的接口
 */
@Mapper
@Repository
public interface IShortUrlMapper extends BaseMapper<ShortUrl> {

    /**
     * 新增一条短链记录
     */
    @Insert("INSERT INTO shorturl (id,suffix,origin,create_time,modify_time) VALUES(#{shortUrl.id},#{shortUrl.suffix},#{shortUrl.origin},#{shortUrl.createTime},#{shortUrl.modifyTime})")
    int insertOne(@Param("shortUrl") ShortUrl shortUrl);

    /**
     * 根据后缀来查询对应的长链接
     */
    @Select("SELECT * FROM shorturl where suffix = #{suffix}")
    ShortUrl getOne(@Param("suffix") String suffix);


}
