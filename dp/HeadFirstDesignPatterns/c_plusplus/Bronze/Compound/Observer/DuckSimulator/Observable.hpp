#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_OBSERVABLE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_OBSERVABLE_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class Observable : public QuackObservable {
	private: std::vector<Observer*> observers;
	private: QuackObservable* duck;
 
	public: Observable(QuackObservable* duck) {
		this->duck = duck;
	}
	public: virtual void registerObserver(Observer* observer) {
		observers.push_back(observer);
	}
	public: virtual void notifyObservers() {
		std::vector<Observer*>::iterator iterator = observers.begin();
		while (iterator != observers.end()) {
			Observer* observer = *iterator++;
			observer->update(duck);
		}
	}
	public: virtual std::vector<Observer*> getObservers() {
		return observers;
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif
