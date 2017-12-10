#include "Barista.hpp"

using namespace HeadFirstDesignPatterns::Template::Barista;

int main(int argc, char* argv[]) {
	Tea* tea = new Tea();
	Coffee* coffee = new Coffee();

	std::cout << std::endl << "Making tea..." << std::endl;
	tea->prepareRecipe();
 
	std::cout << std::endl << "Making coffee..." << std::endl;
	coffee->prepareRecipe();

	TeaWithHook* teaHook = new TeaWithHook();
	CoffeeWithHook* coffeeHook = new CoffeeWithHook();

	std::cout << std::endl << "Making tea..."<< std::endl;
	teaHook->prepareRecipe();

	std::cout << std::endl << "Making coffee..."<< std::endl;
	coffeeHook->prepareRecipe();

	return 0;
}