package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusShouldBeZeroForEmployeeWithVeryHighSalary() {
		BonusService bonusService = new BonusService();
		assertThrows(IllegalArgumentException.class, 
				() -> bonusService.calcularBonus(
						new Funcionario("Arthemyo", LocalDate.now(), new BigDecimal("25000"))));
	}
	
	@Test
	void bonusShouldBeTenPercentOfSalaryOfEmployee() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Arthemyo", LocalDate.now(), new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusShouldBeTenPercentToSalaryTenThousand() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Arthemyo", LocalDate.now(), new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
