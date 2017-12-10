#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_TEA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_TEMPLATE_BARISTA_TEA_HPP_

#include "Barista.hpp"

namespace HeadFirstDesignPatterns {
namespace Template {
namespace Barista {

class Tea : public CaffeineBeverage {
	public: virtual void brew() {
		std::cout << "Steeping the tea" << std::endl;
	}
	public: virtual void addCondiments() {
		std::cout << "Adding Lemon" << std::endl;
	}
};

} // namespace Barista
} // namespace Template
} // namespace HeadFirstDesignPatterns

#endif