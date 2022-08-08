package com.bbletscode.rotativo.repositories;

import com.bbletscode.rotativo.models.Rotativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotativoRepository extends JpaRepository<Rotativo, Long> {
}
