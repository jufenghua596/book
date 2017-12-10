#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_OBSERVER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_OBSERVER_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class QuackObservable;

class Observer {
	public: virtual void update(QuackObservable* duck) = 0;
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif
