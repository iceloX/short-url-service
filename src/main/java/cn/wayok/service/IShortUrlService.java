package cn.wayok.service;

import cn.wayok.pojo.ShortUrl;
import cn.wayok.pojo.dto.UrlDto;

/**
 * @author icelo
 * @date 2021/10/4
 */
public interface IShortUrlService {

    /**
     * 新增一条短链记录
     */
    int insertOne(UrlDto urlDto) throws InterruptedException;

    /**
     * 根据后缀来查询对应的长链接
     */
    ShortUrl getOne(String suffix);




}
