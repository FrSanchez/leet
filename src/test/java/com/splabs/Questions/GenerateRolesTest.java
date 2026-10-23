package com.splabs.Questions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GenerateRolesTest {
    private static final int BASELINE_USER_COUNT = 200;
    private static final long BASELINE_RANDOM_SEED = 20260430L;

    private static final String[] FIRST_NAMES = {
            "Alice", "Bob", "Charlie", "Diana", "Ethan", "Fatima", "Grace", "Hector", "Iris", "Jonah",
            "Kira", "Liam", "Maya", "Noah", "Olivia", "Priya", "Quinn", "Ravi", "Sofia", "Theo"
    };

    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Brown", "Garcia", "Martinez", "Davis", "Wilson", "Anderson", "Thomas", "Taylor",
            "Moore", "Martin", "Lee", "Perez", "Thompson", "White", "Harris", "Clark", "Lewis", "Walker"
    };

    private UserRolesSolution userRoles;

    @BeforeEach
    public void init() {
        userRoles = new UserRolesSolution();
    }

    @Test
    public void GenerateRoles() {
        List<UserRoles.User> users = GenerateBaselineUsers();
        List<UserRoles.Role> roles = userRoles.GenerateRoles(users);
        for(UserRoles.Role role : roles) {
            System.out.printf("Role: %s -------------------------", role.name());
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for(var feature : role.features()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(feature);
            }
            System.out.printf("Features: %s, Users: %d\n", sb, role.users().size());
            for(UserRoles.Account account : role.users()) {
                System.out.printf("  - %s (%s)\n", account.name(), account.email());
            }
        }
    }

    private List<UserRoles.User> GenerateBaselineUsers() {
        Random random = new Random(BASELINE_RANDOM_SEED);
        UserRoles.Feature[] features = UserRoles.Feature.values();
        List<UserRoles.User> users = new ArrayList<>(BASELINE_USER_COUNT);

        for (int id = 1; id <= BASELINE_USER_COUNT; id++) {
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            String name = firstName + " " + lastName;
            String email = String.format("%s.%s%d@example.com", firstName, lastName, id).toLowerCase();

            int featureCount = 1 + random.nextInt(4);
            EnumSet<UserRoles.Feature> grants = EnumSet.noneOf(UserRoles.Feature.class);
            while (grants.size() < featureCount) {
                grants.add(features[random.nextInt(features.length)]);
            }

            users.add(new UserRoles.User(id, name, email, List.copyOf(grants)));
        }

        return List.copyOf(users);
    }
}
