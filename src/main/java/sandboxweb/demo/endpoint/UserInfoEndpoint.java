package sandboxweb.demo.endpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoEndpoint {

    @GetMapping("/userinfo")
    public UserInfoResponse userInfo() {
        UserInfoResponse res = new UserInfoResponse(177L, "FukuokaTaro", 25, "windows");
        return res;
    }

    @GetMapping("/userinfo2")
    public ResponseEntity<UserInfoResponse> userInfo2() {
        UserInfoResponse res = new UserInfoResponse(8354L, "FFG Taro", null, "mac");
        return ResponseEntity.ok(res);
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
