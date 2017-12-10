#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_MALLARD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_MALLARD_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class MallardDuck : public Quackable {
	private: Observable* observable;
 
	public: MallardDuck() {
		observable = new Observable(this);
	}
	public: virtual void quack() {
		std::cout << "Quack" << std::endl;
		notifyObservers();
	}
	public: virtual void registerObserver(Observer* observer) {
		observable->registerObserver(observer);
	}
	public: virtual void notifyObservers() {
		observable->notifyObservers();
	}
	public: virtual std::string toString() {
		return "Mallard Duck";
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif

