#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_BEVERAGE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_BEVERAGE_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class Beverage {
 	protected: std::string description;

	protected: Beverage() : description("Unknown Beverage") {
	}
	public: virtual std::string getDescription() {
		return description;
	}
	public: virtual double cost() = 0;
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif