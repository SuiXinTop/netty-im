# IM系统设计

## 技术选型

Java、Spring、SpringBoot、Netty、RocketMQ、Mybatis-plus、Mongodb、Redis、Minio、Fultter、Dart

## 功能分析

```
- 用户端
    - 登陆
    - 注册
    - 在线私聊
    - 私聊离线消息
    - 私聊消息漫游
    - 添加好友
    - 删除好友
    - 在线群组消息
    - 部分群组消息漫游
    - 添加群组
    - 添加群组成员
- 管理端
    - 日志查看
    - 消息查看
    - 好友查看
    - 群组查看
```



## 消息格式

**1.聊天请求消息结构**

```
{
   "from": "来源ID",
   "to": "目标ID",
   "cmd":"命令码(11)int类型",
   "createTime": "消息创建时间long类型",
   "msgType": "消息类型int类型(0:text、1:image、2:voice、3:vedio、4:music、5:news)",
   "chatType":"聊天类型int类型(0:未知,1:公聊,2:私聊)",
   "groupId":"群组id仅在chatType为(1)时需要,String类型",
   "content": "内容",
   "extras" : "扩展字段,JSON对象格式如：{'扩展字段名称':'扩展字段value'}"
}
```

请求:COMMAND_CHAT_REQ(11) 响应:COMMAND_CHAT_RESP(12)

**2.鉴权请求消息结构**

```
{
    "cmd":"命令码(3)int类型",
    "token": "校验码"
}
```

请求:COMMAND_AUTH_REQ(3) 响应:COMMAND_AUTH_RESP(4)

**3.握手请求消息结构**

```
{
    "cmd":"命令码(1)int类型",
    "hbyte":"握手1个字节"
}
```

说明:请求:COMMAND_HANDSHAKE_REQ(1) 响应:COMMAND_HANDSHAKE_RESP(2)

**4.登录请求消息结构**

```
{
    "cmd":"命令码(5)int类型",
    "userId": "用户账号",
    "password": "密码",
    "token": "校验码(此字段可与userId、password共存,也可只选一种方式)"
}
```

请求:COMMAND_LOGIN_REQ(5) 响应:COMMAND_LOGIN_RESP(6)

**5.心跳请求消息结构**

```
{
    "cmd":"命令码(13)int类型",
    "hbbyte":"心跳1个字节"
}
```

请求:COMMAND_HEARTBEAT_REQ(13) 响应:COMMAND_HEARTBEAT_REQ(13)

**6.关闭、退出请求消息结构**

```
{
    "cmd":"命令码(14)int类型",
    "userId":"用户ID"
}
```

请求:COMMAND_CLOSE_REQ(14) 响应:无

**7.获取用户信息请求消息结构**

```
{
     "cmd":"命令码(17)int类型",
     "userId":"用户id(必填项)",
     "type":"获取类型(0:所有在线用户,1:所有离线线用户,2:所有用户[在线+离线])"
}
```

请求:COMMAND_GET_USER_REQ(17) 响应:COMMAND_GET_USER_RESP(18)

**8.获取持久化聊天消息(离线+历史+漫游)请求结构**

```
{
     "cmd":"命令码(19)int类型",
     "fromUserId":"消息发送用户id(此字段必须与userId一起使用,获取双方聊天消息),非必填",
     "userId":"当前用户id(必填字段),当只有此字段时,type必须为0，意思是获取当前用户所有离线消息(好友+群组)",
     "groupId":"群组id(此字段必须与userId一起使用,获取当前用户指定群组聊天消息),非必填",
     "beginTime":"消息区间开始时间Date毫秒数double类型,非必填",
     "endTime":"消息区间结束时间Date毫秒数double类型,非必填",
     "offset":"分页偏移量int类型，类似Limit 0,10 中的0,非必填",
     "count":"显示消息数量,类似Limit 0,10 中的10,非必填",
     "type":"消息类型(0:离线消息,1:历史消息)"
}
```

请求:COMMAND_GET_MESSAGE_REQ(19) 响应:COMMAND_GET_MESSAGE_RESP(20)