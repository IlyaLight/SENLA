import java.io.Serializable;

public class Response implements Serializable{

    private Object result;


    private boolean exception;


    public Response() {
    }

    public Response(Object result) {
        this.result = result;
    }

    public Response(Object result , boolean exception) {
        this.result = result;
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isException() {
        return exception;
    }

    public void setException(boolean exception) {
        this.exception = exception;
    }
}