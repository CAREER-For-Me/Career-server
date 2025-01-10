package Career.server.repository;

import Career.server.domain.enums.Type;
import Career.server.domain.mapping.Exp;
import Career.server.domain.mapping.Lang;
import Career.server.domain.mapping.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LangRepository extends JpaRepository<Lang, Long> {

    @Query("select l.score from Lang l where l.user = :user and l.type = 'TOEIC'")
    Integer findToeicScore(User user);

    @Query("select l.degree from Lang l where l.user = :user and l.type = 'TOS'")
    String findTosLevel(User user);

}
