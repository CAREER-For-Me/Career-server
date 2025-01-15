package Career.server.repository;

import Career.server.domain.enums.Major;
import Career.server.domain.mapping.Passed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PassedRepository extends JpaRepository<Passed, Long> {

    @Query("select p from Passed p where p.major = :major")
    Passed findByMajor(@Param("major") Major major);

}
