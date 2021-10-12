package cn.wayok.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author icelo
 * @date 2021/10/4
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrlDto {

    private String origin;
    private Long currentTime;

}
