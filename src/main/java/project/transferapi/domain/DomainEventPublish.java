package project.transferapi.domain;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
public class DomainEventPublish {
    private static ApplicationEventPublisher PUBLISHER;

    /**
     * DomainEventPublish 초기화
     * @param publisher ApplicationEventPublisher
     */
    public static void init(ApplicationEventPublisher publisher) {
        if(DomainEventPublish.PUBLISHER == null) {
            DomainEventPublish.PUBLISHER = publisher;
        }
    }

    /**
     * Domain Event 발행
     * @param event 발행 Event
     */
    public static void publish(@Nonnull Object event) {
        String eventName = event.getClass().getSimpleName();

        if (log.isDebugEnabled()) {
            log.debug("Publishing Event.. Type: '{}'", eventName);
        }
        requiredPublisher().publishEvent( event );
    }

    /**
     * Domain Publisher Null 체크
     * @return ApplicationEventPublisher
     */
    private static ApplicationEventPublisher requiredPublisher() {
        if(PUBLISHER == null) {
            throw new IllegalStateException( "ApplicationEventPublisher must not be null." );
        }
        return PUBLISHER;
    }
}
