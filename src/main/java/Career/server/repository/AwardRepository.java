package Career.server.repository;


import Career.server.domain.mapping.Award;
import Career.server.domain.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AwardRepository extends JpaRepository<Award, Long> {

    @Query("select count(a) from Award a where a.user = :user")
    Integer findAwardCount(User user);
}
