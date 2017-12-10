#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_ABSTRACT_DUCK_FACTORY_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_ABSTRACT_DUCK_FACTORY_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class AbstractDuckFactory {
	public: virtual Quackable* createMallardDuck() = 0;
	public: virtual Quackable* createRedheadDuck() = 0;
	public: virtual Quackable* createDuckCall() = 0;
	public: virtual Quackable* createRubberDuck() = 0;
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif