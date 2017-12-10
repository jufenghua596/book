#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_CAFFEINE_BEVERAGE_WITH_HOOK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_CAFFEINE_BEVERAGE_WITH_HOOK_HPP_

#include "Barista.hpp"

namespace HeadFirstDesignPatterns {
namespace Template {
namespace Barista {

class CaffeineBeverageWithHook {
 
	public: virtual void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}
	public: virtual void brew() = 0;
	public: virtual void addCondiments() = 0;
	protected: virtual void boilWater() {
		std::cout << "Boiling water" << std::endl;
	}
	protected: virtual void pourInCup() {
		std::cout << "Pouring into cup" << std::endl;
	}
	protected: virtual bool customerWantsCondiments() {
		return true;
	}
};

} // namespace Barista
} // namespace Template
} // namespace HeadFirstDesignPatterns

#endif