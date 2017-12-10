#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_ABSTRACT_PIZZA_HPP_

#include "Pizzaaf.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Abstract {

class Pizza {
	private: std::string name;

	protected: Dough* dough;
	protected: Sauce* sauce;
	protected: std::vector<Veggies*> veggies;
	protected: Cheese* cheese;
	protected: Pepperoni* pepperoni;
	protected: Clams* clam;

	public: virtual void prepare() = 0;

	public: Pizza() : dough(0), sauce(0), cheese(0), pepperoni(0), clam(0) {
	}
	public: virtual void bake() {
		std::cout << "Bake for 25 minutes at 350" << std::endl;
	}
	public: virtual void cut() {
		std::cout << "Cutting the pizza into diagonal slices" << std::endl;
	}
	public: virtual void box() {
		std::cout << "Place pizza in official PizzaStore box" << std::endl;
	}
	public: virtual void setName(std::string name) {
		this->name = name;
	}
	public: virtual std::string getName() {
		return name;
	}
	public: virtual std::string toString() {
		std::stringstream result; 
		result << "---- " << name.c_str() << " ----" << std::endl;

		if (dough != 0) {
			result << dough->toString();
			result << std::endl;
		}
		if (sauce != 0) {
			result << sauce->toString();
			result << std::endl;
		}
		if (cheese != 0) {
			result << cheese->toString();
			result << std::endl;
		}
		if (veggies.size()) {
			for (std::vector<Veggies*>::iterator it = veggies.begin(); veggies.end() != it; ++it) {
				result << (*it)->toString() << ", ";
			}
			result << std::endl;
		}
		if (clam != 0) {
			result << clam->toString();
			result << std::endl;
		}
		if (pepperoni != 0) {
			result << pepperoni->toString();
			result << std::endl;
		}

		return result.str();
	}
};

} // namespace Abstract
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif