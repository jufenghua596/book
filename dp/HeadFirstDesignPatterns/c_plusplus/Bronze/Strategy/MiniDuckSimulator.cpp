#include "MiniDuckSimulator.hpp"

using namespace HeadFirstDesignPatterns::Strategy;

int main(int argc, char* argv[])
{
	MallardDuck mallard;
	mallard.display();
	mallard.performFly();
	mallard.performQuack();
	mallard.swim();

	RedHead redHead;
	redHead.display();
	redHead.performFly();
	redHead.performQuack();
	redHead.swim();

	RubberDuck rubberDuckie;
	rubberDuckie.display();
	rubberDuckie.performFly();
	rubberDuckie.performQuack();
	rubberDuckie.swim();

	DecoyDuck decoy;
	decoy.display();
	decoy.performFly();
	decoy.performQuack();
	decoy.swim();

	ModelDuck model;
	model.display();
	model.performFly();
	model.performQuack();
	model.swim();
	model.setFlyBehavior(new FlyRocketPowered());
	model.performFly();
	model.setQuackBehavior(new FakeQuack());
	model.performQuack();

	return 0;
}
