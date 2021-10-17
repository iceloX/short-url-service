package cn.wayok.common;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author icelo
 * @date 2021/10/15
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuccessReturnDto {

    private  Integer code;
    private  String msg;
    private Object data;

}
