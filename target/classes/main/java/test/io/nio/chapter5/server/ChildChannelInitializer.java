package test.io.nio.chapter5.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class ChildChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
        ch.pipeline().addLast(new StringDecoder());
        ch.pipeline().addLast(new EchoServerHandler());
    }

}
