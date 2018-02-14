package io.sixhours.rx;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * Channel initializer for configuring channel pipeline with handlers.
 */
class HttpInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline()
                .addLast(new HttpServerCodec())
                .addLast(new HttpServerExpectContinueHandler())
                .addLast(new HttpObjectAggregator(1_024 * 100))
                .addLast( new HttpHandler());
    }
}
