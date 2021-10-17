package cn.wayok.service;

import cn.wayok.pojo.ShortUrl;
import cn.wayok.pojo.dto.ShortUrlDto;
import cn.wayok.pojo.dto.UrlDto;

/**
 * @author icelo
 * @date 2021/10/4
 */
public interface IShortUrlService {

    /**
     * 新增一条短链记录
     * @return
     */
    ShortUrlDto insertOne(UrlDto urlDto) throws InterruptedException;

    /**
     * 根据后缀来查询对应的长链接
     */
    UrlDto getOne(String suffix);


}
