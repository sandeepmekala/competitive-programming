package designpatterns;

import java.io.IOException;

class FactoryPattern {
	public static void main(String args[]) throws IOException {
		PlanFactory planFactory = new PlanFactory();
		Plan p = planFactory.getPlan("DOMESTICPLAN");
		p.calculateBill(12);
		
		Plan p2 = planFactory.getPlan("COMMERCIALPLAN");
		p2.calculateBill(12);
	}
}

abstract class Plan {
	double rate;

	public void calculateBill(int units) {
		System.out.println(units * rate);
	}
}

class DomesticPlan extends Plan {
	DomesticPlan(){
		rate = 3.50;
	}
}

class CommercialPlan extends Plan {
	CommercialPlan() {
		rate = 7.50;
	}
}

class PlanFactory {
	// use getPlan method to get object of type Plan
	public Plan getPlan(String planType) {
		if (planType == null) {
			return null;
		}
		if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
			return new DomesticPlan();
		} else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
			return new CommercialPlan();
		}
		return null;
	}
}