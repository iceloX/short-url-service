## 短链生成后端服务

基于Mysql和springboot的短链生成服务

- 短链Demo<a href="https://u.wayok.cn">Wayok's 短链服务</a>

### 如何使用(使用前默认你了解某些知识)

0、将sql脚本在数据库部署起来

1、修改`application.yaml`的配置文件

> - 修改port端口号
>
> - 数据库连接信息
> - 未找到后缀信息配置转跳的网站
> - 提供服务的
> - 前端跳转短链的根域名

```yaml
server:
  port: 18880

# 数据库
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/short_url
    username: root
    password: root
    driver-class-name: com.mysql.cj.jdbc.Driver
  # 404异常配置
  web:
    resources:
      add-mappings: false
  mvc:
    throw-exception-if-no-handler-found: false

# 未找到后缀信息配置转跳的网站
notfound:
  url: https://google.com

# 设置前端跳转短链的根域名
root:
  url: https://u.wayok.cn
```

2、将本项目打成jar包，可使用下面指令跑该服务

```cmd
java -jar #你的jar包名字
```

此时你可以通过postman等工具测试，或者部署前端测试

> 1、通过过postman向你部署的地址通过post请求发送json数据

```
{
	"origin":"你的原始地址"
}
```

> 2、部署前端，详见这个开源库

<a href="https://github.com/iceloX/short-url-web">short-url-web</a>

---

### 功能

- [x] 生成永不重复的六位短链
- [ ] 短链生命周期控制
- [ ] 添加更多的短链生成方式
- [ ] 短链自定义长度



测试（当数据库数据较多时的查询速度）：

- [ ] 一万条数据
- [ ] 十万条数据
- [ ] 百万条数据