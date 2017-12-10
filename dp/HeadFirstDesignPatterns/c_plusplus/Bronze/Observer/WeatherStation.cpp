#include "WeatherStation.hpp"

using namespace HeadFirstDesignPatterns::Observer;

int main(int argc, char* argv[])
{
	WeatherData* weatherData = new WeatherData();

	CurrentConditionsDisplay* currentDisplay = 	new CurrentConditionsDisplay(weatherData);
	StatisticsDisplay* statisticsDisplay = new StatisticsDisplay(weatherData);
	ForecastDisplay* forecastDisplay = new ForecastDisplay(weatherData);

#ifdef _HEAT_INDEX_DISPLAY_
	HeatIndexDisplay* heatIndexDisplay = new HeatIndexDisplay(weatherData);
#endif

	weatherData->setMeasurements(80, 65, 30.4f);
	weatherData->setMeasurements(82, 70, 29.2f);
	weatherData->setMeasurements(78, 90, 29.2f);

	return 0;
}

