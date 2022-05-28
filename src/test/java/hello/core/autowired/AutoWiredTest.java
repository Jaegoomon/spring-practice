package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNullBean1(Member member) {
            System.out.println("setNullBean1 = " + member);
        }

        @Autowired
        public void setNullBean2(@Nullable Member member) {
            System.out.println("setNullBean2 = " + member);
        }

        @Autowired
        public void setNullBean3(Optional<Member> member) {
            System.out.println("setNullBean3 = " + member);
        }
    }
}
