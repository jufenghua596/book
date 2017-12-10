#ifndef	_HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_FACADE_HPP_
#define _HEAD_FIRST_DESIGN_PATTERNS_FACADE_HOME_THEATER_FACADE_HPP_

#include "HomeTheater.hpp"

namespace HeadFirstDesignPatterns {
namespace Facade {
namespace HomeTheater {

class HomeTheaterFacade {
	private: Amplifier* amp;
	private: Tuner* tuner;
	private: DvdPlayer* dvd;
	private: CdPlayer* cd;
	private: Projector* projector;
	private: TheaterLights* lights;
	private: Screen* screen;
	private: PopcornPopper* popper;
 
	public: HomeTheaterFacade(Amplifier* amp, 
				 Tuner* tuner, 
				 DvdPlayer* dvd, 
				 CdPlayer* cd, 
				 Projector* projector, 
				 Screen* screen,
				 TheaterLights* lights,
				 PopcornPopper* popper) {
		this->amp = amp;
		this->tuner = tuner;
		this->dvd = dvd;
		this->cd = cd;
		this->projector = projector;
		this->screen = screen;
		this->lights = lights;
		this->popper = popper;
	}
 	public: virtual void watchMovie(std::string movie) {
		std::cout << "Get ready to watch a movie..." << std::endl;
		popper->on();
		popper->pop();
		lights->dim(10);
		screen->down();
		projector->on();
		projector->wideScreenMode();
		amp->on();
		amp->setDvd(dvd);
		amp->setSurroundSound();
		amp->setVolume(5);
		dvd->on();
		dvd->play(movie);
	}
	public: virtual void endMovie() {
		std::cout << "Shutting movie theater down..." << std::endl;
		popper->off();
		lights->on();
		screen->up();
		projector->off();
		amp->off();
		dvd->stop();
		dvd->eject();
		dvd->off();
	}
	public: virtual void listenToCd(std::string cdTitle) {
		std::cout << "Get ready for an audiopile experence..." << std::endl;
		lights->on();
		amp->on();
		amp->setVolume(5);
		amp->setCd(cd);
		amp->setStereoSound();
		cd->on();
		cd->play(cdTitle);
	}
	public: virtual void endCd() {
		std::cout << "Shutting down CD..." << std::endl;
		amp->off();
		amp->setCd(cd);
		cd->eject();
		cd->off();
	}
	public: virtual void listenToRadio(double frequency) {
		std::cout << "Tuning in the airwaves..." << std::endl;
		tuner->on();
		tuner->setFrequency(frequency);
		amp->on();
		amp->setVolume(5);
		amp->setTuner(tuner);
	}
	public: virtual void endRadio() {
		std::cout << "Shutting down the tuner..." << std::endl;
		tuner->off();
		amp->off();
	}
};

} // namespace HomeTheater
} // namespace Facade
} // namespace HeadFirstDesignPatterns

#endif

