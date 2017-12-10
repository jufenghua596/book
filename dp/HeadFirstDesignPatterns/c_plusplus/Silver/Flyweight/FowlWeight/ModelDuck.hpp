#ifndef	_HFDP_CPP_FLYWEIGHT_FOWLWEIGHT_MODEL_DUCK_HPP_
#define _HFDP_CPP_FLYWEIGHT_FOWLWEIGHT_MODEL_DUCK_HPP_

#include "FowlWeight.hpp"

namespace HeadFirstDesignPatterns {
namespace FlyWeight {
namespace FowlWeight {

// ConcreteFlyweight

class ModelDuck : public Fowl {

	private: std::string _type;
	private: std::string _sound;
	private: std::string _swim;

	public: ModelDuck() : 
		_type( "Model duck" ), _sound( "<< Silence >>" ), _swim( "sinks" ) {
	}
	public: void quack() const {
		std::cout << _sound.c_str();
	}
	public: void swim() const {
		std::cout << _swim.c_str();
	}
	public: std::string toString() const {
		return _type.c_str();
	}
};

} // namespace FowlWeight
} // namespace FlyWeight
} // namespace HeadFirstDesignPatterns

#endif