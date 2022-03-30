package ShopAppJwt.mapper;

import ShopAppJwt.globalException.ExceptionType;
import ShopAppJwt.globalException.GlobalExceptionHandler;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMapper {

    private boolean Status;
    private int code;
    private String message;
    private Object data;

    private ResponseMapper(){}

    public static ResponseMapper error(GlobalExceptionHandler e){
        ResponseMapper responseMapper = new ResponseMapper();
        responseMapper.setStatus(false);
        responseMapper.setCode(e.getCode());
        responseMapper.setMessage(e.getMessage());
        return responseMapper;
    }

    // 系統無異常 但不符合自定義條件 情境
    public static ResponseMapper error(ExceptionType e, String errorMessage) {
        ResponseMapper response = new ResponseMapper();
        response.setStatus(false);
        response.setCode(e.getCode());
        response.setMessage(errorMessage);
        return response;
    }

    public static ResponseMapper successStatus() {
        ResponseMapper response = new ResponseMapper();
        response.setStatus(true);
        response.setCode(200);
        response.setMessage("success");
        return response;
    }

    public static ResponseMapper successData(Object data) {
        ResponseMapper response = new ResponseMapper();
        response.setStatus(true);
        response.setCode(200);
        response.setMessage("success");
        response.setData(data);
        return response;
    }

    public static ResponseMapper successDataMessage(Object data, String message) {
        ResponseMapper response = new ResponseMapper();
        response.setStatus(true);
        response.setCode(200);
        response.setMessage(message);
        response.setData(data);
        return response;
    }


    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
