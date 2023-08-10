package randomcraft.application.domain.ability;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, Long> {

    Page<Ability> findAllByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(
            String name, String description, Pageable page);
}
