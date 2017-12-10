#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_WHIP_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_WHIP_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class Whip : public CondimentDecorator {
	private: Beverage* beverage;

 	public: Whip(Beverage* beverage) {
		this->beverage = beverage;
	}
	public: virtual std::string getDescription() {
		return beverage->getDescription() + ", Whip";
	}
	public: virtual double cost() {
		return 0.10 + beverage->cost();
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif