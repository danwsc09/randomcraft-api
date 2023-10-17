package randomcraft.application.domain.match;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import randomcraft.application.util.entity.enums.MatchValidationStatus;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Page<Match> findAllByValidationStatusEquals(Pageable pageable, MatchValidationStatus status);
}
