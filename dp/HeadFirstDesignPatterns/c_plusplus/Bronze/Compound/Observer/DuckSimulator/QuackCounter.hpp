#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACK_COUNTER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_QUACK_COUNTER_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class QuackCounter : public Quackable {
	private: Quackable* duck;
	private: static int numberOfQuacks;
  
	public: QuackCounter(Quackable* duck) {
		this->duck = duck;
	}
	public: virtual void quack() {
		duck->quack();
		numberOfQuacks++;
	}
	public: static int getQuacks() {
		return numberOfQuacks;
	}
	public: virtual void registerObserver(Observer* observer) {
		duck->registerObserver(observer);
	}
	public: virtual void notifyObservers() {
		duck->notifyObservers();
	}
	public: virtual std::string toString() {
		return duck->toString();
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif

