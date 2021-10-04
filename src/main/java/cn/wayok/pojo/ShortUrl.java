package cn.wayok.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author icelo
 * @date 2021/10/3
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortUrl {

    /**
     * 编号
     * 使用MD5加密和uuid生成密码
     **/
    private String id;
    /**
     * 生成的后缀字符串
     */
    private String suffix;

    /**
     * 原链接
     */
    private String origin;
    /**
     * 生成时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

    public void setLongUrl(String longUrl) {
    }
}
