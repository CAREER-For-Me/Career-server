package Career.server.repository;

import Career.server.domain.mapping.FieldPosting;
import Career.server.domain.mapping.Posting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FieldPostingRepository extends JpaRepository<FieldPosting, Long> {
    @Query("SELECT p FROM Posting p " +
            "WHERE p.id IN (" +
            "    SELECT fp.posting.id FROM FieldPosting fp " +
            "    WHERE fp.field.id IN :fieldIds" +
            ") " +
            "AND p.postingGubun = :postingGubun " +
            "ORDER BY p.views DESC")
    Page<Posting> findPostingsByFieldIds(@Param("fieldIds") List<Long> fieldIds, @Param("postingGubun") Integer gubun, Pageable pageable);
}
