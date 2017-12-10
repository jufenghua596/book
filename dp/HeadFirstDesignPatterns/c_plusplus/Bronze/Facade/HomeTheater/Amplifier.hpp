#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_AMPLIFIER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_AMPLIFIER_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class Amplifier {
	private: std::string description;
	private: Tuner* tuner;
	private: DvdPlayer* dvd;
	private: CdPlayer* cd;
	
	public: Amplifier(std::string description) {
		this->description = description;
	}
 	public: virtual void on() {
		std::cout << description << " on" << std::endl;
	}
 	public: virtual void off() {
		std::cout << description << " off" << std::endl;
	}
 	public: virtual void setStereoSound() {
		std::cout << description << " stereo mode on" << std::endl;
	}
 	public: virtual void setSurroundSound() {
		std::cout << description << " surround sound on (5 speakers, 1 subwoofer)" << std::endl;
	}
 	public: virtual void setVolume(int level) {
		std::cout << description << " setting volume to " << level << std::endl;
	}
	public: virtual void setTuner(Tuner* tuner) {
		std::cout << description << " setting tuner to " << tuner->toString() << std::endl;
		this->tuner = tuner;
	}
 	public: virtual void setDvd(DvdPlayer* dvd) {
		std::cout << description << " setting DVD player to " << dvd->toString()<< std::endl;
		this->dvd = dvd;
	}
 	public: virtual void setCd(CdPlayer* cd) {
		std::cout << description << " setting CD player to " << cd->toString() << std::endl;
		this->cd = cd;
	}
	public: virtual std::string toString() {
		return description.c_str();
	}
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif
