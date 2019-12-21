package sandboxweb.demo.endpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class UserInfoEndpoint {

    @GetMapping("/userinfo")
    public UserInfoResponse userInfo(HttpServletRequest request,
                                     HttpServletResponse response) {
        Cookie requestCookie1 = request.getCookies()[0];
        Cookie requestCookie2 = request.getCookies()[1];
        log.info("[INFO]Cookie={}", requestCookie1.getName() + ":" + requestCookie1.getValue());
        log.info("[INFO]Cookie={}", requestCookie2.getName() + ":" + requestCookie2.getValue());
        UserInfoResponse res = new UserInfoResponse(177L, "FukuokaTaro", 25, "windows");
        Cookie cookie = new Cookie("OPBS", "FukuokaFinancialGroup");
        cookie.setMaxAge(100);
        response.addCookie(cookie);
        return res;
    }

    @GetMapping("/userinfo2")
    public ResponseEntity<UserInfoResponse> userInfo2() {
        UserInfoResponse res = new UserInfoResponse(8354L, "FFG Taro", null, "mac");
        return ResponseEntity.ok(res);
    }

    @GetMapping("/userinfo3")
    public ResponseEntity userInfo3() {
        return new ResponseEntity(HttpStatus.NOT_MODIFIED);
    }

    @Value
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private static class UserInfoResponse {
        private long id;
        private String name;
        private Integer age;
        private String machine;
    }
}
