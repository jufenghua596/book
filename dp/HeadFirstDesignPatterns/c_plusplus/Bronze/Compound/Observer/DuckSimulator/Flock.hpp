#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_FLOCK_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_COMPOUND_OBSERVER_FLOCK_HPP_

#include "DuckSimulator.hpp"

namespace HeadFirstDesignPatterns {
namespace Compound {
namespace Observer {

class Flock : public Quackable {
	private: std::vector<Quackable*> ducks;
  
	public: void add(Quackable* duck) {
		ducks.push_back(duck);
	}
	public: virtual void quack() {
		for (std::vector<Quackable*>::iterator it = ducks.begin(); ducks.end() != it; ++it) {
			Quackable* quacker = *it;
			quacker->quack();
		}
	}
	public: virtual void registerObserver(Observer* observer) {
		for (std::vector<Quackable*>::iterator it = ducks.begin(); ducks.end() != it; ++it) {
			Quackable* quacker = *it;
			quacker->registerObserver(observer);
		}
	}
	public: virtual void notifyObservers() {
	}
  	public: virtual std::string toString() {
		return "Flock of Ducks";
	}
};

} // namespace Observer
} // namespace Compound
} // namespace HeadFirstDesignPatterns

#endif
