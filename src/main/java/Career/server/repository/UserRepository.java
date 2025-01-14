package Career.server.repository;

import Career.server.domain.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User userId);
    User findByUserId(String userId);
    boolean existsByUserId(String userId);
    boolean existsByEmail(String email);

}
