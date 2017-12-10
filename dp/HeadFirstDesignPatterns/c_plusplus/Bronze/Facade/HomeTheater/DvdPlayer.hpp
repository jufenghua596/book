#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_DVD_PLAYER_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_DVD_PLAYER_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class Amplifier;

class DvdPlayer {
	private: std::string description;
	private: int currentTrack;
	private: Amplifier* amplifier;
	private: std::string movie;
	
	public: DvdPlayer(std::string description, Amplifier* amplifier) {
		this->description = description;
		this->amplifier = amplifier;
	}
 	public: virtual void on() {
		std::cout << description << " on" << std::endl;
	}
 	public: virtual void off() {
		std::cout << description << " off" << std::endl;
	}
    public: virtual void eject() {
		movie.empty();
		std::cout << description << " eject" << std::endl;
    }
	public: virtual void play(std::string movie) {
		this->movie = movie;
		currentTrack = 0;
		std::cout << description << " playing \"" << movie << "\"" << std::endl;
	}
	public: virtual void play(int track) {
		if (movie.length() == 0) {
			std::cout << description << " can't play track " << track << " no dvd inserted" << std::endl;
		} else {
			currentTrack = track;
			std::cout << description << " playing track " << currentTrack << " of \"" << movie << "\"" << std::endl;
		}
	}
	public: virtual void stop() {
		currentTrack = 0;
		std::cout << description << " stopped \"" << movie << "\"" << std::endl;
	}
	public: virtual void pause() {
		std::cout << description << " paused \"" << movie << "\"" << std::endl;
	}
	public: virtual void setTwoChannelAudio() {
		std::cout << description << " set two channel audio" << std::endl;
	}
	public: virtual void setSurroundAudio() {
		std::cout << description << " set surround audio" << std::endl;
	}
	public: virtual std::string toString() {
		return description;
	}
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif

