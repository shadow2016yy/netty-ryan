package com.netty.ryan.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;


/**
 * Created by Ryan on 2019/1/7.
 */
public class TimeClientHandler extends ChannelHandlerAdapter {
    private final ByteBuf firstMessage;
    public TimeClientHandler(){
        byte[] bytes = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(bytes.length);
        firstMessage.writeBytes(bytes);
    }

    public void channelActive(ChannelHandlerContext ctx){
        ctx.writeAndFlush(firstMessage);
    }

    public void  channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String s = new String(req, "UTF-8");
        System.out.println("Now is :"+s);
    }
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable casue){
        ctx.close();
    }

}
