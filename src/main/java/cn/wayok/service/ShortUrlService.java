package cn.wayok.service;


import cn.wayok.dao.ShortUrlDao;
import cn.wayok.pojo.ShortUrl;

/**
 * service
 */
public class ShortUrlService {
    ShortUrlDao dao = new ShortUrlDao();

    /**
     * 插入短连接
     * @param shortUrl 实体
     */
    public void setShortUrl(ShortUrl shortUrl) {
        dao.setShortUrl(shortUrl);
    }

    /**
     * 解析短链接
     * @param shortUrl 短链接
     * @return
     */
    public String getLongUrl(String shortUrl) {
        return dao.getLongUrl(shortUrl);
    }
}
