package cn.wayok.service.impl;

import cn.wayok.core.impl.CreateSuffixByTime;
import cn.wayok.dao.IShortUrlMapper;
import cn.wayok.enums.EntityId;
import cn.wayok.pojo.ShortUrl;
import cn.wayok.pojo.dto.ShortUrlDto;
import cn.wayok.pojo.dto.UrlDto;
import cn.wayok.service.IShortUrlService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author icelo
 * @date 2021/10/4
 */
@Service
public class ShortUrlServiceImpl implements IShortUrlService {

    private IShortUrlMapper shortUrlMapper;

    @Value(value = "${notfound.url}")
    private String notFoundUrl;

    @Value(value = "${root.url}")
    private String rootUrl;

    private static final String URL_SPLIT = "/";


    @Autowired
    public void setShortUrlMapper(IShortUrlMapper shortUrlMapper) {
        this.shortUrlMapper = shortUrlMapper;
    }

    @Override
    public ShortUrlDto insertOne(UrlDto urlDto) throws InterruptedException {
        // 逻辑实现
        CreateSuffixByTime createSuffixByTime = new CreateSuffixByTime();
        String suffix = createSuffixByTime.getSuffix();
        System.out.println(suffix);
        ShortUrl shortUrl = ShortUrl.builder()
            .id(EntityId.SHORT_URL.id())
            .origin(urlDto.getOrigin())
            .suffix(suffix)
            .createTime(new Date())
            .modifyTime(new Date())
            .build();
        shortUrlMapper.insertOne(shortUrl);
        return ShortUrlDto.builder()
            .shortUrl(rootUrl + URL_SPLIT + suffix)
            .build();
    }

    @Override
    public UrlDto getOne(String suffix) {
        ShortUrl one = shortUrlMapper.getOne(suffix);
        // 在数据库未查询到后缀转跳到指令页面
        if (one == null) {
            one = new ShortUrl();
            one.setOrigin(notFoundUrl);
        }
        return UrlDto.builder()
            .currentTime(new Date().getTime())
            .origin(one.getOrigin())
            .build();
    }

}
