package com.suixin.server.util;

import com.alibaba.fastjson.JSON;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class WebSocketResult {
   public static TextWebSocketFrame trans(Object object){
       return new TextWebSocketFrame(JSON.toJSONString(object));
   }
}
