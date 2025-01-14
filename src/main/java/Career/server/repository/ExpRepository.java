package Career.server.repository;

import Career.server.domain.mapping.Exp;
import Career.server.domain.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpRepository extends JpaRepository<Exp, Long> {

    @Query("select count(e) from Exp e where e.user = :user and e.expGubun = 'INTERN'")
    Integer findInternCount(User user);
}
