package org.edr.services;

import java.math.BigDecimal;
import java.util.List;

import org.edr.junit.AbstractJunitTest;
import org.edr.po.Bankrekening;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BankrekeningServiceTest extends AbstractJunitTest {

	@Autowired
	private BankrekeningService bankrekeningService;

	@Test
	public void test() {
		List<Bankrekening> bankrekeningen = bankrekeningService.findBankrekeningen();
		Assert.assertEquals(2, bankrekeningen.size());
		Assert.assertEquals("BE27 0000 1111 2222", bankrekeningen.get(0).getRekeningnr());
		Assert.assertEquals(new BigDecimal("85.70"), bankrekeningen.get(0).getSaldo());
		Assert.assertEquals(new BigDecimal("0"), bankrekeningen.get(1).getSaldo());
	}

}
