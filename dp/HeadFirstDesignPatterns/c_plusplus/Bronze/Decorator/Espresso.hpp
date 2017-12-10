#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_ESPRESSO_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_ESPRESSO_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class Espresso : public Beverage {
	public: Espresso() {
		description = "Espresso";
	}
	public: virtual double cost() {
		return 1.99;
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif