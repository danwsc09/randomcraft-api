package randomcraft.application.domain.match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchDataRepository extends JpaRepository<MatchData, Long> {
}
