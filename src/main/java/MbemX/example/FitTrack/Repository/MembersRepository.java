package MbemX.example.FitTrack.Repository;

import MbemX.example.FitTrack.Entity.Members;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long> {

    @Query("SELECT COUNT(m) FROM Members m WHERE m.email LIKE CONCAT('%', :domaine, '%')")
    long compterParDomaineEmail(@Param("domaine") String domaine);

    List<Members> findByNameContainingIgnoreCase(String name);

    boolean existsByEmail(String Email);
}