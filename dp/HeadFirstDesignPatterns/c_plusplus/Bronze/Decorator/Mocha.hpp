#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_MOCHA_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_MOCHA_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class Mocha : public CondimentDecorator {
	private: Beverage* beverage;

 	public: Mocha(Beverage* beverage) {
		this->beverage = beverage;
	}
	public: virtual std::string getDescription() {
		return beverage->getDescription() + ", Mocha";
	}
	public: virtual double cost() {
		return 0.20 + beverage->cost();
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif