#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_PIZZA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_SIMPLE_FACTORY_PIZZA_HPP_

#include "Pizzas.hpp"

namespace HeadFirstDesignPatterns {
namespace Factory {
namespace Simple {

class Pizza {
	protected: std::string name;
	protected: std::string dough;
	protected: std::string sauce;
	protected: std::list<std::string> toppings;

	public: virtual std::string getName() {
		return name;
	}
	public: virtual void prepare() {
		std::cout << "Preparing " << name.c_str() << std::endl;
	}
	public: virtual void bake() {
		std::cout << "Baking " << name.c_str() << std::endl;
	}
	public: virtual void cut() {
		std::cout << "Cutting " << name.c_str() << std::endl;
	}
	public: virtual void box() {
		std::cout << "Boxing " << name.c_str() << std::endl;
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

} // namespace Simple
} // namespace Factory
} // namespace HeadFirstDesignPatterns

#endif