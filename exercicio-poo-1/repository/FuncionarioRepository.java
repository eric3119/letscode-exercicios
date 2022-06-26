package repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import interfaces.BonusSalario;
import models.Funcionario;

public class FuncionarioRepository implements BaseRepository<Funcionario, String> {
    private static FuncionarioRepository funcionarioRepository;
    private Set<Funcionario> funcionarios = new HashSet<>();

    private FuncionarioRepository(){}

    public static FuncionarioRepository getInstance(){
        if(funcionarioRepository == null) funcionarioRepository = new FuncionarioRepository();
        return funcionarioRepository;
    }

    @Override
    public void persist(Funcionario entity) {
        this.funcionarios.add(entity);
    }

    @Override
    public void update(Funcionario entity) {
        this.funcionarios.removeIf(funcionario -> funcionario.getCpf().compareTo(entity.getCpf()) == 0);
        this.funcionarios.add(entity);
    }

    @Override
    public Funcionario getById(String id) {
        return this.funcionarios.stream()
                .filter(
                        funcionario -> funcionario.getCpf().compareTo(id) == 0)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Funcionario> getAll() {
        return List.copyOf(this.funcionarios);
    }

    @Override
    public void delete(Funcionario entity) {
        this.funcionarios.remove(entity);
    }

    public BigDecimal calculaSalario(String cpf) {
        Funcionario f = funcionarioRepository.getById(cpf);
        BigDecimal bonificacao = getBonificacao(f);

        return f.getSalario().add(bonificacao);
    }

    private BigDecimal getBonificacao(Funcionario f){
        if(f instanceof BonusSalario){
            BonusSalario fBonusSalario = (BonusSalario) f;
            return fBonusSalario.getBonificacao();
        }
        return BigDecimal.ZERO;
    }

}
