package com.bbletscode.rotativo.repositories;

import com.bbletscode.rotativo.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByPlaca(String placa);
}
