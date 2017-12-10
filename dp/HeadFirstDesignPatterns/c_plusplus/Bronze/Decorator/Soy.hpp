#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_SOY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_SOY_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class Soy : public CondimentDecorator {
	private: Beverage* beverage;

 	public: Soy(Beverage* beverage) {
		this->beverage = beverage;
	}
	public: virtual std::string getDescription() {
		return beverage->getDescription() + ", Soy";
	}
	public: virtual double cost() {
		return 0.15 + beverage->cost();
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif