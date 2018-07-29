package demo.springframework.services;

import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/24/17.
 */
@Component
public interface GreetingRepository {

    String getEnglishGreeting();

    String getSpanishGreeting();

    String getGermanGreeting();
}
