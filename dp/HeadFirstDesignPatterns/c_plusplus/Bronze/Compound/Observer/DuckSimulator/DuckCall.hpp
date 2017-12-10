#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_DUCK_CALL_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_DUCK_CALL_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class DuckCall : public Quackable {
	private: Observable* observable;
 
	public: DuckCall() {
		observable = new Observable(this);
	}
	public: virtual void quack() {
		std::cout << "Kwak" << std::endl;
		notifyObservers();
	}
	public: virtual void registerObserver(Observer* observer) {
		observable->registerObserver(observer);
	}
	public: virtual void notifyObservers() {
		observable->notifyObservers();
	}
	public: virtual std::string toString() {
		return "Duck Call";
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif

