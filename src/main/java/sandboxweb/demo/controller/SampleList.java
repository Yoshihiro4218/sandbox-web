package sandboxweb.demo.controller;

import com.google.common.collect.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static sandboxweb.demo.controller.SampleList.SampleData.Gender.FEMALE;
import static sandboxweb.demo.controller.SampleList.SampleData.Gender.MALE;
import static sandboxweb.demo.controller.SampleList.SampleData.Result.OK;

@Controller
@RequestMapping("/list")
@Slf4j
public class SampleList {
    private static final Map<Integer, SampleData> sampleDataMap = ImmutableMap.of(1, SampleData.builder()
                                                                                               .id(1)
                                                                                               .name("堀北真希")
                                                                                               .gender(FEMALE)
                                                                                               .birthDate("19881006")
                                                                                               .build(),
                                                                                  2, SampleData.builder()
                                                                                               .id(2)
                                                                                               .name("木村佳乃")
                                                                                               .gender(FEMALE)
                                                                                               .birthDate("19760410")
                                                                                               .build(),
                                                                                  3, SampleData.builder()
                                                                                               .id(3)
                                                                                               .name("水樹奈々")
                                                                                               .gender(FEMALE)
                                                                                               .birthDate("19800121")
                                                                                               .build(),
                                                                                  4, SampleData.builder()
                                                                                               .id(4)
                                                                                               .name("阿部寛")
                                                                                               .gender(MALE)
                                                                                               .birthDate("19640622")
                                                                                               .result(OK)
                                                                                               .build());

    @GetMapping("")
    public String index(Model model) {
        log.info("Samples={}", sampleDataMap.values());
        model.addAttribute("samples", sampleDataMap.values());
        return "list/index";
    }

    @Data
    @Builder
    static class SampleData {
        int id;
        @NonNull
        private String name;
        @NonNull
        private Gender gender;
        @NonNull
        private String birthDate;
        private Result result;

        @AllArgsConstructor
        @Getter
        public enum Gender {
            MALE(0, "男"),
            FEMALE(1, "女");

            private final int code;
            private final String label;
        }

        @AllArgsConstructor
        @Getter
        public enum Result {
            OK(0, "合格"),
            NG(1, "不合格");

            private final int code;
            private final String label;
        }
    }
}
