package Career.server.repository;

import Career.server.domain.mapping.Edu;
import Career.server.domain.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EduRepository extends JpaRepository<Edu, Long> {

    Edu findByUser(User user);
}
