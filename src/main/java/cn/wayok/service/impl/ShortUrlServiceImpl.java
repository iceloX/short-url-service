package cn.wayok.service.impl;

import cn.wayok.dao.IShortUrlMapper;
import cn.wayok.enums.EntityId;
import cn.wayok.pojo.ShortUrl;
import cn.wayok.pojo.dto.UrlDto;
import cn.wayok.service.IShortUrlService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author icelo
 * @date 2021/10/4
 */
@Service
public class ShortUrlServiceImpl implements IShortUrlService {

    private IShortUrlMapper shortUrlMapper;

    @Autowired
    public void setShortUrlMapper(IShortUrlMapper shortUrlMapper) {
        this.shortUrlMapper = shortUrlMapper;
    }

    @Override
    public int insertOne(UrlDto urlDto) {
        // 逻辑实现
        ShortUrl shortUrl = ShortUrl.builder()
            .id(EntityId.SHORT_URL.id())
            .origin(urlDto.getOrigin())
            .suffix("rrwerw3")
            .createTime(new Date())
            .modifyTime(new Date())
            .build();
        return shortUrlMapper.insertOne(shortUrl);
    }

    @Override
    public ShortUrl getOne(String suffix) {
        return shortUrlMapper.getOne(suffix);
    }
}
