package Career.server.repository;

import Career.server.domain.mapping.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findTop8ByOrderByViewsDesc();
}
