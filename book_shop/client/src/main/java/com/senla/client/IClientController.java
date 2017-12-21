package com.senla.client;

import com.senla.api.IController;

public interface IClientController extends IController{
    IClient getClient();

    void setClient(IClient client);

    void stopClient();
}
