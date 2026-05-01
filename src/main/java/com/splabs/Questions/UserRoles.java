package com.splabs.Questions;

import java.util.List;

/**
 * The question was from the Finvari interview
 */
public class UserRoles {
    public enum Feature {
        MAILBOX,
        FINANCE,
        EXPENSES,
        CALENDAR,
        CONTACTS,
        TASKS,
        NOTES,
        FILES
    }

    public record User(int id, String name, String email, List<Feature> grant) {}

    public record Account(int id, String name, String email) {
        public Account(User user) {
            this(user.id(), user.name(), user.email());
        }
    }

    public record Role(String name, List<Feature> features, List<Account> users) {}

    public List<Role> GenerateRoles(List<User> users) {
        // Implementation to generate roles based on user features
        return List.of(); // Placeholder return
    }
}
