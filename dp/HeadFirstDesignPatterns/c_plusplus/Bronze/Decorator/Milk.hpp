#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_MILK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_MILK_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class Milk : public CondimentDecorator {
	private: Beverage* beverage;

	public: Milk(Beverage* beverage) {
		this->beverage = beverage;
	}
 	public: virtual std::string getDescription() {
		return beverage->getDescription() + ", Milk";
	}
 	public: virtual double cost() {
		return 0.10 + beverage->cost();
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif