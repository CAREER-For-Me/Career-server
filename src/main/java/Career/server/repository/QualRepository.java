package Career.server.repository;


import Career.server.domain.mapping.Qual;
import Career.server.domain.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QualRepository extends JpaRepository<Qual, Long> {

    @Query("select count(q) from Qual q where q.user = :user")
    Integer findQualCount(User user);
}
