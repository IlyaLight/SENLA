package com.senla.server;

import com.senla.api.Command;
import com.senla.api.IController;
import com.senla.api.Response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteCommandUtil {

    private static final String EXCEPTION = "Exception: ";

    private static Logger log = Logger.getLogger(ExecuteCommandUtil.class.getName());

    public static Response execute(Command command, IController controller){
        Class[] paramType = null;
        if (command.getParams() != null) {
            int length = command.getParams().length;
            paramType = new Class[length];
            while (length > 0) {
                length--;
                paramType[length] = command.getParams()[length].getClass();
            }
        }
        Class clazz = controller.getClass();
        try {
            Method method = clazz.getMethod(command.getMethodName(), paramType);
            try {
                return new Response(method.invoke(controller, command.getParams()));
            } catch (InvocationTargetException e){
                return new Response(e, true);
            } catch (IllegalAccessException e){
                log.log(Level.SEVERE, EXCEPTION, e);
                throw new RuntimeException(e);
            }
        } catch (NoSuchMethodException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }
}
