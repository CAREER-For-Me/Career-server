package Career.server.repository;

import Career.server.domain.mapping.FieldPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FieldPostingRepository extends JpaRepository<FieldPosting, Long> {

}
