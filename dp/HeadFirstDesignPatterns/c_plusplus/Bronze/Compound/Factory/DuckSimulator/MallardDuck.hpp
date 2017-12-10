#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_FACTORY_MALLARD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_FACTORY_MALLARD_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Factory {

class MallardDuck : public Quackable {
	public: virtual void quack() {
		std::cout << "Quack" << std::endl;
	}
	public: virtual std::string toString() {
		return "Mallard Duck";
	}
};

} // namespace Factory
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif