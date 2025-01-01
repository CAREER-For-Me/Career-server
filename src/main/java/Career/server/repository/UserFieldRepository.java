package Career.server.repository;

import Career.server.domain.mapping.UserField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFieldRepository extends JpaRepository<UserField, Long> {
}
