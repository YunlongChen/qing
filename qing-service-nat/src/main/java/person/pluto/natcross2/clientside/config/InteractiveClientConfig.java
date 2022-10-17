/*
 * Copyright (c) 2019-2022 YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package person.pluto.natcross2.clientside.config;

import lombok.Data;
import person.pluto.natcross2.api.socketpart.AbsSocketPart;
import person.pluto.natcross2.api.socketpart.SimpleSocketPart;
import person.pluto.natcross2.channel.InteractiveChannel;
import person.pluto.natcross2.channel.SocketChannel;
import person.pluto.natcross2.clientside.ClientControlThread;
import person.pluto.natcross2.clientside.adapter.IClientAdapter;
import person.pluto.natcross2.clientside.adapter.InteractiveSimpleClientAdapter;
import person.pluto.natcross2.clientside.heart.ClientHeartThread;
import person.pluto.natcross2.clientside.heart.IClientHeartThread;
import person.pluto.natcross2.model.InteractiveModel;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 简单的以InteractiveModel为交互模型的配置
 * </p>
 *
 * @author Pluto
 * @since 2020-01-08 16:30:53
 */
@Data
public class InteractiveClientConfig implements IClientConfig<InteractiveModel, InteractiveModel> {

    private String clientServiceIp;
    private Integer clientServicePort;
    private Integer listenServerPort;

    private String destIp;
    private Integer destPort;

    private Charset charset = StandardCharsets.UTF_8;
    private int streamCacheSize = 8196;

    @Override
    public void setDestIpPort(String destIp, Integer destPort) {
        this.destIp = destIp;
        this.destPort = destPort;
    }

    @Override
    public IClientHeartThread newClientHeartThread(ClientControlThread clientControlThread) {
        ClientHeartThread clientHeartThread = new ClientHeartThread(clientControlThread);
        return clientHeartThread;
    }

    @Override
    public IClientAdapter<InteractiveModel, InteractiveModel> newCreateControlAdapter(
            ClientControlThread clientControlThread) {
        InteractiveSimpleClientAdapter simpleClientAdapter = new InteractiveSimpleClientAdapter(clientControlThread,
                this);
        return simpleClientAdapter;
    }

    @Override
    public SocketChannel<? extends InteractiveModel, ? super InteractiveModel> newClientChannel() {
        InteractiveChannel interactiveChannel = new InteractiveChannel();
        try {
            Socket socket = new Socket(this.getClientServiceIp(), this.getClientServicePort());
            interactiveChannel.setSocket(socket);
        } catch (IOException e) {
            return null;
        }

        interactiveChannel.setCharset(charset);

        return interactiveChannel;
    }

    @Override
    public AbsSocketPart newSocketPart(ClientControlThread clientControlThread) {
        SimpleSocketPart simpleSocketPart = new SimpleSocketPart(clientControlThread);
        simpleSocketPart.setStreamCacheSize(this.getStreamCacheSize());
        return simpleSocketPart;
    }

}
