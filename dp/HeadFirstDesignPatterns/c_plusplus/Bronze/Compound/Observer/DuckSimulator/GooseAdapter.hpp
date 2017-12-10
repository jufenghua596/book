#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_GOOSE_ADAPTER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_GOOSE_ADAPTER_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class GooseAdapter : public Quackable {
	private: Goose* goose;
	private: Observable* observable;
 
	public: GooseAdapter(Goose* goose) {
		this->goose = goose;
		observable = new Observable(this);
	}
	public: virtual void quack() {
		goose->honk();
		notifyObservers();
	}
	public: virtual void registerObserver(Observer* observer) {
		observable->registerObserver(observer);
	}
	public: virtual void notifyObservers() {
		observable->notifyObservers();
	}
	public: virtual std::string toString() {
		return "Goose pretending to be a Duck";
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif