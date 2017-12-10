#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_CAFFEINE_BEVERAGE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_CAFFEINE_BEVERAGE_HPP_

#include "Barista.hpp"

namespace HeadFirstDesignPatterns {
namespace Template {
namespace Barista {

class CaffeineBeverage {
  
	public: virtual void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
 	protected: virtual void brew() = 0;
 	protected: virtual void addCondiments() = 0;
 	private: void boilWater() {
		std::cout << "Boiling water" << std::endl;
	}
 	private: void pourInCup() {
		std::cout << "Pouring into cup" << std::endl;
	}
};

} // namespace Barista
} // namespace Template
} // namespace HeadFirstDesignPatterns

#endif