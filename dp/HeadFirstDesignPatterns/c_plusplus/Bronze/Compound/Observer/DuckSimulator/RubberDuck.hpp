#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_RUBBER_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_RUBBER_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class RubberDuck : public Quackable {
	private: Observable* observable;
 
	public: RubberDuck() {
		observable = new Observable(this);
	}
	public: virtual void quack() {
		std::cout << "Squeak" << std::endl;
		notifyObservers();
	}
	public: virtual void registerObserver(Observer* observer) {
		observable->registerObserver(observer);
	}
	public: virtual void notifyObservers() {
		observable->notifyObservers();
	}
	public: virtual std::string toString() {
		return "Rubber Duck";
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif

