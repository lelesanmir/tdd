package br.com.leonardo.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.leonardo.tdd.molelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeverriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class, //Tem essas 2 formas de fazer o exeception essa primeira fica mais limpa
				() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
//		try {
//			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//			fail("N�o deu a exeception!");
//		} catch (Exception e) {
//			assertEquals("Funcion�rio com sal�rio acima de R$10000 n�o pode receber o B�nus!", e.getMessage());
		}
		

//}

	@Test
	void bonusDeverriaDiferenteZeroParaFincionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rafael", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rafael", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}
	

}
