package ShopAppJwt.globalException;

import ShopAppJwt.mapper.ResponseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.mail.MessagingException;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class ExceptionIndividual {

    @ExceptionHandler(RuntimeException.class)
    public ResponseMapper exception(RuntimeException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "Unknow Error !");
        return ResponseMapper.error(new GlobalExceptionHandler(
                ExceptionType.OTHER_ERROR));
    }

    @ExceptionHandler(Exception.class)
    public ResponseMapper exception(Exception e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "Unknow Error !");
        return ResponseMapper.error(new GlobalExceptionHandler(
                ExceptionType.OTHER_ERROR));
    }

    @ExceptionHandler(GlobalExceptionHandler.class)
    public ResponseMapper SYSTEM_ERROR(GlobalExceptionHandler e) {
        if(e.getCode() == ExceptionType.SYSTEM_ERROR.getCode()){
            log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "500 Internal Server Error !");
        }
        return ResponseMapper.error(e);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseMapper AuthException(AuthenticationException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "Unauthorized !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Unauthorized ， Please Try Again Later !");
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseMapper NoAuthAccessDenied(AccessDeniedException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "request access deniend after login !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Access Denied ， Please Try Again Later !");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseMapper ValidException(MethodArgumentNotValidException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "Valid Error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Valid Error ， Please Try Again Later !");
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseMapper HeaderException(MissingRequestHeaderException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "Header Valid Error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Header Valid Error ， Please Try Again Later !");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseMapper StringBlankException(ConstraintViolationException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "String Blank  Error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "String Blank Error ， Please Try Again Later !");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseMapper MissingDataException(HttpMessageNotReadableException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + " :"+ e.getMessage() + " - " + "Missing Data !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Missing Data ， Valid Error ， Please Try Again Later !");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseMapper RequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "Request Method Not Supported !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Request Method Not Supported， Please Try Again Later !");
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseMapper PageNotFoundException(HttpClientErrorException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "Page Not Found !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Page Not Found !");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseMapper MissingServletRequestParamException(MissingServletRequestParameterException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "Missing Data Error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Missing Data ， Valid Error ， Please Try Again Later !");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseMapper NullPException(NullPointerException e) {
        log.warn(Arrays.toString(e.getStackTrace()) +
                e.getClass() + " :"+ e.getMessage() + " - " + "Null  Error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Missing Data ， Valid Error ， Please Try Again Later !");
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseMapper SendMailFailException(MessagingException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "Send Mail Fail !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Send Mail Fail， Please Try Again Later !");
    }

    @ExceptionHandler(MailAuthenticationException.class)
    public ResponseMapper MailServerSettingErrorException(MailAuthenticationException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "Mail server setting error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Send Mail Fail， Please Try Again Later !");
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseMapper ArithmeticExceptionToException(ArithmeticException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "Arithmetic error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Arithmetic Error， Please Try Again Later !");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseMapper BasicNoHandlerFoundException(NoHandlerFoundException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "NoHandlerFoundException error !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Not Found， Please Try Again Later !");
    }

    @ExceptionHandler(IOException.class)
    public ResponseMapper jIOException(IOException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "Broken pipe from client !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "break from client");
    }

    @ExceptionHandler(SocketException.class)
    public ResponseMapper jSocketException(SocketException e) {
        log.warn(Arrays.toString(e.getStackTrace()) + e.getClass() + e.getClass() + " :"+ e.getMessage() + " - " + "SocketException Please Try Again Later !");
        return ResponseMapper.error(
                ExceptionType.USER_INPUT_ERROR,
                "Please Try Again Later !");
    }



}
