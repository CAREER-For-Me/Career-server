package Career.server.repository;

import Career.server.domain.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByMemberId(String memberId);
    Boolean existsByMemberId(String memberId);
    Boolean existsByEmail(String email);
    //User
}
