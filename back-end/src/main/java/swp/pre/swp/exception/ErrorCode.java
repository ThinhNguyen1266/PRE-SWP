package swp.pre.swp.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNAUTHENTICATED(4001, "unauthenticated", HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND(4002, "user not found", HttpStatus.NOT_FOUND),
    ;
    int code;
    String message;
    HttpStatusCode httpStatusCode;
}
