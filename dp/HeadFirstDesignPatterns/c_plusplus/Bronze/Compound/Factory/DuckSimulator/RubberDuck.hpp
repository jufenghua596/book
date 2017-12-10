#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_FACTORY_RUBBER_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_FACTORY_RUBBER_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Factory {

class RubberDuck : public Quackable {
	public: virtual void quack() {
		std::cout << "Squeak" << std::endl;
	}
	public: virtual std::string toString() {
		return "Rubber Duck";
	}
};

} // namespace Factory
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif