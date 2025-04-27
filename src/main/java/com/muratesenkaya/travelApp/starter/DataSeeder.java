package com.muratesenkaya.travelApp.starter;

import net.datafaker.Faker;
import com.muratesenkaya.travelApp.model.*;
import com.muratesenkaya.travelApp.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RouteRepository routeRepository;
    private final CommentRepository commentRepository;
    private final RateRepository rateRepository;
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public void run(String... args) {
        Faker faker = new Faker();
        Random random = new Random();

        // 5-10 User yarat
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            User user = new User();
            user.setName(faker.name().firstName());
            user.setSurname(faker.name().lastName());
            user.setUserName(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword("123456");
            users.add(userRepository.save(user));
        }

        // Her kullanıcı için 3-5 Route yarat
        List<Route> routes = new ArrayList<>();
        for (User user : users) {
            int routeCount = random.nextInt(3) + 3; // 3 ile 5 arası
            for (int i = 0; i < routeCount; i++) {
                Route route = new Route();
                route.setHead(faker.lorem().sentence(3));
                route.setDescription(faker.lorem().paragraph());
                route.setDate(new Date());
                route.setUser(user);
                route = routeRepository.save(route);
                routes.add(route);

                // Her Route'a 3-7 Location ekle
                int locationCount = random.nextInt(5) + 3;
                for (int j = 0; j < locationCount; j++) {
                    Location location = new Location();
                    location.setLatitude(36 + (42 - 36) * random.nextDouble()); // 36-42 arasında
                    location.setLongitude(26 + (45 - 26) * random.nextDouble()); // 26-45 arasında
                    location.setRoute(route);
                    locationRepository.save(location);
                }

            }
        }

        // Her Route için 10-20 Rate ve 5-10 Comment ekle
        for (Route route : routes) {
            int rateCount = random.nextInt(10) + 10; // 10-20 Rate
            for (int i = 0; i < rateCount; i++) {
                Rate rate = new Rate();
                rate.setRate(random.nextInt(5) + 1);
                rate.setUser(users.get(random.nextInt(users.size())));
                rate.setRoute(route);
                rateRepository.save(rate);
            }

            int commentCount = random.nextInt(5) + 5; // 5-10 Comment
            for (int i = 0; i < commentCount; i++) {
                Comment comment = new Comment();
                comment.setComment(faker.lorem().sentence(8));
                comment.setDate(new Date().toString());
                comment.setUser(users.get(random.nextInt(users.size())));
                comment.setRoute(route);
                commentRepository.save(comment);
            }
        }

        System.out.println("Seed data başarıyla yüklendi 🚀");
    }
}
