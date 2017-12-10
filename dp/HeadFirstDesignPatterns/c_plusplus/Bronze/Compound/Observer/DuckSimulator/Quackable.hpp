#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACKABLE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACKABLE_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class Quackable : public QuackObservable {
	public: virtual void quack() = 0;
	public: virtual std::string toString() = 0;
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif