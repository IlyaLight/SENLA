package com.senla.client;

import com.senla.api.Command;
import com.senla.api.Response;

public interface IClient {
    Response writeCommand (Command command);

    void connect();

    void stop();
}
