package demo.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/24/17.
 */
//@Service
//@Primary
//@Profile({"en", "default"})
public class PrimaryGreetingService implements GreetingService {

	
    private GreetingRepository greetingRepository;
    
 
    @Autowired
    public PrimaryGreetingService(GreetingRepository greetingRepository) {
		super();
		this.greetingRepository = greetingRepository;
	}

	@Override
    public String sayGreeting() {
        return greetingRepository.getEnglishGreeting();
    }
}
