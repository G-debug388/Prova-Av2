package com.curso.services;

import com.curso.domains.Fornecedor;
import com.curso.domains.Laboratorio;
import com.curso.domains.Medicamento;
import com.curso.domains.enums.Disponibilidade;
import com.curso.domains.enums.Validade;
import com.curso.repositories.FornecedorRepository;
import com.curso.repositories.LaboratorioRepository;
import com.curso.repositories.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private FornecedorRepository fornecedorRepo;

    @Autowired
    private LaboratorioRepository laboratorioRepo;

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    public void initDB(){

        Fornecedor fornecedor01 = new Fornecedor(null, "Farmacia São João", "08658785000279");
        Fornecedor fornecedor02 = new Fornecedor(null, "Drogaria São Paulo", "89.158.7980003-03");

        Laboratorio laboratorio01 = new Laboratorio(null, "Fresênios", "45.487.5320002-77");
        Laboratorio laboratorio02 = new Laboratorio(null, "Neo Química", "12.587.6980003-55");

        Medicamento medicamento01 = new Medicamento(null, "Dipirona monohidratada", "ML", "500mg/ml", "Dipimed", "Analgésico", "Gotas", new BigDecimal("3.00"), 500, LocalDate.now(), fornecedor01, laboratorio01, Disponibilidade.DISPONIVEL, Validade.DENTRODAVALIDADE);
        Medicamento medicamento02 = new Medicamento(null, "Dipirona monohidratada / Citrato de orfenadrina / Cafeína anidra", "MG", "300mg + 35mg + 50mg", "Dorflex", "Analgésico e Relaxante muscular", "Comprimido", new BigDecimal("9.00"), 100, LocalDate.now(), fornecedor02, laboratorio02, Disponibilidade.DISPONIVEL, Validade.DENTRODAVALIDADE);

        fornecedorRepo.save(fornecedor01);
        fornecedorRepo.save(fornecedor02);
        laboratorioRepo.save(laboratorio01);
        laboratorioRepo.save(laboratorio02);
        medicamentoRepo.save(medicamento01);
        medicamentoRepo.save(medicamento02);
    }
}
