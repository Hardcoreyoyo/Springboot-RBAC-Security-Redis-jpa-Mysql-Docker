package ShopAppJwt.globalException;

public enum ExceptionType {

    USER_INPUT_ERROR(400,"Access Denied Or Valid Error ！"),
    SYSTEM_ERROR (500,"Internal Server Error !"),
    OTHER_ERROR(999,"Unknow Error ! Please Inform Tech Support!");

    private String desc;
    private int code;

    ExceptionType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
