# 七号商铺shopNO.7

七号商铺可以分为两部分：后台管理系统、前台门户系统。

- 后台管理：
  - 后台系统主要包含以下功能：
    - 商品管理，包括商品分类、品牌、商品规格等信息的管理
    - 销售管理，包括订单统计、订单退款处理、促销活动生成等
    - 用户管理，包括用户控制、冻结、解锁等
    - 权限管理，整个网站的权限控制，采用JWT鉴权方案，对用户及API进行权限控制
    - 统计，各种数据的统计分析展示
  - 后台系统会采用前后端分离开发，而且整个后台管理系统会使用Vue.js框架搭建出单页应用（SPA）。
- 前台门户
  - 前台门户面向的是客户，包含与客户交互的一切功能。例如：
    - 搜索商品
    - 加入购物车
    - 下单
    - 评价商品等等
  - 前台系统我们会使用Thymeleaf模板引擎技术来完成页面开发。出于SEO优化的考虑，我们将不采用单页应用。

无论是前台还是后台系统，都共享相同的微服务集群，包括：

- 商品微服务：商品及商品分类、品牌、库存等的服务
- 搜索微服务：实现搜索功能
- 订单微服务：实现订单相关
- 购物车微服务：实现购物车相关功能
- 用户中心：用户的登录注册等功能
          - Eureka注册中心
          - Zuul网关服务

项目采坑点：
20191109
1、添加log4j日志时，需要排除spring-boot-starter-web的依赖冲突问题，依赖引入时<scope>compile</scope>参数不可少
本地spring-boot是main方法启动：compile,测试环境：test

20191111
1、跨域问题
浏览器对JavaScript的同源策略限制
跨域问题是对ajax请求的一种安全限制：一个页面发起异步请求，只能是与当前页面域名相同的路径，这能有效的阻止跨跨域攻击
跨域原因：
①域名不同
②域名相同，端口不同
③二级域名不同

2、解决跨越问题的三种方式
①jsonP()
②nginx反向代理
③CORS(CROSS-ORIGIN RESOURCE SHARING)跨域资源共享技术

3、axios处理请求体的原则会根据请求数据的格式来定：
①如果请求体是对象，会转成json发送
②如果请求体是string,会做为普通表单发送，需要自己保证键值对

