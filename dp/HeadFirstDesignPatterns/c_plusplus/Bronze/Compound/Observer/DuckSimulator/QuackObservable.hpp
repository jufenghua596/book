#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACK_OBSERVABLE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACK_OBSERVABLE_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class Observer;

class QuackObservable {
	public: virtual void registerObserver(Observer* observer) = 0;
	public: virtual void notifyObservers() = 0;
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif