#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACTORY_METHOD_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACTORY_METHOD_PIZZA_HPP_

#include "Pizzafm.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Method {

class Pizza {
	protected: std::string name;
	protected: std::string dough;
	protected: std::string sauce;
	protected: std::list<std::string> toppings;

	public: virtual void prepare() {
		std::cout << "Preparing " << name.c_str() << std::endl;
		std::cout << "Tossing dough..." << std::endl;
		std::cout << "Adding sauce..." << std::endl;
		std::cout << "Adding toppings: " << std::endl;
		for (std::list<std::string>::iterator it = toppings.begin(); toppings.end() != it; ++it) {
			std::cout << "   " << it->c_str() << std::endl;
		}
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
	public: virtual std::string getName() {
		return name;
	}
	public: virtual std::string toString() {
		// code to display pizza name and ingredients
		std::stringstream display; 
		display << "---- " << name.c_str() << " ----" << std::endl;
		display << dough.c_str() << std::endl;
		display << sauce.c_str() << std::endl;
		for (std::list<std::string>::iterator it = toppings.begin(); toppings.end() != it; ++it) {
			display << it->c_str() << std::endl;
		}
		return display.str();
	}
};

} // namespace Method
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif
