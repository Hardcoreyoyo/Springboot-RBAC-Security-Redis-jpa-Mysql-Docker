package ShopAppJwt.globalException;

public class GlobalExceptionHandler extends RuntimeException {

    private int code ;
    private String message;

    private GlobalExceptionHandler(){}

    public GlobalExceptionHandler(ExceptionType exceptionTypeEnum) {
        this.code = exceptionTypeEnum.getCode();
        this.message = exceptionTypeEnum.getDesc();
    }

    public GlobalExceptionHandler(ExceptionType exceptionTypeEnum,
                                  String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
