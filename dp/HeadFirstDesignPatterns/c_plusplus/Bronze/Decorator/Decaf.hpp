#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_DECAF_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_DECORATOR_DECAF_HPP_

#include "Starbuzz.hpp"

namespace HeadFirstDesignPatterns {
namespace Decorator {

class Decaf : public Beverage {
  	public: Decaf() {
		description = "Decaf Coffee";
	}
  	public: virtual double cost() {
		return 1.05;
	}
};

} // namespace Observer
} // namespace HeadFirstDesignPatterns

#endif