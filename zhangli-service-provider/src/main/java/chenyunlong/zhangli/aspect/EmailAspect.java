package chenyunlong.zhangli.aspect;

import chenyunlong.zhangli.annotation.Email;
import chenyunlong.zhangli.properties.ZhangliProperties;
import chenyunlong.zhangli.service.EmailService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class EmailAspect {

    private final Logger log = LoggerFactory.getLogger(EmailAspect.class);
    private final ZhangliProperties zhangliProperties;

    private final EmailService emailService;

    public EmailAspect(ZhangliProperties zhangliProperties, EmailService emailService) {
        this.zhangliProperties = zhangliProperties;
        this.emailService = emailService;
    }


    @Pointcut("@annotation(chenyunlong.zhangli.annotation.Email)")
    public void pointcut() {
        // do nothing
    }

    @Around("pointcut()")
    public Object Around(ProceedingJoinPoint point) throws Throwable {

        //获取方法签名
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        //获取方法注解
        Email annotation = method.getAnnotation(Email.class);

        Object[] args = point.getArgs();
        log.debug("发送邮件的位置：" + annotation.receiver());
        //TODO 创建一个邮件发送线程！
        EmailThread emailThread = new EmailThread(annotation.receiver(), annotation.object(), annotation.content());
        emailThread.start();
        return point.proceed(args);
    }

    private class EmailThread extends Thread {
        private final String receiver;
        private final String subject;
        private final String content;

        public EmailThread(String receiver, String subject, String content) {

            this.receiver = receiver;
            this.subject = subject;
            this.content = content;
        }

        @Override
        public void run() {
            super.run();
            emailService.sendEmail(receiver, subject, content);
            log.debug("发送一条邮件给指定账户" + zhangliProperties.getFile().getBaseUploadDir());
        }
    }
}
