#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_REDHEAD_DUCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_REDHEAD_DUCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class RedheadDuck : public Quackable {
	private: Observable* observable;
 
	public: RedheadDuck() {
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
		return "Redhead Duck";
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif

