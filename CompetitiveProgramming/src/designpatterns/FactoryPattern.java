package designpatterns;

import java.io.IOException;

class FactoryPattern {
	public static void main(String args[]) throws IOException {
		PlanFactory planFactory = new PlanFactory();
		Plan p = planFactory.getPlan("DOMESTICPLAN");
		p.calculateBill(12, p.getRate());
		
		Plan p2 = planFactory.getPlan("COMMERCIALPLAN");
		p2.calculateBill(12, p2.getRate());
	}
}

abstract class Plan {
	abstract double getRate();

	public void calculateBill(int units, double rate) {
		System.out.println(units * rate);
	}
}

class DomesticPlan extends Plan {
	public double getRate() {
		return 3.50;
	}
}

class CommercialPlan extends Plan {
	public double getRate() {
		return 7.50;
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