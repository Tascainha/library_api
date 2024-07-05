package com.library.api.shared.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.library.api.user.User;
import com.library.api.user.UserRepository;

@Component
public class DatabaseSeeder {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @EventListener
  public void seed(ContextRefreshedEvent event) {
    if (userRepository.count() == 0) {
      seedSuperAdmin();
    }
  }

  private void seedSuperAdmin() {
    User superAdmin = new User(
      "Super Admin",
      "superadmin@email.com",
      passwordEncoder.encode("superadmin"),
      "ROLE_ADMIN"
    );
    userRepository.save(superAdmin);
  }
}

