package br.com.leonardo.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.leonardo.tdd.modelo.Desempenho;
import br.com.leonardo.tdd.molelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach // Assim ele vai chamar o inicializar antes dos metodos.
	public void inicializar() {
		System.out.println("Inicializar");
		this.service = new ReajusteService();// Peguei de dentro dos outros metodos para diminuir o codigo e coloquei no
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}

	@AfterEach
	public void finalizar() {
		System.out.println("Fim!");
		
//		@BeforeAll //Esses dois não funcionaram deve ser pela versão java 8 mais eles da seguinte maneira roda uma vez antes de todos e depois de todos
//		public static void antesDeTodos() {
//			System.out.println("Antes de todos!");
//		}
//		
//		@AfterAll
//		public static void depoisDeTodos() {
//			System.out.println("Depois de todos!");
//		}
		
		
	}

	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
//		ReajusteService service = new ReajusteService();  Aqui para refatorar o codigo transformei em variavel local apertando ctrl+1
//		Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000")); Apartir dai, os codigos nas demais vão diminuir
		// service = new ReajusteService();
		// funcionario = new Funcionario("Ana", LocalDate.now(), new
		// BigDecimal("1000"));
		service.concederReajuste(funcionario, Desempenho.A_DESEJA);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {

		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSerDeQuarentaPorcentoQuandoDesempenhoForEspetacular() {
		service.concederReajuste(funcionario, Desempenho.ESPETACULAR);
		assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
	}

}
