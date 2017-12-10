#include "Chocolate.hpp"

using namespace HeadFirstDesignPatterns::Factory::Singleton;

ChocolateBoiler* ChocolateBoiler::uniqueInstance = 0;

int main(int argc, char* argv[]) {
	ChocolateBoiler* boiler = ChocolateBoiler::getInstance();
	boiler->fill();
	boiler->boil();
	boiler->drain();

	// will return the existing instance
	ChocolateBoiler* boiler2 = ChocolateBoiler::getInstance();

	return 0;
}