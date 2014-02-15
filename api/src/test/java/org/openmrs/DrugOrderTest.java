/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Contains tests for DrugOrder
 */
public class DrugOrderTest {
	
	/**
	 * @verifies set all the relevant fields
	 * @see DrugOrder#cloneForDiscontinuing()
	 */
	@Test
	public void cloneForDiscontinuing_shouldSetAllTheRelevantFields() throws Exception {
		DrugOrder order = new DrugOrder();
		order.setPatient(new Patient());
		order.setCareSetting(new CareSetting());
		order.setConcept(new Concept());
		order.setDrug(new Drug());
		
		DrugOrder dcOrder = (DrugOrder) order.cloneForDiscontinuing();
		
		assertEquals(order.getDrug(), dcOrder.getDrug());
		
		assertEquals(order.getPatient(), dcOrder.getPatient());
		
		assertEquals(order.getConcept(), dcOrder.getConcept());
		
		assertEquals("should set previous order to anOrder", order, dcOrder.getPreviousOrder());
		
		assertEquals("should set new order action to new", dcOrder.getAction(), Order.Action.DISCONTINUE);
		
		assertEquals(order.getCareSetting(), dcOrder.getCareSetting());
	}
	
	/**
	 * @verifies copy all drug order fields
	 * @see DrugOrder#copy()
	 */
	@Test
	public void copy_shouldCopyAllDrugOrderFields() throws Exception {
		OrderTest.assertThatAllFieldsAreCopied(new DrugOrder());
	}
}