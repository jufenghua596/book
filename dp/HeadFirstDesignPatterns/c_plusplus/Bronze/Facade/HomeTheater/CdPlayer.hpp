#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_CD_PLAYER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_CD_PLAYER_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class Amplifier;

class CdPlayer {
	private: std::string description;
	private: int currentTrack;
	private: Amplifier* amplifier;
	private: std::string title;
	
	public: CdPlayer(std::string description, Amplifier* amplifier) {
		this->description = description;
		this->amplifier = amplifier;
	}
	public: virtual void on() {
		std::cout << description.c_str() << " on" << std::endl;
	}
	public: virtual void off() {
		std::cout << description.c_str() << " off" << std::endl;
	}
	public: virtual void eject() {
		title.empty();
		std::cout << description.c_str() << " eject" << std::endl;
	}

	public: virtual void play(std::string title) {
		this->title = title;
		currentTrack = 0;
		std::cout << description.c_str() << " playing \"" << title << "\"" << std::endl;
	}
	public: virtual void play(int track) {
		if (title.length() == 0) {
			std::cout << description.c_str() << " can't play track " << currentTrack << 
					", no cd inserted" << std::endl;
		} else {
			currentTrack = track;
			std::cout << description.c_str() << " playing track " << currentTrack << std::endl;
		}
	}
	public: virtual void stop() {
		currentTrack = 0;
		std::cout << description.c_str() << " stopped" << std::endl;
	}
 	public: virtual void pause() {
		std::cout << description.c_str() << " paused \"" << title << "\"" << std::endl;
	}
 	public: virtual std::string toString() {
		return description;
	}
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif

