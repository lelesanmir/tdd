package br.com.leonardo.tdd.service;

import java.math.BigDecimal;

import br.com.leonardo.tdd.modelo.Desempenho;
import br.com.leonardo.tdd.molelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
			BigDecimal percentual = desempenho.percentualReajuste();
			BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
			funcionario.reajustarSalario(reajuste);
	}
}